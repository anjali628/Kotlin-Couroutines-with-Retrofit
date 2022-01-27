package com.example.kotlincouroutineswithretrofit.Repository

import com.example.kotlincouroutineswithretrofit.Model.Post
import com.example.kotlincouroutineswithretrofit.Network.RetrofitBuilder

class PostRepository  {


    suspend fun getPost():List<Post> = RetrofitBuilder.api.getPost()


}