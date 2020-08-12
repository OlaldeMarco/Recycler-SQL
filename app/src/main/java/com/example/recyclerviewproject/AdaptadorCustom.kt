package com.example.recyclerviewproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.view.*

class AdaptadorCustom(items:ArrayList<Empleados>): RecyclerView.Adapter<AdaptadorCustom.ViewHolder>() {
    var items:ArrayList<Empleados>? = null

    var viewHolder:ViewHolder? = null

    init {
        this.items = items

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdaptadorCustom.ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.template_empleado , parent , false)

        viewHolder = ViewHolder(vista)
        return viewHolder!!
    }

    override fun getItemCount(): Int {
        return this.items?.count()!!
    }

    override fun onBindViewHolder(holder: AdaptadorCustom.ViewHolder, position: Int) {
        val item = items?.get(position)
        holder.rfc?.text = item?.rfc
        holder.nombre?.text = item?.nombre
        holder.puesto?.text = item?.puesto
        holder.departamento?.text = item?.departamento
    }

    inner class ViewHolder(vista : View) : RecyclerView.ViewHolder(vista){
        var vista = vista

        /*val rfc : TextView = itemView.findViewById(R.id.etRFC)
        val nombre : TextView = itemView.findViewById(R.id.etNombre)
        val puesto : TextView = itemView.findViewById(R.id.etPuesto)
        val departamento : TextView = itemView.findViewById(R.id.etDepartamento)*/
       var rfc : TextView? = null
        var nombre : TextView? = null
        var puesto : TextView? = null
        var departamento : TextView? = null

        init {
            rfc = vista.tvRFC
            nombre = vista.tvNombre
            puesto = vista.tvPuesto
            departamento = vista.tvDepartamento
        }
    }
}