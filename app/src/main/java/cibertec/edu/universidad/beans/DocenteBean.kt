package cibertec.edu.universidad.beans

class DocenteBean {
    var codigo:Int = 0
    var nombres: String = ""
    var apellidos: String = ""
    var codigoDocente : String =""
    var seccion: String = ""

    constructor(pcodigo:Int, pnombres:String, papellidos: String, pcodigoDocente: String, pseccion:String){
        this.codigo = pcodigo
        this.nombres = pnombres
        this.apellidos = papellidos
        this.codigoDocente = pcodigoDocente
        this.seccion = pseccion

    }

    constructor(){

    }

}