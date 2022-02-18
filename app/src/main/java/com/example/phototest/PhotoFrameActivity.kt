package com.example.phototest

import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

class PhotoFrameActivity: AppCompatActivity() {

    val photoList = mutableListOf<Uri>()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_photoframe)

        val size = intent.getIntExtra("photoListSize", 0)
        for(i in 0..size){
            intent.getStringExtra("photo$i")?.let {
                photoList.add(Uri.parse(it))
            }
        }
    }
}