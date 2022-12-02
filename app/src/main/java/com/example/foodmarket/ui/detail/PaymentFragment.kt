package com.example.foodmarket.ui.detail

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.foodmarket.FoodMarket
import com.example.foodmarket.R
import com.example.foodmarket.databinding.FragmentDetailBinding
import com.example.foodmarket.databinding.FragmentPaymentBinding
import com.example.foodmarket.model.response.checkout.CheckoutResponse
import com.example.foodmarket.model.response.home.Data
import com.example.foodmarket.model.response.login.User
import com.example.foodmarket.utils.Helpers.formatPrice
import com.google.gson.Gson

class PaymentFragment : Fragment(), PaymentContract.View {

    private lateinit var binding: FragmentPaymentBinding
    var total: Int = 0
    var progressDialog: Dialog? = null
    private lateinit var presenter: PaymentPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPaymentBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as DetailActivity).toolbarPayment()

        var data = arguments?.getParcelable<Data>("data")
        initView(data)
        initView()
        presenter = PaymentPresenter(this)
    }

    private fun initView() {
        progressDialog = Dialog(requireContext())
        val dialogLayout = layoutInflater.inflate(R.layout.dialog_loader, null)

        progressDialog?.let {
            it.setContentView(dialogLayout)
            it.setCancelable(false)
            it.window?.setBackgroundDrawableResource(android.R.color.transparent)
        }
    }

    private fun initView(data: Data?) {
        binding.tvItemName.text = data?.name
        if (data?.price != null) {
            binding.tvItemPrice.formatPrice(data.price.toString())
            binding.tvTotalItemPrice.formatPrice(data.price.toString())

            var totalTax = data.price.div(10)
            binding.tvTaxPrice.formatPrice(totalTax.toString())

            total = data.price+totalTax+50000
            binding.tvTotalPrice.formatPrice(total.toString())
        } else {
            binding.tvItemPrice.text = "IDR. 0"
            binding.tvTotalItemPrice.text = "IDR. 0"
            binding.tvTaxPrice.text = "IDR. 0"
            binding.tvTotalPrice.text = "IDR. 0"
        }
        Glide.with(requireContext())
            .load(data?.picturePath)
            .into(binding.imgIcon)
        binding.tvDetailName.text = data?.name

        var user = FoodMarket.getApp().getUser()
        var userResponse = Gson().fromJson(user, User::class.java)
        binding.tvNameValue.text = userResponse.name
        binding.tvPhoneNoValue.text = userResponse.phoneNumber
        binding.tvAddressValue.text = userResponse.address
        binding.tvHouseNoValue.text = userResponse.houseNumber
        binding.tvCityValue.text = userResponse.city

        binding.btnCheckout.setOnClickListener {
            presenter.getCheckout(
                data?.id.toString(),
                userResponse?.id.toString(),
                "1",
                total.toString(),
                it
            )

        }
    }

    override fun onCheckoutSuccess(checkoutResponse: CheckoutResponse, view: View) {

//        Handler().postDelayed({
//            Log.e("MIDTRANS", checkoutResponse.toString())
//        },2000)



        if (!checkoutResponse.paymentUrl.isNullOrEmpty()) {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(checkoutResponse.paymentUrl)
            startActivity(intent)
        }

        Navigation.findNavController(view).navigate(R.id.action_payment_success)
    }

    override fun onCheckoutFailed(message: String) {
        Toast.makeText(requireActivity(), message, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        progressDialog?.show()
    }

    override fun dismissLoading() {
        progressDialog?.dismiss()

    }
}