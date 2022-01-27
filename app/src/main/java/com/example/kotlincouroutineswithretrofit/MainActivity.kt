package com.example.kotlincouroutineswithretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.AdapterListUpdateCallback
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincouroutineswithretrofit.Adapter.PostAdapter
import com.example.kotlincouroutineswithretrofit.Model.Post
import com.example.kotlincouroutineswithretrofit.Repository.PostRepository
import com.example.kotlincouroutineswithretrofit.ViewModel.PostViewModel
import com.example.kotlincouroutineswithretrofit.ViewModel.PostViewModelFactory
import com.example.kotlincouroutineswithretrofit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter

    private lateinit var postViewModel: PostViewModel

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initRecyclerView()

        val postRepository=PostRepository()
        val viewModelFactory=PostViewModelFactory(postRepository)
        postViewModel=ViewModelProvider(this,viewModelFactory)[PostViewModel::class.java]
        postViewModel.getPost()
        postViewModel.postMutableLiveData.observe(this, Observer {
            postAdapter.setData(it as ArrayList<Post>)


            binding.progressBar.visibility=View.INVISIBLE

            binding.recyclerView.visibility=View.VISIBLE
        })

    }

    private fun initRecyclerView() {

            recyclerView=findViewById(R.id.recyclerView)
            postAdapter= PostAdapter(this, ArrayList())
            recyclerView.apply {
                setHasFixedSize(true)
                layoutManager=LinearLayoutManager(this@MainActivity)
                adapter=postAdapter

            }

    }

}