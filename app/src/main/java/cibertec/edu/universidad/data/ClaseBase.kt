package cibertec.edu.universidad

import android.database.sqlite.SQLiteDatabase

open public class ClaseBase {

    public fun CadenaConexion():String
    {
        return "/data/data/cibertec.edu.universidad/alumno.db"
    }

    public fun CrearBaseDatos()
    {
        var odb:SQLiteDatabase= SQLiteDatabase.openDatabase(
            CadenaConexion(),
            null,
            SQLiteDatabase.CREATE_IF_NECESSARY)
        odb.execSQL("CREATE TABLE IF NOT EXISTS Alumno(codigo int, nombres varchar(30), " +
                "apellidos varchar(30)," +
                "codigoAlumnno varchar(30),"+
                "seccion(10))")

    }


}