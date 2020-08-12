package com.example.recyclerviewproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ResultadoActivity : AppCompatActivity() {
    var listaEmpleados:ArrayList<Empleados>?=null
    var crud:ContactoCrud?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val btn= findViewById<Button>(R.id.btnAgregar)

        crud= ContactoCrud(this)

        listaEmpleados = crud?.getEmpleados()

        val recyclerView : RecyclerView = findViewById(R.id.lista_rv)
        recyclerView.layoutManager = LinearLayoutManager ( this , LinearLayoutManager.VERTICAL , false)

        val adapter = listaEmpleados?.let { AdaptadorCustom (it) }
        recyclerView.adapter = adapter

        btn.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}