package com.example.mad_assignment

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AssetCategoriesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asset_categories)

        val listView = findViewById<ListView>(R.id.listCategories)
        val tvEmpty = findViewById<TextView>(R.id.tvEmptyCategories)

        val dbHelper = AssetDatabaseHelper(this)
        val assets = dbHelper.getAllAssets()

        val grouped = assets.groupBy { it.category }

        val rows = grouped.map { (category, items) ->
            val total = items.sumOf { it.price.toDoubleOrNull() ?: 0.0 }
            "$category\n${items.size} item(s)  •  Total: RM %.2f".format(total)
        }

        if (rows.isEmpty()) {
            tvEmpty.text = "No assets added yet"
        } else {
            tvEmpty.text = ""
            listView.adapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                rows
            )
        }
    }
}