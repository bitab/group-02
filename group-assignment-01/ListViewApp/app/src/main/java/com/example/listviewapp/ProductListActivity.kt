package com.example.listviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listviewapp.databinding.ActivityProductListBinding
import com.example.listviewapp.model.Product


class ProductListActivity : AppCompatActivity() {
    val products = arrayListOf<Product>().apply {
        add(Product("Organic Calm Tea", 8.00, "0001", R.drawable.product1, "Feeling frazzled and overwhelmed? Ease tensions away with warm, sweet spices that help create calm in both mind and body. All-organic licorice, cardamom, ginger, and cinnamon make a comforting tea that naturally soothes the stomach, helps with occasional bloating, and supports digestive health. Caffeine-free. Contains 20 tea bags, certified organic."))
        add(Product("Organic EnerGize Tea", 7.00, "0002", R.drawable.product2, "Feeling sluggish and unmotivated? Sometimes, a stimulating, spicy kick in your morning mug is all it takes to get going. This caffeine-free, peppery blend of all-organic ginger, clove, pepper, and other invigorating spices boosts digestive fire, promotes healthy circulation, helps with occasional bloating, and nourishes gut health. Contains 20 tea bags, certified organic. "))
        add(Product("Worry Free Tea", 9.00, "0003", R.drawable.product3, "Help calm your mind and emotions. Herb-and-spice blend formulated to help stabilize the emotions, calm the mind, and soothe frayed nerves; all-natural mint flavor."))
        add(Product("Slumber Time Tea", 11.00, "0004", R.drawable.product4, "Relax the mind for a better quality of sleep. Helps disengage the mind from the senses to fall asleep easily and wake up refreshed and alert."))
    }
    private lateinit var binding: ActivityProductListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rcv.layoutManager = LinearLayoutManager(this)
        binding.rcv.adapter = ProductListAdapter(this, products)
    }
}