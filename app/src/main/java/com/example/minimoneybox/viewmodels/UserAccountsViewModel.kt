package com.example.minimoneybox.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import android.view.View
import com.example.minimoneybox.R
import com.example.minimoneybox.models.InvestorProductsResponse
import com.example.minimoneybox.models.LoginCredentials
import com.example.minimoneybox.models.User
import com.example.minimoneybox.network.MoneyBoxApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserAccountsViewModel : BaseViewModel() {
    private val TAG = "UserAccountsViewModel"

    @Inject
    lateinit var moneyBoxApi: MoneyBoxApi

    private lateinit var subscription: Disposable

    private val _progressMessage: MutableLiveData<Int> = MutableLiveData()
    val progressMessage: LiveData<Int>
        get() = _progressMessage

    private val _errorMessage: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: LiveData<Int>
    get() = _errorMessage

    val errorClickListener = View.OnClickListener { getInvestorProducts(token) }

    private val _investmentData = MutableLiveData<InvestorProductsResponse>()
    val investmentData: LiveData<InvestorProductsResponse>
        get() = _investmentData

    private val _user = MutableLiveData<User>()
    val user: LiveData<User>
        get() = _user

    lateinit var token: String


    init {
        authenticate()
    }

    private fun getInvestorProducts(token: String) {
        subscription = moneyBoxApi
            .getInvestorProducts(token)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                _progressMessage.postValue(R.string.getting_products_message)
                _errorMessage.postValue(null)
            }
            .doOnTerminate {
                _progressMessage.postValue(null)
            }
            .subscribe({
                _investmentData.postValue(it)
                Log.d(TAG, "response: $it")

            }, {
                _errorMessage.postValue(R.string.products_error)
            })
    }

    private fun authenticate() {
        subscription = moneyBoxApi
            .authenticate(LoginCredentials())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { data ->
                Log.d(TAG, "response: $data")
                _user.postValue(data.User)
                token = data.Session.BearerToken
                getInvestorProducts("Bearer ${data.Session.BearerToken}")
            }
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

}