package com.example.api_kelompok8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.ArrayList

class MainActivity : ItemClickListener, AppCompatActivity() {

    private val list = ArrayList<PostResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "Dog Breed"

        var postAdapter = PostAdapter(list, this)

        val rvPost = findViewById<RecyclerView>(R.id.rvPost)
        rvPost.setHasFixedSize(true)
        rvPost.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getPosts().enqueue(object: Callback<ArrayList<PostResponse>>{
            override fun onResponse(
                call: Call<ArrayList<PostResponse>>,
                response: Response<ArrayList<PostResponse>>
            ) {
                response.body()?.let { list.addAll(it) }
                rvPost.adapter = postAdapter
                Log.i("debug", response.body().toString())
            }

            override fun onFailure(call: Call<ArrayList<PostResponse>>, t: Throwable) {
            }

        })


    }

    override fun onItemClickListener(position: Int) {
        val intent = Intent(this, DogInfo::class.java)
        intent.putExtra("breed_name", list[position].breed_name)
        intent.putExtra("image", list[position].image)
        intent.putExtra("description", list[position].description)
        startActivity(intent)
    }

//    fun onClickButton (breed_name : String?, image : String?, description : String?) {
//        val intent = Intent(this, DogInfo::class.java)
//        intent.putExtra("breed_name", breed_name)
//        intent.putExtra("image", image)
//        intent.putExtra("description", description)
//        startActivity(intent)
//    }
}
