package com.example.minimoneybox.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.example.minimoneybox.R
import com.example.minimoneybox.models.Payment
import com.example.minimoneybox.network.MoneyBoxApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class IndividualAccountViewModel : BaseViewModel() {
    private val TAG = "IndividualAccountViewMo"

    @Inject
    lateinit var moneyBoxApi: MoneyBoxApi

    private lateinit var subscription: Disposable

    private val _moneyAddedMessage = MutableLiveData<Int>()
    val moneyAddedMessage: LiveData<Int>
    get() = _moneyAddedMessage

    private val _errorMessage = MutableLiveData<Int>()
    val errorMessage: LiveData<Int>
        get() = _errorMessage

    private val _showProgress: MutableLiveData<Int> = MutableLiveData()
    val showProgress: LiveData<Int>
        get() = _showProgress

    fun addMoney(id: String, token: String) {
        subscription = moneyBoxApi.addMoney("Bearer $token",
            Payment(InvestorProductId = id)
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                _showProgress.postValue(R.string.add_money_progress)
            }
            .doOnTerminate {
                _showProgress.postValue(null)
            }
            .subscribe({
                _moneyAddedMessage.postValue(R.string.money_added)
                Log.d(TAG, "response: $it")
            }, { _errorMessage.postValue(R.string.error_message) }
            )
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

}