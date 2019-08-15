package com.example.minimoneybox.network

import com.example.minimoneybox.models.Payment
import com.example.minimoneybox.models.InvestorProductsResponse
import com.example.minimoneybox.models.LoginCredentials
import com.example.minimoneybox.models.LoginResponse
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.*

interface MoneyBoxApi {

    @Headers(
        value = [
            "AppId: 3a97b932a9d449c981b595",
            "Content-Type: application/json",
            "appVersion: 5.10.0",
            "apiVersion: 3.0.0"]
    )
    @POST("/users/login")
    fun authenticate(@Body loginCredentials: LoginCredentials): Observable<LoginResponse>

    @Headers(
        value = [
            "AppId: 3a97b932a9d449c981b595",
            "Content-Type: application/json",
            "appVersion: 5.10.0",
            "apiVersion: 3.0.0"]
    )
    @GET("/investorproducts")
    fun getInvestorProducts(@Header("Authorization") authorization: String): Observable<InvestorProductsResponse>

    @Headers(
        value = [
            "AppId: 3a97b932a9d449c981b595",
            "Content-Type: application/json",
            "appVersion: 5.10.0",
            "apiVersion: 3.0.0"]
    )
    @POST("/oneoffpayments")
    fun addMoney(@Header("Authorization") authorization: String, @Body payment: Payment): Observable<ResponseBody>
}