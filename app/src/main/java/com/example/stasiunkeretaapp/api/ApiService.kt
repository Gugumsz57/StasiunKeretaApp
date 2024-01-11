package com.example.stasiunkeretaapp.api

import com.example.stasiunkeretaapp.ResponseStasiun
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("stations2")
    fun getStasiun(): Call<List<ResponseStasiun>>
}