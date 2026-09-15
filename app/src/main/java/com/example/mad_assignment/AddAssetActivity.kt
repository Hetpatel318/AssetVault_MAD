package com.example.mad_assignment

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONArray
import org.json.JSONObject

class AddAssetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_asset)

        val assetName = findViewById<EditText>(R.id.edtAssetName)
        val category = findViewById<EditText>(R.id.edtCategory)
        val brand = findViewById<EditText>(R.id.edtBrand)
        val price = findViewById<EditText>(R.id.edtPrice)
        val purchaseDate = findViewById<EditText>(R.id.edtPurchaseDate)
        val warranty = findViewById<EditText>(R.id.edtWarranty)

        val btnSave = findViewById<Button>(R.id.btnSaveAsset)

        btnSave.setOnClickListener {

            if (assetName.text.toString().trim().isEmpty()) {
                assetName.error = "Enter asset name"
                return@setOnClickListener
            }

            if (category.text.toString().trim().isEmpty()) {
                category.error = "Enter category"
                return@setOnClickListener
            }

            if (brand.text.toString().trim().isEmpty()) {
                brand.error = "Enter brand"
                return@setOnClickListener
            }

            val preferences =
                getSharedPreferences("AssetVault", MODE_PRIVATE)

            // Get old assets
            val oldData =
                preferences.getString("assets", "[]")

            val assets = JSONArray(oldData)

            // Create new asset
            val newAsset = JSONObject()

            newAsset.put("name", assetName.text.toString().trim())
            newAsset.put("category", category.text.toString().trim())
            newAsset.put("brand", brand.text.toString().trim())
            newAsset.put("price", price.text.toString().trim())
            newAsset.put("date", purchaseDate.text.toString().trim())
            newAsset.put("warranty", warranty.text.toString().trim())

            // Add new asset to list
            assets.put(newAsset)

            // Save complete list
            preferences.edit()
                .putString("assets", assets.toString())
                .putInt("totalAssets", assets.length())
                .apply()

            Toast.makeText(
                this,
                "Asset saved successfully!",
                Toast.LENGTH_SHORT
            ).show()

            finish()
        }
    }
}