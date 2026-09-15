package com.example.mad_assignment

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class AssetDatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "assetvault.db"
        private const val DATABASE_VERSION = 1
        const val TABLE_ASSETS = "assets"

        const val COL_ID = "id"
        const val COL_NAME = "name"
        const val COL_CATEGORY = "category"
        const val COL_BRAND = "brand"
        const val COL_PRICE = "price"
        const val COL_DATE = "purchaseDate"
        const val COL_WARRANTY = "warranty"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = """
            CREATE TABLE $TABLE_ASSETS (
                $COL_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COL_NAME TEXT NOT NULL,
                $COL_CATEGORY TEXT,
                $COL_BRAND TEXT,
                $COL_PRICE TEXT,
                $COL_DATE TEXT,
                $COL_WARRANTY TEXT
            )
        """.trimIndent()
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_ASSETS")
        onCreate(db)
    }

    fun addAsset(
        name: String, category: String, brand: String,
        price: String, date: String, warranty: String
    ): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COL_NAME, name)
            put(COL_CATEGORY, category)
            put(COL_BRAND, brand)
            put(COL_PRICE, price)
            put(COL_DATE, date)
            put(COL_WARRANTY, warranty)
        }
        val id = db.insert(TABLE_ASSETS, null, values)
        db.close()
        return id
    }

    fun getAllAssets(): List<Asset> {
        val list = mutableListOf<Asset>()
        val db = readableDatabase
        val cursor = db.query(TABLE_ASSETS, null, null, null, null, null, "$COL_ID DESC")
        while (cursor.moveToNext()) {
            list.add(cursorToAsset(cursor))
        }
        cursor.close()
        db.close()
        return list
    }

    fun getAssetById(id: Int): Asset? {
        val db = readableDatabase
        val cursor = db.query(TABLE_ASSETS, null, "$COL_ID=?", arrayOf(id.toString()), null, null, null)
        var asset: Asset? = null
        if (cursor.moveToFirst()) {
            asset = cursorToAsset(cursor)
        }
        cursor.close()
        db.close()
        return asset
    }

    fun updateAsset(
        id: Int, name: String, category: String, brand: String,
        price: String, date: String, warranty: String
    ): Int {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COL_NAME, name)
            put(COL_CATEGORY, category)
            put(COL_BRAND, brand)
            put(COL_PRICE, price)
            put(COL_DATE, date)
            put(COL_WARRANTY, warranty)
        }
        val rows = db.update(TABLE_ASSETS, values, "$COL_ID=?", arrayOf(id.toString()))
        db.close()
        return rows
    }

    fun deleteAsset(id: Int): Int {
        val db = writableDatabase
        val rows = db.delete(TABLE_ASSETS, "$COL_ID=?", arrayOf(id.toString()))
        db.close()
        return rows
    }

    private fun cursorToAsset(cursor: Cursor): Asset {
        return Asset(
            id = cursor.getInt(cursor.getColumnIndexOrThrow(COL_ID)),
            name = cursor.getString(cursor.getColumnIndexOrThrow(COL_NAME)),
            category = cursor.getString(cursor.getColumnIndexOrThrow(COL_CATEGORY)),
            brand = cursor.getString(cursor.getColumnIndexOrThrow(COL_BRAND)),
            price = cursor.getString(cursor.getColumnIndexOrThrow(COL_PRICE)),
            date = cursor.getString(cursor.getColumnIndexOrThrow(COL_DATE)),
            warranty = cursor.getString(cursor.getColumnIndexOrThrow(COL_WARRANTY))
        )
    }
}