package com.example.foodmarket.ui.order.inprogress

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
import com.example.foodmarket.databinding.FragmentInProgressBinding
import com.example.foodmarket.databinding.FragmentProfileAccountBinding
import com.example.foodmarket.model.dummy.HomeModel
import com.example.foodmarket.model.dummy.HomeVerticalModel
import com.example.foodmarket.model.dummy.ProfileMenuModel
import com.example.foodmarket.model.response.transaction.Data
import com.example.foodmarket.ui.home.HomeAdapter
import com.example.foodmarket.ui.profile.ProfileMenuAdapter

class InProgressFragment : Fragment(), InProgressAdapter.ItemAdapterCallback {

    private var _binding: FragmentInProgressBinding? = null
    private var adapter: InProgressAdapter? = null
    var inProgressList: ArrayList<Data>? = ArrayList()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInProgressBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        inProgressList = arguments?.getParcelableArrayList("data")

        if (!inProgressList.isNullOrEmpty()) {
            adapter = InProgressAdapter(inProgressList!!, this)
            val layoutManager = LinearLayoutManager(activity)
            binding.rvList.layoutManager = layoutManager
            binding.rvList.adapter = adapter
        }
    }

    override fun onClick(v: View, data: Data) {
        Toast.makeText(activity, "Click", Toast.LENGTH_SHORT).show()
    }

}