package com.example.verify_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        val itemsList = findViewById<RecyclerView>(R.id.item_List)
        val items = arrayListOf<Item>()

        items.add(Item(1,"sofa","sofatitle","sofadesc","sofatext",1000))
        items.add(Item(2,"wheel","wheel title","wheel desc","wheel text",2000))
        items.add(Item(3,"washing_machine","washing machine title","washing machine desc","washing machine text",3000))

    }
}