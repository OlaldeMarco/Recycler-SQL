package com.example.recyclerviewproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_eliminar.*

class Eliminate : AppCompatActivity() {
    var crud:ContactoCrud?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eliminar)
        val rfc = findViewById<EditText>(R.id.etRFCDe)
        crud= ContactoCrud(this)

        btnDelete.setOnClickListener(View.OnClickListener {
            crud?.deleteEmpleado(Empleados(rfc.text.toString(),"","",""))
            startActivity(Intent(this,ResultadoActivity::class.java))
        })
    }
}