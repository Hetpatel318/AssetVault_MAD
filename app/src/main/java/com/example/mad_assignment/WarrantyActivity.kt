package com.example.mad_assignment

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WarrantyActivity : AppCompatActivity() {

    private lateinit var warrantyContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_warranty)

        warrantyContainer = findViewById(R.id.warrantyContainer)

        showWarranties()
    }

    override fun onResume() {
        super.onResume()
        showWarranties()
    }

    private fun showWarranties() {
        warrantyContainer.removeAllViews()

        val dbHelper = AssetDatabaseHelper(this)
        val allAssets = dbHelper.getAllAssets()
        
        // Filter assets that have warranty info
        val assetsWithWarranty = allAssets.filter { 
            it.warranty.isNotEmpty() && it.warranty != "0" 
        }

        if (assetsWithWarranty.isEmpty()) {
            val emptyText = TextView(this)
            emptyText.text = "No active warranty information found."
            emptyText.textSize = 18f
            emptyText.setPadding(10, 80, 10, 80)
            emptyText.gravity = Gravity.CENTER

            warrantyContainer.addView(emptyText)
            return
        }

        for (asset in assetsWithWarranty) {
            val card = LinearLayout(this)
            card.orientation = LinearLayout.VERTICAL
            card.setPadding(30, 30, 30, 30)
            card.setBackgroundResource(R.drawable.card_background)

            val nameText = TextView(this)
            nameText.text = asset.name
            nameText.textSize = 20f
            nameText.setTextColor(Color.parseColor("#1565C0"))
            nameText.setTypeface(null, Typeface.BOLD)

            val detailsText = TextView(this)
            detailsText.text = "Brand: ${asset.brand}\n" +
                               "Warranty Period: ${asset.warranty} Months\n" +
                               "Purchase Date: ${asset.date}"
            detailsText.textSize = 16f
            detailsText.setPadding(0, 10, 0, 0)
            detailsText.setTextColor(Color.DKGRAY)

            card.addView(nameText)
            card.addView(detailsText)

            val params = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(0, 0, 0, 20)
            warrantyContainer.addView(card, params)
        }
    }
}
