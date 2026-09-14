package com.example.mad_assignment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AssetDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asset_details)

        val id = intent.getIntExtra("id", -1)

        if (id == -1) {
            Toast.makeText(this, "Asset not found", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        val dbHelper = AssetDatabaseHelper(this)
        val db = dbHelper.readableDatabase

        val cursor = db.rawQuery(
            "SELECT * FROM assets WHERE id = ?",
            arrayOf(id.toString())
        )

        if (cursor.moveToFirst()) {

            val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
            val category = cursor.getString(cursor.getColumnIndexOrThrow("category"))
            val brand = cursor.getString(cursor.getColumnIndexOrThrow("brand"))
            val price = cursor.getString(cursor.getColumnIndexOrThrow("price"))
            val date = cursor.getString(cursor.getColumnIndexOrThrow("purchaseDate"))
            val warranty = cursor.getString(cursor.getColumnIndexOrThrow("warranty"))

            findViewById<TextView>(R.id.txtName).text = "Name: $name"
            findViewById<TextView>(R.id.txtCategory).text = "Category: $category"
            findViewById<TextView>(R.id.txtBrand).text = "Brand: $brand"
            findViewById<TextView>(R.id.txtPrice).text = "Price: ₹$price"
            findViewById<TextView>(R.id.txtDate).text = "Purchase Date: $date"
            findViewById<TextView>(R.id.txtWarranty).text =
                "Warranty: $warranty months"
        }

        cursor.close()
        db.close()

        findViewById<Button>(R.id.btnEdit).setOnClickListener {

            val intent = Intent(this, EditAssetActivity::class.java)
            intent.putExtra("id", id)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnDelete).setOnClickListener {

            dbHelper.deleteAsset(id)

            Toast.makeText(
                this,
                "Asset deleted",
                Toast.LENGTH_SHORT
            ).show()

            finish()
        }
    }
}