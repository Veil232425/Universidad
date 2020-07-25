package cibertec.edu.universidad.beans

class AlumnoBean {
    var codigo: Int = 0
    var nombres: String = ""
    var apellidos: String = ""
    var codigoAlumno: String = ""
    var seccion : String = ""

    constructor(pcodigo: Int, pnombres : String, papellidos: String, pcodigoAlumno:String, pseccion: String ){
        this.codigo = pcodigo
        this.nombres = pnombres
        this.apellidos = papellidos
        this.codigoAlumno = pcodigoAlumno
        this.seccion = pseccion
    }

    constructor(){}
}