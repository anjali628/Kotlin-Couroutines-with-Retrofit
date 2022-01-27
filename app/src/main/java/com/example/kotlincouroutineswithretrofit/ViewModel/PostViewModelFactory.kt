package com.example.kotlincouroutineswithretrofit.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlincouroutineswithretrofit.Repository.PostRepository

class PostViewModelFactory(private val postRepository: PostRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return PostViewModel(postRepository) as T

        //This is the retrofit demo
        //this is the demo project

    }
}