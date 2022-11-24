package com.example.foodmarket.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.foodmarket.R
import com.example.foodmarket.databinding.ActivityDetailBinding
import com.example.foodmarket.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.includeToolbar.toolbar.visibility = View.GONE
    }

    fun toolbarDetail() {
        binding.includeToolbar.toolbar.visibility = View.GONE
    }

    fun toolbarPayment() {
        binding.includeToolbar.toolbar.visibility = View.VISIBLE
        binding.includeToolbar.toolbar.title = "Payment"
        binding.includeToolbar.toolbar.subtitle = "You deserve better meal"
        binding.includeToolbar.toolbar.navigationIcon = resources.getDrawable(R.drawable.ic_arrow_back_000, null)
        binding.includeToolbar.toolbar.setNavigationOnClickListener { onBackPressed() }
    }

//    fun toolbarDetail1() {
//        binding.includeToolbar.toolbar.visibility = View.GONE
//    }
}