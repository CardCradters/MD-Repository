package com.example.testhome

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.testhome.databinding.ActivityRegisterBinding


class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var viewModel: RegisViewsModel
    private var isPasswordVisible = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(RegisViewsModel::class.java)

        binding.btnRegister.setOnClickListener {
            val name = binding.username.text.toString()
            val phoneNumber = binding.phone.text.toString()
            val email = binding.etemail.text.toString()
            val password = binding.password.text.toString()

            val registerRequest = RegisRequest(name, phoneNumber, email, password)
            viewModel.registerUser(registerRequest) { message ->
                showToast(message)

                binding.username.text.clear()
                binding.phone.text.clear()
                binding.etemail.text.clear()
                binding.password.text.clear()

                binding.btnShowHidePassword.setOnClickListener {
                    isPasswordVisible = !isPasswordVisible
                    togglePasswordVisibility()
                }
            }
        }
    }

    private fun togglePasswordVisibility() {
        if (isPasswordVisible) {
            // Tampilkan teks password
            binding.password.transformationMethod = HideReturnsTransformationMethod.getInstance()
            binding.btnShowHidePassword.setImageResource(R.drawable.ic_eye_visible)
        } else {
            // Sembunyikan teks password dengan menggunakan transformationMethod
            binding.password.transformationMethod = PasswordTransformationMethod.getInstance()
            binding.btnShowHidePassword.setImageResource(R.drawable.ic_eye_hidden)
        }
    }

    private fun showToast(message: String) {
        val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        toast.show()
    }
}