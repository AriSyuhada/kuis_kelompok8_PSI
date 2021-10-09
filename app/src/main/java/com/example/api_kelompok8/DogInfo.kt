package com.example.api_kelompok8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DogInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_info)

        val breed_name = intent.getStringExtra("breed_name")
        val image_url = intent.getStringExtra("image")
        val description = intent.getStringExtra("description")

        findViewById<TextView>(R.id.breed_name_text).text = breed_name?.capitalize()
        findViewById<TextView>(R.id.descriptiion_text).text = description
        findViewById<TextView>(R.id.breed_name_desc).text = breed_name?.capitalize()

        title = breed_name?.capitalize()
        DownloadImageFromInternet(findViewById(R.id.dog_image), this).execute(image_url)
    }
}