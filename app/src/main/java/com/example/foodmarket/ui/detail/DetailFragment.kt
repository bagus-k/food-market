package com.example.foodmarket.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.foodmarket.R
import com.example.foodmarket.databinding.FragmentDetailBinding
import com.example.foodmarket.model.response.home.Data
import com.example.foodmarket.utils.Helpers.formatPrice

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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as DetailActivity).toolbarDetail()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            DetailFragmentArgs.fromBundle(it).data.let {
                initView(it)
//                Log.e("TEST_DETAIL", it.toString())
            }
        }

        binding.btnOrderNow.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_payment)
        }
    }

    private fun initView(data: Data?) {
        Glide.with(requireActivity())
            .load(data?.picturePath)
            .into(binding.imgPoster)

        binding.tvTitle.text = data?.name
        binding.ratingBar.rating = data?.rate?.toFloat() ?: 0f
        binding.tvDesc.text = data?.description
        binding.tvIngredientsDesc.text = data?.ingredients
        if (data?.price != null) {
            binding.tvPrice.formatPrice(data.price.toString())
        }
    }
}