package com.example.listviewapp

import android.R

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.example.listviewapp.databinding.ActivityDetailedBinding
import com.example.listviewapp.databinding.ActivityMainBinding
import com.example.listviewapp.model.Product


class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)
         val item_name = binding.itemName
         val item_price = binding.itemPrice
         val item_id= binding.itemId
         val desc= binding.benefits
        val item_image= binding.itemImage

        val title = intent.getStringExtra("title")
        val price = intent.getDoubleExtra("price",0.0)
        val id = intent.getStringExtra("item_id")
        val description = intent.getStringExtra("description")
        val image_id = intent.getIntExtra("item_image",0)



        item_name.text = title
        item_price.text ="Price: \$${price.toString()}"
        item_id.text= "Item Id: $id"
        desc.text= "Key Benefits: $description"
        item_image.setImageResource(image_id)

    }
}




