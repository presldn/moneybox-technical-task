package com.example.minimoneybox.dagger2

import com.example.minimoneybox.viewmodels.IndividualAccountViewModel
import com.example.minimoneybox.viewmodels.UserAccountsViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    fun injectUserAccounts(userAccountsViewModel: UserAccountsViewModel)
    fun injectIndividualAccount(individualAccountViewModel: IndividualAccountViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}