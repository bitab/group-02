package com.example.listviewapp

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.listviewapp.databinding.ActivityBookBinding
import com.example.listviewapp.databinding.ActivityMainBinding

class BookActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBookBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intt = intent // Similar to  Intent intent = getIntent()
        val output = intt.getStringArrayExtra("books")

        output?.let {
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, it)
            binding.lview.adapter = adapter
        }
    }
}