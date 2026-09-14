package com.example.mad_assignment

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EditAssetActivity : AppCompatActivity() {

    private var assetId = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_asset)

        assetId = intent.getIntExtra("id", -1)

        val name = findViewById<EditText>(R.id.edtEditName)
        val category = findViewById<EditText>(R.id.edtEditCategory)
        val brand = findViewById<EditText>(R.id.edtEditBrand)
        val price = findViewById<EditText>(R.id.edtEditPrice)
        val date = findViewById<EditText>(R.id.edtEditDate)
        val warranty = findViewById<EditText>(R.id.edtEditWarranty)

        val dbHelper = AssetDatabaseHelper(this)
        val db = dbHelper.readableDatabase

        val cursor = db.rawQuery(
            "SELECT * FROM assets WHERE id = ?",
            arrayOf(assetId.toString())
        )

        if (cursor.moveToFirst()) {
            name.setText(cursor.getString(cursor.getColumnIndexOrThrow("name")))
            category.setText(cursor.getString(cursor.getColumnIndexOrThrow("category")))
            brand.setText(cursor.getString(cursor.getColumnIndexOrThrow("brand")))
            price.setText(cursor.getString(cursor.getColumnIndexOrThrow("price")))
            date.setText(cursor.getString(cursor.getColumnIndexOrThrow("purchaseDate")))
            warranty.setText(cursor.getString(cursor.getColumnIndexOrThrow("warranty")))
        }

        cursor.close()
        db.close()

        findViewById<Button>(R.id.btnUpdateAsset).setOnClickListener {

            dbHelper.updateAsset(
                assetId,
                name.text.toString(),
                category.text.toString(),
                brand.text.toString(),
                price.text.toString(),
                date.text.toString(),
                warranty.text.toString()
            )

            Toast.makeText(
                this,
                "Asset updated successfully",
                Toast.LENGTH_SHORT
            ).show()

            finish()
        }
    }
}