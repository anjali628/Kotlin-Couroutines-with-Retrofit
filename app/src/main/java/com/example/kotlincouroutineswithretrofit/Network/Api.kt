package com.example.kotlincouroutineswithretrofit.Network

import com.example.kotlincouroutineswithretrofit.Model.Post
import retrofit2.http.GET

interface Api {

    @GET("posts")

    suspend fun getPost():List<Post>

}