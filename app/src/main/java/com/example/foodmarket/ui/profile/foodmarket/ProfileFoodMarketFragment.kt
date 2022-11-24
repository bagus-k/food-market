package com.example.foodmarket.ui.profile.foodmarket

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
import com.example.foodmarket.databinding.FragmentProfileAccountBinding
import com.example.foodmarket.model.dummy.HomeVerticalModel
import com.example.foodmarket.model.dummy.ProfileMenuModel
import com.example.foodmarket.ui.profile.ProfileMenuAdapter

class ProfileFoodMarketFragment : Fragment(), ProfileMenuAdapter.ItemAdapterCallback {

    private var _binding: FragmentProfileAccountBinding? = null
    private var menuArrayList: ArrayList<ProfileMenuModel> = ArrayList()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileAccountBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDataDummy()
        var adapter = ProfileMenuAdapter(menuArrayList,this)
        var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
        binding.rvList.layoutManager = layoutManager
        binding.rvList.adapter = adapter
    }

    fun initDataDummy() {
        menuArrayList = ArrayList()
        menuArrayList.add(ProfileMenuModel("Rate Apps"))
        menuArrayList.add(ProfileMenuModel("Help Center"))
        menuArrayList.add(ProfileMenuModel("Privacy & Policy"))
        menuArrayList.add(ProfileMenuModel("Term & Conditions"))
    }

    override fun onClick(v: View, data: ProfileMenuModel) {
        Toast.makeText(context, "test click", Toast.LENGTH_LONG).show()
    }
}