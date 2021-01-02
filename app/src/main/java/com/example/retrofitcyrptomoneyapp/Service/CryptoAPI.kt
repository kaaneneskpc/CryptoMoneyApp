package com.example.retrofitcyrptomoneyapp.Service

import com.example.retrofitcyrptomoneyapp.Model.CryptoModel
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface CryptoAPI {

    //GET , POST ,UPDATE ,DELETE

    @GET("prices?key=828a4b6a1be90600e87823d8f001ac95")
     fun getData() :Observable<List<CryptoModel>>
     //fun getData():Call<List<CryptoModel>>
}