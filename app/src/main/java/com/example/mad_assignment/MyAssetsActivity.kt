package com.example.mad_assignment

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MyAssetsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_assets)

        val listView = findViewById<ListView>(R.id.listAssets)

        val db = AssetDatabaseHelper(this)
        val database = db.readableDatabase

        val cursor = database.rawQuery("SELECT * FROM assets", null)

        val assets = ArrayList<String>()
        val assetIds = ArrayList<Int>()

        while (cursor.moveToNext()) {

            val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
            val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
            val category = cursor.getString(cursor.getColumnIndexOrThrow("category"))
            val brand = cursor.getString(cursor.getColumnIndexOrThrow("brand"))
            val price = cursor.getString(cursor.getColumnIndexOrThrow("price"))

            assetIds.add(id)
            assets.add("$name\n$category | $brand\nPrice: ₹$price")
        }

        cursor.close()
        database.close()

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            assets
        )

        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->

            val id = assetIds[position]

            val intent = Intent(this, AssetDetailActivity::class.java)
            intent.putExtra("id", id)

            startActivity(intent)
        }
    }
}