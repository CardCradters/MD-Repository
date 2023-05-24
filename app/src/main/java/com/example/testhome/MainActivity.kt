package com.example.testhome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.testhome.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseauth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        firebaseauth =  FirebaseAuth.getInstance()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        LoginUser("syabinanf25@gmail.com", "123456")
        setupFragment()
    }

    private fun LoginUser(email: String, pw: String) {

        firebaseauth.signInWithEmailAndPassword(email, pw)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    Log.e("Success", "LoginUser: ${it.isSuccessful}", )


                } else {
                    Log.e("Error", "LoginUser: ${it.exception}", )
                }
            }
    }
    private fun setupFragment() {
        val fragment = HomeFragment()
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            .commit()
    }
}