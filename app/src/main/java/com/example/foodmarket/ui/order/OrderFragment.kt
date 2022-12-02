package com.example.foodmarket.ui.order

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.foodmarket.R
import com.example.foodmarket.databinding.FragmentOrderBinding
import com.example.foodmarket.model.response.transaction.Data
import com.example.foodmarket.model.response.transaction.TransactionResponse

class OrderFragment : Fragment(), OrderContract.View {

    private var _binding: FragmentOrderBinding? = null
    lateinit var presenter: OrderPresenter
    var progressDialog: Dialog? = null
    var inProgressList: ArrayList<Data>? = ArrayList()
    var pastOrdersList: ArrayList<Data>? = ArrayList()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOrderBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        presenter = OrderPresenter(this)
        presenter.getTransaction()
    }

    private fun initView() {
        progressDialog = Dialog(requireContext())
        val dialogLayout = layoutInflater.inflate(R.layout.dialog_loader, null)

        progressDialog?.let {
            it.setContentView(dialogLayout)
            it.setCancelable(false)
            it.window?.setBackgroundDrawableResource(android.R.color.transparent)
        }

        binding.includeToolbar.toolbar.title = "Your Orders"
        binding.includeToolbar.toolbar.subtitle = "Wait for the best meal"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onTransactionSuccess(transactionResponse: TransactionResponse) {
        if (transactionResponse.data.isNullOrEmpty()) {
            binding.llEmpty.visibility = View.VISIBLE
            binding.clTab.visibility = View.VISIBLE
            binding.includeToolbar.toolbar.visibility = View.GONE
        } else {
            for (a in transactionResponse.data.indices) {
                if (transactionResponse.data[a]?.status.equals("ON_DELIVERY") || transactionResponse.data[a]?.status.equals("PENDING")) {
                    inProgressList?.add(transactionResponse.data[a]!!)
                } else if (transactionResponse.data[a]?.status.equals("DELIVERED")
                    || transactionResponse.data[a]?.status.equals("CANCELLED")
                    || transactionResponse.data[a]?.status.equals("SUCCESS")) {
                    pastOrdersList?.add(transactionResponse.data[a]!!)
                }
            }

            val sectionPagerAdapter = SectionPagerAdapter(
                childFragmentManager
            )
            sectionPagerAdapter.setData(inProgressList, pastOrdersList)
            binding.viewPager.adapter = sectionPagerAdapter
            binding.tabLayout.setupWithViewPager(binding.viewPager)
        }
    }

    override fun onTransactionFailed(message: String) {
       Toast.makeText(requireActivity(),message,Toast.LENGTH_SHORT).show()
        Log.e("ORDER",message)
    }

    override fun showLoading() {
        progressDialog?.show()
    }

    override fun dismissLoading() {
        progressDialog?.dismiss()
    }
}