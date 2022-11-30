package com.example.foodmarket.ui.auth.signup

import android.app.Activity
import android.content.Intent
import android.media.Image
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.foodmarket.R
import com.example.foodmarket.databinding.FragmentSignUpBinding
import com.example.foodmarket.model.request.RegisterRequest
import com.example.foodmarket.ui.auth.AuthActivity
import com.github.dhaval2404.imagepicker.ImagePicker

class SignUpFragment : Fragment() {

    var filePath: Uri? = null

    private lateinit var binding : FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignUpBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDummy()
        initListener()
    }

    private fun initListener() {
        binding.imgProfile.setOnClickListener{
            ImagePicker.with(this)
                .cameraOnly()
                .start()
        }

        binding.btnContinue.setOnClickListener {

            var fullName = binding.edtFullName.text.toString()
            var email = binding.edtEmail.text.toString()
            var password = binding.edtPassword.text.toString()

            if (fullName.isNullOrEmpty()) {
                binding.edtFullName.setError("Silahkan masukkan fullname")
                binding.edtFullName.requestFocus()
            } else  if (email.isNullOrEmpty()) {
                binding.edtEmail.setError("Silahkan masukkan email")
                binding.edtEmail.requestFocus()
            } else  if (password.isNullOrEmpty()) {
                binding.edtPassword.setError("Silahkan masukkan password")
                binding.edtPassword.requestFocus()
            } else {
                var data = RegisterRequest(
                    fullName, email, password, password, "", "", "", "", filePath
                )

                var bundle = Bundle()
                bundle.putParcelable("data",data)

                Navigation.findNavController(it)
                    .navigate(R.id.action_sign_up_address, bundle)

                (activity as AuthActivity).toolbarSignUpAddress()
            }
        }
    }

    private fun initDummy() {
        binding.edtFullName.setText("Kurniawan")
        binding.edtEmail.setText("kurniawan@gmail.com")
        binding.edtPassword.setText("12345678")
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            filePath = data?.data

            Glide.with(this)
                .load(filePath)
                .apply(RequestOptions.circleCropTransform())
                .into(binding.imgProfile)
        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(context, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Task Cancelled", Toast.LENGTH_SHORT).show()
        }
    }

}