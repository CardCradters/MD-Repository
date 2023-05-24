package com.example.testhome

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.testhome.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.apply {
            btnLogin.setOnClickListener {
                val email = email.text.toString().trim()
                val password = password.text.toString().trim()
                loginUser(email, password)
            }

            tvRegister.setOnClickListener {
                // Handle register text view click here
            }
        }
    }


    private fun loginUser(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Login successful
                    Log.e("Success", "LoginUser: ${task.isSuccessful}")
                    logoutUser()
                } else {
                    // Login failed
                    Log.e("Error", "LoginUser: ${task.exception}")
                }
            }
    }

    private fun logoutUser() {
        firebaseAuth.signOut()
        // Add your logic for navigating to the next screen or performing other actions
    }
}
