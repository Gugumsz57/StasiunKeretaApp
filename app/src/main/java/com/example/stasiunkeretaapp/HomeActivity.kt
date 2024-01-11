package com.example.stasiunkeretaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stasiunkeretaapp.api.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val apiService = ApiConfig.apiService
        val call = apiService.getStasiun()

        val recyclerView: RecyclerView = findViewById(R.id.rv_kereta)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val keretaAdapter = StasiunAdapter(emptyList())
        recyclerView.adapter = keretaAdapter

        call.enqueue(object : Callback<List<ResponseStasiun>> {
            override fun onResponse(call: Call<List<ResponseStasiun>>, response: Response<List<ResponseStasiun>>) {
                if (response.isSuccessful) {
                    val StasiunList = response.body()
                    // Process the data here
                    Log.d("Pesantren", StasiunList.toString())
                    // Set adapter untuk RecyclerView
                    val adapter = StasiunAdapter(StasiunList!!)
                    recyclerView.adapter = adapter
                } else {
                    // Handle error
                }
            }

            override fun onFailure(call: Call<List<ResponseStasiun>>, t: Throwable) {
                // Handle failure
            }
        })

    }
}