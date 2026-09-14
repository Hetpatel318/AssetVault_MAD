package com.example.mad_assignment

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddAssetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_asset)

        val name = findViewById<EditText>(R.id.edtAssetName)
        val category = findViewById<EditText>(R.id.edtCategory)
        val brand = findViewById<EditText>(R.id.edtBrand)
        val price = findViewById<EditText>(R.id.edtPrice)
        val date = findViewById<EditText>(R.id.edtPurchaseDate)
        val warranty = findViewById<EditText>(R.id.edtWarranty)

        val save = findViewById<Button>(R.id.btnSaveAsset)

        save.setOnClickListener {

            if (name.text.toString().trim().isEmpty()) {
                Toast.makeText(this, "Enter asset name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(
                this,
                "Asset saved successfully",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}