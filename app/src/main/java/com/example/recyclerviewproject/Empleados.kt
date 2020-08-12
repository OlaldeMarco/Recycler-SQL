package com.example.recyclerviewproject

class Empleados(RFC:String , Nombre:String , Puesto:String , Departamento:String) {
    var rfc : String?= null
    var nombre : String? = null
    var puesto : String? = null
    var departamento : String? = null

    init {
        this.rfc = RFC
        this.nombre = Nombre
        this.puesto = Puesto
        this.departamento = Departamento
    }
}