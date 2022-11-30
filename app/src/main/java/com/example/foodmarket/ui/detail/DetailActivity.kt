package com.example.foodmarket.ui.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.foodmarket.R
import com.example.foodmarket.databinding.ActivityDetailBinding
import com.example.foodmarket.databinding.ActivityMainBinding
import com.example.foodmarket.ui.MainActivity

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.includeToolbar.toolbar.visibility = View.GONE


        intent.extras?.let {
            val navController = Navigation.findNavController(findViewById(R.id.detailHostFragment))
            val bundle = Bundle()
            bundle.putParcelable("data", it.get("data") as Parcelable?)
            Log.e("TEST", bundle.toString())
            navController.setGraph(navController.graph, bundle)
            navController.navigate(R.id.fragment_detail,bundle)
        }
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

    override fun onBackPressed() {
//        super.onBackPressed()
        startActivity(Intent(this,MainActivity::class.java))
    }
}