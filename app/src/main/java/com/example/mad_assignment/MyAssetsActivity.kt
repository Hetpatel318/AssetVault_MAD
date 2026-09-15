package com.example.mad_assignment

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONArray

class MyAssetsActivity : AppCompatActivity() {

    private lateinit var assetContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_assets)

        assetContainer = findViewById(R.id.assetContainer)

        showAssets()
    }

    override fun onResume() {
        super.onResume()

        showAssets()
    }

    private fun showAssets() {

        // Remove old displayed data
        assetContainer.removeAllViews()

        val preferences =
            getSharedPreferences("AssetVault", MODE_PRIVATE)

        val savedData =
            preferences.getString("assets", "[]")

        val assets = JSONArray(savedData)

        // If there are no assets
        if (assets.length() == 0) {

            val emptyText = TextView(this)

            emptyText.text = "No assets added yet."
            emptyText.textSize = 18f
            emptyText.gravity = Gravity.CENTER
            emptyText.setPadding(10, 80, 10, 80)

            assetContainer.addView(emptyText)

            return
        }

        // Display every asset
        for (i in 0 until assets.length()) {

            val asset = assets.getJSONObject(i)

            // Card
            val card = LinearLayout(this)

            card.orientation = LinearLayout.VERTICAL
            card.setPadding(20, 20, 20, 20)
            card.setBackgroundColor(Color.WHITE)

            // Asset name
            val nameText = TextView(this)

            nameText.text =
                asset.optString("name", "Unknown Asset")

            nameText.textSize = 21f
            nameText.setTextColor(
                Color.rgb(21, 101, 192)
            )
            nameText.setTypeface(
                null,
                Typeface.BOLD
            )

            // Asset details
            val detailsText = TextView(this)

            detailsText.text =
                "Category: ${asset.optString("category", "-")}\n" +
                        "Brand: ${asset.optString("brand", "-")}\n" +
                        "Price: ${asset.optString("price", "-")}\n" +
                        "Purchase Date: ${asset.optString("date", "-")}\n" +
                        "Warranty: ${asset.optString("warranty", "-")} months"

            detailsText.textSize = 16f
            detailsText.setPadding(0, 10, 0, 0)

            // Add views to card
            card.addView(nameText)
            card.addView(detailsText)

            // Card margin
            val params = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

            params.setMargins(0, 0, 0, 15)

            assetContainer.addView(card, params)
        }
    }
}