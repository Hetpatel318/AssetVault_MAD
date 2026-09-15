package com.example.mad_assignment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var txtTotalAssets: TextView
    private lateinit var txtWarrantyCount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtTotalAssets = findViewById(R.id.txtTotalAssets)
        txtWarrantyCount = findViewById(R.id.txtWarrantyAlerts)

        val btnAddAsset = findViewById<Button>(R.id.btnAddAsset)
        val btnMyAssets = findViewById<Button>(R.id.btnMyAssets)
        val btnCategories = findViewById<Button>(R.id.btnCategories)
        val btnWarranty = findViewById<Button>(R.id.btnWarranty)

        btnAddAsset.setOnClickListener {
            startActivity(Intent(this, AddAssetActivity::class.java))
        }

        btnMyAssets.setOnClickListener {
            startActivity(Intent(this, MyAssetsActivity::class.java))
        }

        btnCategories.setOnClickListener {
            startActivity(Intent(this, AssetCategoriesActivity::class.java))
        }

        btnWarranty.setOnClickListener {
            startActivity(Intent(this, WarrantyActivity::class.java))
        }
        
        updateDashboard()
    }

    override fun onResume() {
        super.onResume()
        updateDashboard()
    }

    private fun updateDashboard() {
        val dbHelper = AssetDatabaseHelper(this)
        val allAssets = dbHelper.getAllAssets()
        
        txtTotalAssets.text = allAssets.size.toString()
        
        val warrantyAlerts = allAssets.count { 
            it.warranty.isNotEmpty() && it.warranty != "0" 
        }
        txtWarrantyCount.text = warrantyAlerts.toString()
    }
}
