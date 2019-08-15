package com.example.minimoneybox.viewmodels

import android.arch.lifecycle.ViewModel
import com.example.minimoneybox.dagger2.DaggerViewModelInjector
import com.example.minimoneybox.dagger2.NetworkModule
import com.example.minimoneybox.dagger2.ViewModelInjector

abstract class BaseViewModel : ViewModel() {
    private val injector: ViewModelInjector = DaggerViewModelInjector.builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is UserAccountsViewModel -> {
                injector.injectUserAccounts(this)
            }
            is IndividualAccountViewModel -> {
                injector.injectIndividualAccount(this)
            }
        }
    }

}
