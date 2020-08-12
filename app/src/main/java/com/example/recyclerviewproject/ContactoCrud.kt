package com.example.recyclerviewproject

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class ContactoCrud (context: Context){
    private var helper:DataBaseHelper?=null

    init{
        helper= DataBaseHelper(context)
    }
    fun newEmpleado(item:Empleados){

        val db:SQLiteDatabase=helper?.writableDatabase!!
        val values= ContentValues()

        values.put(ContactoContract.Companion.Entrada.COLUMNA_RFC,item.rfc)
        values.put(ContactoContract.Companion.Entrada.COLUMNA_NOMBRE,item.nombre)
        values.put(ContactoContract.Companion.Entrada.COLUMNA_DEPARTAMENTO,item.departamento)
        values.put(ContactoContract.Companion.Entrada.COLUMNA_PUESTO,item.puesto)

        db.insert(ContactoContract.Companion.Entrada.NOMBRE_TABLA,null,values)

        db.close()
    }
    fun getEmpleados():ArrayList<Empleados>{
        val items:ArrayList<Empleados> = ArrayList()
        val db:SQLiteDatabase=helper?.readableDatabase!!
        val columnas = arrayOf(ContactoContract.Companion.Entrada.COLUMNA_RFC,ContactoContract.Companion.Entrada.COLUMNA_NOMBRE,ContactoContract.Companion.Entrada.COLUMNA_PUESTO,ContactoContract.Companion.Entrada.COLUMNA_DEPARTAMENTO)

        val c:Cursor = db.query(ContactoContract.Companion.Entrada.NOMBRE_TABLA,columnas,null,null,null,null,null)
        while (c.moveToNext()){
            items.add(
                Empleados(
                c.getString(c.getColumnIndexOrThrow(ContactoContract.Companion.Entrada.COLUMNA_RFC)),
                c.getString(c.getColumnIndexOrThrow(ContactoContract.Companion.Entrada.COLUMNA_DEPARTAMENTO)),
                c.getString(c.getColumnIndexOrThrow(ContactoContract.Companion.Entrada.COLUMNA_PUESTO)),
                c.getString(c.getColumnIndexOrThrow(ContactoContract.Companion.Entrada.COLUMNA_NOMBRE))
               )
            )
        }
        db.close()
        return items
    }
    fun getEmpleado(id:String):Empleados{
        var item:Empleados? = null
        val db:SQLiteDatabase=helper?.readableDatabase!!
        val columnas = arrayOf(ContactoContract.Companion.Entrada.COLUMNA_RFC,ContactoContract.Companion.Entrada.COLUMNA_NOMBRE,ContactoContract.Companion.Entrada.COLUMNA_PUESTO,ContactoContract.Companion.Entrada.COLUMNA_DEPARTAMENTO)
        val c:Cursor=db.query(ContactoContract.Companion.Entrada.NOMBRE_TABLA,columnas,"id=?",arrayOf(id),null,null,null)
        while (c.moveToNext()){
            item= Empleados(c.getString(c.getColumnIndexOrThrow(ContactoContract.Companion.Entrada.COLUMNA_RFC)),
                c.getString(c.getColumnIndexOrThrow(ContactoContract.Companion.Entrada.COLUMNA_DEPARTAMENTO)),
                c.getString(c.getColumnIndexOrThrow(ContactoContract.Companion.Entrada.COLUMNA_PUESTO)),
                c.getString(c.getColumnIndexOrThrow(ContactoContract.Companion.Entrada.COLUMNA_NOMBRE))
            )
        }
        c.close()
        return item!!
    }
    fun updateEmpleado(item: Empleados){
        val db:SQLiteDatabase=helper?.writableDatabase!!
        val values = ContentValues()
        values.put(ContactoContract.Companion.Entrada.COLUMNA_RFC,item.rfc)
        values.put(ContactoContract.Companion.Entrada.COLUMNA_DEPARTAMENTO,item.departamento)
        values.put(ContactoContract.Companion.Entrada.COLUMNA_NOMBRE,item.nombre)
        values.put(ContactoContract.Companion.Entrada.COLUMNA_PUESTO,item.puesto)
        db.update(ContactoContract.Companion.Entrada.NOMBRE_TABLA,values, "rfc=?",arrayOf(item.rfc))
        db.close()
    }
    fun deleteEmpleado(item:Empleados){
        val db:SQLiteDatabase=helper?.writableDatabase!!
        db.delete(ContactoContract.Companion.Entrada.NOMBRE_TABLA,"rfc=?", arrayOf(item.rfc))
        db.close();
    }
}