package com.sammy.foodorder.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sammy.foodorder.ChooseLocationActivity
import com.sammy.foodorder.databinding.ActivitySignUpUserBinding
import com.sammy.foodorder.`object`.MyUtility

class SignUpUserActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignUpUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MyUtility.myFunction(binding.emailEditText)
        MyUtility.myFunction(binding.passwordEditText)
        MyUtility.myFunction(binding.nameEditText)

        binding.goLoginUp.setOnClickListener {
            startActivity(Intent(this, LoginUserActivity::class.java))
            finish()
        }

        binding.createAccountButton.setOnClickListener {
            startActivity(Intent(this, ChooseLocationActivity::class.java))
        }
    }
}