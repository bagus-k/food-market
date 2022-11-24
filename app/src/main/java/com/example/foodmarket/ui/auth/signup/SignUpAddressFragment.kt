package com.example.foodmarket.ui.auth.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.foodmarket.R
import com.example.foodmarket.databinding.FragmentSignUpAddressBinding
import com.example.foodmarket.databinding.FragmentSignUpBinding
import com.example.foodmarket.ui.auth.AuthActivity

class SignUpAddressFragment : Fragment() {

    private lateinit var binding : FragmentSignUpAddressBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignUpAddressBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSignUpNow.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_sign_up_success, null)

            (activity as AuthActivity).toolbarSignUpSuccess()
        }
    }

}