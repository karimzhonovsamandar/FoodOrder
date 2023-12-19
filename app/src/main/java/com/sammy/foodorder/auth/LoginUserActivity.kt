package com.sammy.foodorder.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sammy.foodorder.MainActivity
import com.sammy.foodorder.databinding.ActivityLoginUserBinding
import com.sammy.foodorder.`object`.MyUtility


class LoginUserActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MyUtility.myFunction(binding.emailEditText)
        MyUtility.myFunction(binding.passwordEditText)
        binding.goSignUp.setOnClickListener {
            startActivity(Intent(this, SignUpUserActivity::class.java))

        }

        binding.loginButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }


}