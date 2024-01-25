package com.example.ejercicio3pmm

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DatabaseHelperMerca(private val context: Context) :
    SQLiteOpenHelper(context, DATABASE, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE = "Articulos.db"
        private const val TABLA_ARTICULOS = "articulos"
        private const val KEY_ID = "_id"
        private const val COLUMN_NOMBRE = "nombre"
        private const val COLUMN_TIPO = "tipo"
        private const val COLUMN_PESO = "PESO"
        private const val COLUMN_URI_IMAGEN = "url"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        TODO("Not yet implemented")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}