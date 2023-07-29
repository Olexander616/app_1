package com.example.verify_app

import android.content.Context
import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.coroutines.coroutineContext

class ItemsAdapter(var items: List<Item>, var context: Context): RecyclerView.Adapter<ItemsAdapter.MyViewHolder>() {

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val image = view.findViewById<ImageView>(R.id.imageView)
        val title = view.findViewById<TextView>(R.id.textView_title)
        val desc = view.findViewById<TextView>(R.id.textView_desc)
        val price = view.findViewById<TextView>(R.id.textView_Price)
        val btn = view.findViewById<Button>(R.id.button2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_int_list,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = items[position].title
        holder.desc.text = items[position].desc
        holder.price.text = items[position].price.toString()

        val imageId = context.resources.getIdentifier(
            items[position].image, "drawable", context.packageName)
        holder.image.setImageResource(imageId)

        holder.btn.setOnClickListener{
            val intetnt = Intent(context,ItemActivity::class.java)

            intetnt.putExtra("itemTitle",items[position].title)
            intetnt.putExtra("itemDesc",items[position].desc)
            intetnt.putExtra("itemImage",imageId.toString())

            context.startActivity(intetnt)
        }
    }
}