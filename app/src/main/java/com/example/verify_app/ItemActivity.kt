package com.example.verify_app

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val title = findViewById<TextView>(R.id.item_title)
        val desc = findViewById<TextView>(R.id.item_desc)
        val image = findViewById<ImageView>(R.id.item_image)


        title.text = intent.getStringExtra("itemTitle")
        desc.text = intent.getStringExtra("itemDesc")
        image.setImageResource(intent.getStringExtra("itemImage")!!.toInt())

    }
}