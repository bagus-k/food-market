package com.example.foodmarket.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.example.foodmarket.R
import com.example.foodmarket.databinding.ActivityAuthBinding
import com.example.foodmarket.databinding.FragmentSignUpBinding
import com.example.foodmarket.databinding.LayoutToolbarBinding

class AuthActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pageRequest = intent.getIntExtra("page_request",0)
        if (pageRequest == 2) {
            toolbarSignUp()
            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.fragmentSignIn, true)
                .build()

            Navigation.findNavController(findViewById(R.id.authNavhostFragment))
                .navigate(R.id.action_sign_up, null, navOptions)
        }
    }

    fun toolbarSignUp() {
        binding.toolbarAuth.toolbar.title = "Sign Up"
        binding.toolbarAuth.toolbar.subtitle = "Register and eat"
        binding.toolbarAuth.toolbar.navigationIcon = resources.getDrawable(R.drawable.ic_arrow_back_000, null)
        binding.toolbarAuth.toolbar.setNavigationOnClickListener { onBackPressed() }
    }

    fun toolbarSignUpAddress() {
        binding.toolbarAuth.toolbar.title = "Address"
        binding.toolbarAuth.toolbar.subtitle = "Make sure is valid"
        binding.toolbarAuth.toolbar.navigationIcon = resources.getDrawable(R.drawable.ic_arrow_back_000, null)
        binding.toolbarAuth.toolbar.setNavigationOnClickListener { onBackPressed() }
    }

    fun toolbarSignUpSuccess() {
        binding.toolbarAuth.toolbar.visibility = View.GONE
    }
}