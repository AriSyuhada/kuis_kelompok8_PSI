package com.example.api_kelompok8

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.util.Log
import android.widget.ImageView
import android.widget.Toast

@SuppressLint("StaticFieldLeak")
@Suppress("DEPRECATION")
class DownloadImageFromInternet(var imageView: ImageView, var context : Context) : AsyncTask<String, Void, Bitmap?>() {
    init {
        Toast.makeText(context, "Please wait, it may take a few minute...",     Toast.LENGTH_SHORT).show()
    }
    override fun doInBackground(vararg urls: String): Bitmap? {
        val imageURL = urls[0]
        var image: Bitmap? = null
        try {
            val `in` = java.net.URL(imageURL).openStream()
            image = BitmapFactory.decodeStream(`in`)
        }
        catch (e: Exception) {
            Log.e("Error Message", e.message.toString())
            e.printStackTrace()
        }
        return image
    }
    override fun onPostExecute(result: Bitmap?) {
        imageView.setImageBitmap(result)
    }
}
