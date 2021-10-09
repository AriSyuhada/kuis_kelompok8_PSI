package com.example.api_kelompok8

import android.content.SharedPreferences
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter (private val list: ArrayList<PostResponse>, private val itemClickListener: ItemClickListener): RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    inner class PostViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(postResponse: PostResponse) {
            with(itemView) {
                val text = postResponse.breed_name?.capitalize()
//                    "breed_id: ${postResponse.breed_id}\n"
//                    "image: ${postResponse.image}\n" +
//                    "description: ${postResponse.description}"

                val tvButton = findViewById<TextView>(R.id.tvText)
                tvButton.text = text
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(list[position])

        holder.itemView.setOnClickListener {
            itemClickListener.onItemClickListener(position)
        }

    }

    override fun getItemCount(): Int = list.size
}