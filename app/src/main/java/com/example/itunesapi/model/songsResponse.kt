package com.example.itunesapi.model

import com.google.gson.annotations.SerializedName

data class songResponse(
    val results: List<songs>
)

data class songs(
    val artistName : String,
    val trackName : String,
    val artworkUrl60 : String,
    val trackPrice : String,
    val previewUrl : String
)


