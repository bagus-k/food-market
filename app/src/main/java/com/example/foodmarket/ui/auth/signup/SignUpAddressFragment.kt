package com.example.foodmarket.ui.auth.signup

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.foodmarket.FoodMarket
import com.example.foodmarket.R
import com.example.foodmarket.databinding.FragmentSignUpAddressBinding
import com.example.foodmarket.databinding.FragmentSignUpBinding
import com.example.foodmarket.model.request.RegisterRequest
import com.example.foodmarket.model.response.login.LoginResponse
import com.example.foodmarket.ui.MainActivity
import com.example.foodmarket.ui.auth.AuthActivity
import com.google.gson.Gson

class SignUpAddressFragment : Fragment(), SignUpContract.View {

    private lateinit var binding : FragmentSignUpAddressBinding
    private lateinit var data: RegisterRequest
    lateinit var presenter: SignUpPresenter
    var progressDialog: Dialog? = null

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

        presenter = SignUpPresenter(this)
        data = arguments?.getParcelable<RegisterRequest>("data")!!

        initDummy()
        initListener()
        initView()

    }

    private fun initListener() {

        binding.btnSignUpNow.setOnClickListener {

            var phoneNo = binding.edtPhoneNo.text.toString()
            var address = binding.edtAddress.text.toString()
            var houseNo = binding.edtHouseNo.text.toString()
            var city = binding.edtCity.text.toString()

            data.let {
                it.address = address
                it.city = city
                it.houseNumber = houseNo
                it.phoneNumber = phoneNo
            }

            if (phoneNo.isNullOrEmpty()) {
                binding.edtPhoneNo.setError("Silahkan masukkan phone number")
            } else if (address.isNullOrEmpty()) {
                binding.edtAddress.setError("Silahkan masukkan address")
            } else if (houseNo.isNullOrEmpty()) {
                binding.edtHouseNo.setError("Silahkan masukkan house number")
            } else if (city.isNullOrEmpty()) {
                binding.edtCity.setError("Silahkan masukkan city")
            } else {
                presenter.submitRegister(data, it)
//                presenter.submitPhotoRegister(data.profilePhotoPath!!, it)
            }
        }
    }

    private fun initDummy() {
        binding.edtPhoneNo.setText("12345678")
        binding.edtAddress.setText("Jl. Gajah Mada")
        binding.edtHouseNo.setText("10 A")
        binding.edtCity.setText("Depok")
    }

    override fun onRegisterSuccess(loginResponse: LoginResponse, view: View) {
        FoodMarket.getApp().setToken(loginResponse.accessToken)

        val gson = Gson()
        val json = gson.toJson(loginResponse.user)
        FoodMarket.getApp().setUser(json)

       if (data.profilePhotoPath == null) {
           Navigation.findNavController(view)
               .navigate(R.id.action_sign_up_success, null)

           (activity as AuthActivity).toolbarSignUpSuccess()
       } else {
           presenter.submitPhotoRegister(data.profilePhotoPath!!, view)
       }
    }

    override fun onRegisterPhotoSuccess(view: View) {
        Navigation.findNavController(view)
            .navigate(R.id.action_sign_up_success, null)

        (activity as AuthActivity).toolbarSignUpSuccess()
    }

    override fun onRegisterFailed(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
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

    override fun showLoading() {
        progressDialog?.show()
    }

    override fun dismissLoading() {
        progressDialog?.dismiss()

    }
}