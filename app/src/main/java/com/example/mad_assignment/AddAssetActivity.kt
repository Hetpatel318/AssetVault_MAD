package com.example.mad_assignment

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddAssetActivity : AppCompatActivity() {

    private lateinit var db: AssetDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_asset)

        db = AssetDatabaseHelper(this)

        val save: Button = findViewById(R.id.save)
        val name: EditText = findViewById(R.id.name)
        val category: EditText = findViewById(R.id.category)
        val brand: EditText = findViewById(R.id.brand)
        val price: EditText = findViewById(R.id.price)
        val date: EditText = findViewById(R.id.date)
        val warranty: EditText = findViewById(R.id.warranty)

        save.setOnClickListener {
            val assetName = name.text.toString().trim()
            if (assetName.isEmpty()) {
                Toast.makeText(this, "Enter asset name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            db.addAsset(
                assetName,
                category.text.toString().trim(),
                brand.text.toString().trim(),
                price.text.toString().trim(),
                date.text.toString().trim(),
                warranty.text.toString().trim()
            )

            Toast.makeText(this, "Asset saved successfully", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}