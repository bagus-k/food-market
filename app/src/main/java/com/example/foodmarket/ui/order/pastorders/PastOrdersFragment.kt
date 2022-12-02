package com.example.foodmarket.ui.order.pastorders

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
import com.example.foodmarket.databinding.FragmentPastOrdersBinding
import com.example.foodmarket.databinding.FragmentProfileAccountBinding
import com.example.foodmarket.model.dummy.HomeModel
import com.example.foodmarket.model.dummy.HomeVerticalModel
import com.example.foodmarket.model.dummy.ProfileMenuModel
import com.example.foodmarket.model.response.transaction.Data
import com.example.foodmarket.ui.home.HomeAdapter
import com.example.foodmarket.ui.order.inprogress.InProgressAdapter
import com.example.foodmarket.ui.profile.ProfileMenuAdapter

class PastOrdersFragment : Fragment(), PastOrdersAdapter.ItemAdapterCallback {

    private var _binding: FragmentPastOrdersBinding? = null
    private var adapter: PastOrdersAdapter? = null
    var pastOrdersList: ArrayList<Data>? = ArrayList()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPastOrdersBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pastOrdersList = arguments?.getParcelableArrayList("data")

        if (!pastOrdersList.isNullOrEmpty()) {
            adapter = PastOrdersAdapter(pastOrdersList!!, this)
            val layoutManager = LinearLayoutManager(activity)
            binding.rvList.layoutManager = layoutManager
            binding.rvList.adapter = adapter
        }
    }

    override fun onClick(v: View, data: Data) {
        Toast.makeText(activity, "Click", Toast.LENGTH_SHORT).show()
    }

}