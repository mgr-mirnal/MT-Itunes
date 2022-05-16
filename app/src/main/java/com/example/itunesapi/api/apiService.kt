package com.example.itunesapi.api

import com.example.itunesapi.model.songResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface apiService {

    @GET("search?term=classic&amp;media=music&entity=song&limit=50")
    fun getClassicSongs(
    ): Call<songResponse>

    @GET("search?term=rock&amp;media=music&entity=song&limit=50")
    fun getRockSongs(
    ): Call<songResponse>

    @GET("search?term=pop&amp;media=music&entity=song&limit=50")
    fun getPopSongs(
    ): Call<songResponse>

    companion object{
        private const val BASE_URL = "https://itunes.apple.com/"
        var instance: Retrofit? = null

        fun createRetrofit(): Retrofit{
            if(instance == null){
                instance = Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            return  instance!!
        }
    }
}