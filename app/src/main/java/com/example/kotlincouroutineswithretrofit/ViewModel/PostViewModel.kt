package com.example.kotlincouroutineswithretrofit.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlincouroutineswithretrofit.Model.Post
import com.example.kotlincouroutineswithretrofit.Repository.PostRepository
import kotlinx.coroutines.launch
import retrofit2.http.POST
import java.lang.Exception

class PostViewModel(private val postRepository: PostRepository) :ViewModel(){

    val postMutableLiveData:MutableLiveData<List<Post>> = MutableLiveData()

    fun getPost()
    {
        viewModelScope.launch {

            try{
            val response=postRepository.getPost()
            postMutableLiveData.value=response

        }
            catch (e:Exception){
                Log.d("main","getPost: ${e.message}")

            }            }
    }


}