package com.example.mad_assignment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addAssetButton = findViewById<Button>(R.id.btnAddAsset)
        val myAssetsButton = findViewById<Button>(R.id.btnMyAssets)

        addAssetButton.setOnClickListener {
            startActivity(
                Intent(this, AddAssetActivity::class.java)
            )
        }

        myAssetsButton.setOnClickListener {
            startActivity(
                Intent(this, MyAssetsActivity::class.java)
            )
        }
    }
}
