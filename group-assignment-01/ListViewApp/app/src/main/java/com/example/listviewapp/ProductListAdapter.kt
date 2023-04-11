package com.example.listviewapp

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.listviewapp.databinding.ItemViewBinding
import com.example.listviewapp.model.Product
import java.io.ByteArrayOutputStream
import java.util.*
import kotlin.collections.ArrayList

class ProductListAdapter(val context: Context, private val productList: ArrayList<Product> ) : RecyclerView.Adapter<ProductListAdapter.ProductListViewHolder>() {
    private lateinit var binding: ItemViewBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        val formatter = Formatter(Locale.US)
        holder.binding.imageView.setImageResource(productList[position].image)
        holder.binding.tvTitle.text = productList[position].title.toString()
        holder.binding.tvPrice.text = formatter.format("$%, .2f",productList[position].price).toString()

        holder.itemView.setOnClickListener{
         val intent = Intent(it.context, DetailsActivity::class.java)
            intent.putExtra("title", productList[position].title)
            intent.putExtra("price", productList[position].price)
            intent.putExtra("item_id", productList[position].itemId)
            intent.putExtra("description", productList[position].desc)
            intent.putExtra("item_image", productList[position].image)
            it.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return this.productList.size
    }
    inner class ProductListViewHolder(val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root){


    }
}