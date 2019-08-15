package com.example.minimoneybox.dagger2

import com.example.minimoneybox.utils.BASE_URL
import com.example.minimoneybox.network.MoneyBoxApi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
@Suppress("unused")
object NetworkModule {
    @Provides
    @Reusable
    @JvmStatic
    internal fun getMoneyBoxApi(retrofit: Retrofit): MoneyBoxApi {
        return retrofit.create(MoneyBoxApi::class.java)
    }


    @Provides
    @Reusable
    @JvmStatic
    internal fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }

}