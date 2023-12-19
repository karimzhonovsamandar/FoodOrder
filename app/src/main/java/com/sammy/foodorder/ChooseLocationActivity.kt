package com.sammy.foodorder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import com.sammy.foodorder.databinding.ActivityChooseLocationBinding

class ChooseLocationActivity : AppCompatActivity() {

    lateinit var binding: ActivityChooseLocationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChooseLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val countryList = arrayOf("Russia", "Brazil", "Uzbekistan", "Portugal", "England")
        val adapter = ArrayAdapter(
            this@ChooseLocationActivity,
            android.R.layout.simple_list_item_1,
            countryList
        )
        binding.locationList.setAdapter(adapter)
        binding.locationList.setOnItemClickListener { parent, view, position, id ->
            val selectedLocation = parent.getItemAtPosition(position)
            showDialog(selectedLocation.toString())

        }
    }

    fun showDialog(location: String) {
        val dialogView = layoutInflater.inflate(R.layout.alert_dialog, null)
        val dialogBuilder = AlertDialog.Builder(this@ChooseLocationActivity)
        dialogBuilder.setView(dialogView)
        val dialog = dialogBuilder.create()

        dialogView.findViewById<AppCompatButton>(R.id.yesButton).setOnClickListener {
            startActivityWithLocation(location)
            dialog.dismiss()
        }

        val cancelButton = dialogView.findViewById<AppCompatButton>(R.id.cancelButton)
        cancelButton.setOnClickListener { dialog.dismiss() }

        dialog.show()

    }

    fun startActivityWithLocation(location: String) {
        val intent = (Intent(this, MainActivity::class.java))
        intent.putExtra("location", location)
        startActivity(intent)
        finish()
    }

}