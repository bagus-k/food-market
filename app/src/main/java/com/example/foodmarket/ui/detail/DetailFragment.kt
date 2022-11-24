package com.example.foodmarket.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.foodmarket.R
import com.example.foodmarket.databinding.FragmentDetailBinding
import com.example.foodmarket.databinding.FragmentHomeNewTasteBinding
import com.example.foodmarket.model.dummy.HomeVerticalModel

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        (activity as DetailActivity).toolbarDetail()

        binding.btnOrderNow.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_payment)
        }
    }
}