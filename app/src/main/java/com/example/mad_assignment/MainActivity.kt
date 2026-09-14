package com.example.mad_assignment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addAssetButton = findViewById<Button>(R.id.btnAddAsset)

        addAssetButton.setOnClickListener {
            val intent = Intent(this, AddAssetActivity::class.java)
            startActivity(intent)
        }
    }
}