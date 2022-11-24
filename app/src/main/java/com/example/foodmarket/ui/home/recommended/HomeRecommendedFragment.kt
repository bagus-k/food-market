package com.example.foodmarket.ui.home.recommended

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodmarket.R
import com.example.foodmarket.databinding.FragmentHomeNewTasteBinding
import com.example.foodmarket.model.dummy.HomeVerticalModel
import com.example.foodmarket.ui.detail.DetailActivity
import com.example.foodmarket.ui.home.newtaste.HomeNewTasteAdapter

class HomeRecommendedFragment : Fragment(), HomeNewTasteAdapter.ItemAdapterCallback {

    private var _binding: FragmentHomeNewTasteBinding? = null
    private var foodList: ArrayList<HomeVerticalModel> = ArrayList()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeNewTasteBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDataDummy()

        var adapter = HomeNewTasteAdapter(foodList,this)
        var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
        binding.rvList.layoutManager = layoutManager
        binding.rvList.adapter = adapter

    }

    fun initDataDummy() {
        foodList = ArrayList()
        foodList.add(HomeVerticalModel("Cherry","10000","",5f))
        foodList.add(HomeVerticalModel("Burger","15000","",4f))
        foodList.add(HomeVerticalModel("Bakwan","20000","",4.5f))
    }

    override fun onClick(v: View, data: HomeVerticalModel) {
        val detail = Intent(activity, DetailActivity::class.java)
        startActivity(detail)
    }
}