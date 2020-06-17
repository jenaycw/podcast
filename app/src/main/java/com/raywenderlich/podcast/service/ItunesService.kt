package com.raywenderlich.podcast.service

import android.telecom.Call

interface ItunesService{
    @GET("/search?media=podcast")
    fun searchPodcastByTerm(@Query("term")term: String):
            Call<PodcastResponse>
    companion object{
        val instance: ItunesService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://itunes.apple.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create<ItunesService>(ItunesService::class.java)
        }
    }
}