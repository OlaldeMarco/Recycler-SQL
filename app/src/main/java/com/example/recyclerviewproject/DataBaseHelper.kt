package com.example.recyclerviewproject

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelper(context: Context):SQLiteOpenHelper(context,ContactoContract.Companion.Entrada.NOMBRE_TABLA,null,ContactoContract.Companion.VERSION){

    companion object{
        val CREATE_CONTACTO_TABLA="create table "+ContactoContract.Companion.Entrada.NOMBRE_TABLA+"("+
                ContactoContract.Companion.Entrada.COLUMNA_RFC+" text primary key, "+
                ContactoContract.Companion.Entrada.COLUMNA_NOMBRE+" text, "+
                ContactoContract.Companion.Entrada.COLUMNA_DEPARTAMENTO+" text, "+
                ContactoContract.Companion.Entrada.COLUMNA_PUESTO+" text); "
        val DROP_CONTACTO_TABLA=" drop table if exists "+ContactoContract.Companion.Entrada.NOMBRE_TABLA

    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_CONTACTO_TABLA)
    }

    override fun onUpgrade(db: SQLiteDatabase?, i: Int, i2: Int) {
        db?.execSQL(DROP_CONTACTO_TABLA)
        onCreate(db)
    }


}