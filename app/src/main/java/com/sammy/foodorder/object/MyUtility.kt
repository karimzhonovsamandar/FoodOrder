package com.sammy.foodorder.`object`

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import android.widget.EditText
import androidx.appcompat.app.AppCompatDelegate
import com.sammy.foodorder.databinding.ActivityLoginUserBinding

object MyUtility {
    @SuppressLint("StaticFieldLeak")

    fun myFunction(editText: EditText) {
        when (editText.context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_NO -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            Configuration.UI_MODE_NIGHT_YES -> {
                editText.setHintTextColor(Color.BLACK)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            else -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
            }
        }
    }
}