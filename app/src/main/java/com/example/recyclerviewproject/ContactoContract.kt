package com.example.recyclerviewproject

import android.provider.BaseColumns

class ContactoContract {
    companion object{
        val VERSION=1
        class Entrada:BaseColumns{
            companion object{
                val NOMBRE_TABLA="contacto"
                val COLUMNA_RFC="rfc"
                val COLUMNA_NOMBRE="nombre"
                val COLUMNA_PUESTO="telefono"
                val COLUMNA_DEPARTAMENTO="departamento"
            }
        }
    }
}