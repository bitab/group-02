package com.example.listviewapp

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.listviewapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var books  = arrayOf<String>("Maharishi", "Dr Tony Nader", "Scientific Research Consciousness, Knowledge and Enlightenment ", "Modern Science and Verdic Science", "Book Series", "Other Series", "Clearance")

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.book.setOnClickListener {

            val intent = Intent(this, BookActivity::class.java)
            intent.putExtra("books", books)
            startActivity(intent)
        }

        binding.imageView4.setOnClickListener {
            startActivity(Intent(this, ProductListActivity::class.java))
        }

    }
}