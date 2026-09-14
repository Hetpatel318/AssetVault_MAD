package com.example.mad_assignment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class EntryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry)

        // Adjust R.id.btnGoToAdd to match the actual ID in your activity_entry.xml
        val btnGoToAdd: Button? = findViewById(R.id.btnGoToAdd)
        btnGoToAdd?.setOnClickListener {
            val intent = Intent(this, AddAssetActivity::class.java)
            startActivity(intent)
        }
    }
}