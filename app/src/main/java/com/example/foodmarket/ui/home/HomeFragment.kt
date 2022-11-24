package com.example.foodmarket.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodmarket.databinding.FragmentHomeBinding
import com.example.foodmarket.model.dummy.HomeModel
import com.example.foodmarket.ui.detail.DetailActivity

class HomeFragment : Fragment(), HomeAdapter.ItemAdapterCallback {

    private var _binding: FragmentHomeBinding? = null
    private var foodList: ArrayList<HomeModel> = ArrayList()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDataDummy()
        var adapter = HomeAdapter(foodList,this)
        var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvList.layoutManager = layoutManager
        binding.rvList.adapter = adapter

        val sectionPagerAdapter = SectionPagerAdapter(
            childFragmentManager
        )
        binding.viewPager.adapter = sectionPagerAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }

    fun initDataDummy() {
        foodList = ArrayList()
        foodList.add(HomeModel("Cherry","",5f))
        foodList.add(HomeModel("Burger","",4f))
        foodList.add(HomeModel("Bakwan","",4.5f))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View, data: HomeModel) {
        val detail = Intent(activity, DetailActivity::class.java)
        startActivity(detail)
    }
}