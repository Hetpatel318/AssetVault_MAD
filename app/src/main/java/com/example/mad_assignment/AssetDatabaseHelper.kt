package com.example.mad_assignment

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class AssetDatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, "AssetVault.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {

        db.execSQL(
            "CREATE TABLE assets (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name TEXT, " +
                    "category TEXT, " +
                    "brand TEXT, " +
                    "price TEXT, " +
                    "purchaseDate TEXT, " +
                    "warranty TEXT)"
        )
    }

    override fun onUpgrade(
        db: SQLiteDatabase,
        oldVersion: Int,
        newVersion: Int
    ) {
        db.execSQL("DROP TABLE IF EXISTS assets")
        onCreate(db)
    }

    fun addAsset(
        name: String,
        category: String,
        brand: String,
        price: String,
        date: String,
        warranty: String
    ) {
        val db = writableDatabase

        val values = ContentValues()
        values.put("name", name)
        values.put("category", category)
        values.put("brand", brand)
        values.put("price", price)
        values.put("purchaseDate", date)
        values.put("warranty", warranty)

        db.insert("assets", null, values)
        db.close()
    }

    fun deleteAsset(id: Int) {
        val db = writableDatabase
        db.delete("assets", "id=?", arrayOf(id.toString()))
        db.close()
    }
    fun updateAsset(
        id: Int,
        name: String,
        category: String,
        brand: String,
        price: String,
        date: String,
        warranty: String
    ) {
        val db = writableDatabase

        val values = ContentValues()
        values.put("name", name)
        values.put("category", category)
        values.put("brand", brand)
        values.put("price", price)
        values.put("purchaseDate", date)
        values.put("warranty", warranty)

        db.update(
            "assets",
            values,
            "id=?",
            arrayOf(id.toString())
        )

        db.close()
    }
}