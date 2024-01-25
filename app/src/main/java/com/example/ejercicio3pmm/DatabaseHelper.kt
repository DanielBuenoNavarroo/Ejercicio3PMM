package com.example.ejercicio3pmm

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

data class Articulo(
    private var nombre: String,
    private var tipo: String,
    private var precio: Int,
    private var uri: Int
) {
    private var id: Int = 0

    fun getNombre(): String {
        return nombre
    }

    fun getTipo(): String {
        return tipo
    }

    fun getPrecio(): Int {
        return precio
    }

    fun getUri(): Int {
        return uri
    }

    fun setId(id: Int) {
        this.id = id
    }
}

    class DatabaseHelper(private val context: Context) :
    SQLiteOpenHelper(context, DATABASE, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE = "Articulos.db"
        private const val TABLA_ARTICULOS = "articulos"
        private const val KEY_ID = "_id"
        private const val COLUMN_NOMBRE = "nombre"
        private const val COLUMN_TIPO = "tipo"
        private const val COLUMN_PRECIO = "precio"
        private const val COLUMN_URI_IMAGEN = "url"
    }




    override fun onCreate(db: SQLiteDatabase?) {
        val createTable =
            "CREATE TABLE IF NOT EXISTS $TABLA_ARTICULOS ($KEY_ID INTEGER PRIMARY KEY, $COLUMN_NOMBRE TEXT, $COLUMN_TIPO TEXT, $COLUMN_PRECIO INTEGER, $COLUMN_URI_IMAGEN INTEGER)"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLA_ARTICULOS")
        onCreate(db)
    }

    fun insertarArticulo(articulo: Articulo): Long {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NOMBRE, articulo.getNombre())
            put(COLUMN_TIPO, articulo.getTipo())
            put(COLUMN_PRECIO, articulo.getPrecio())
            put(COLUMN_URI_IMAGEN, articulo.getUri())
        }
        val id = db.insert(TABLA_ARTICULOS, null, values)
        db.close()
        return id
    }

    @SuppressLint("Range")
    fun getArticulos(): ArrayList<Articulo> {
        val articulos = ArrayList<Articulo>()
        val selectQuery = "SELECT * FROM $TABLA_ARTICULOS"
        val db = this.readableDatabase
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndex(KEY_ID))
                val nombre = cursor.getString(cursor.getColumnIndex(COLUMN_NOMBRE))
                val tipo = cursor.getString(cursor.getColumnIndex(COLUMN_TIPO))
                val precio = cursor.getInt(cursor.getColumnIndex(COLUMN_PRECIO))
                val uri = cursor.getInt(cursor.getColumnIndex(COLUMN_URI_IMAGEN))
                articulos.add(Articulo(nombre, tipo, precio, uri))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return articulos
    }

    fun borrarBaseDeDatos() {
        context.deleteDatabase(DATABASE)
    }
}