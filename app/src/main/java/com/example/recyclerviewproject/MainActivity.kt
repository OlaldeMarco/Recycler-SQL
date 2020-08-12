package com.example.recyclerviewproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_resultado.*

class MainActivity : AppCompatActivity() {
    var crud:ContactoCrud?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rfc = findViewById<EditText>(R.id.etRFC)
        val nombre = findViewById<EditText>(R.id.etNombre)
        val puesto = findViewById<EditText>(R.id.etPuesto)
        val departamento = findViewById<EditText>(R.id.etDepartamento)
        crud= ContactoCrud(this)

        var agregar = findViewById<Button>(R.id.btnAgregar)

        agregar.setOnClickListener(View.OnClickListener {
            crud?.newEmpleado(Empleados(rfc.text.toString(),nombre.text.toString(),puesto.text.toString(),departamento.text.toString()))
            startActivity(Intent(this,ResultadoActivity::class.java))
        })

        var actualizar = findViewById<Button>(R.id.btnEditar)

        actualizar.setOnClickListener(View.OnClickListener {
            crud?.updateEmpleado(Empleados(rfc.text.toString(),nombre.text.toString(),puesto.text.toString(),departamento.text.toString()))
            startActivity(Intent(this,ResultadoActivity::class.java))
        })
        val eliminar=findViewById<Button>(R.id.btnEliminar)
        eliminar.setOnClickListener {
            startActivity(Intent(this, Eliminate::class.java))
        }


    }
}