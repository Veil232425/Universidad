package cibertec.edu.universidad

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import cibertec.edu.universidad.beans.AlumnoBean

//aGREGADO EL GITHUB
class AlumnoDAL: ClaseBase() {
    val NOMBRE_TABLA="Alumno"
    init
    {
        super.CrearBaseDatos()
    }
    //pAccion = N -->Es un registro nuevo se debe insertar
//pAccion = A -->Es un registro existe se debe actualizar
    public fun RegistraModifica(pAlu: AlumnoBean, pAccion:String)
    {
        var odb:SQLiteDatabase= SQLiteDatabase.openDatabase(this.CadenaConexion(), null,
            SQLiteDatabase.CREATE_IF_NECESSARY)

        var oRegistro:ContentValues= ContentValues()
        oRegistro.put("Codigo",pAlu.codigo)
        oRegistro.put("Nombres",pAlu.nombres)
        oRegistro.put("Apellidos",pAlu.apellidos)
        oRegistro.put("CodigoAlumno",pAlu.codigoAlumno)
        oRegistro.put("Seccion",pAlu.seccion)
        if (pAccion =="N") {
            var oresult = odb.insert(NOMBRE_TABLA, null, oRegistro).toInt()
            if (oresult == -1) {
                //Error de insert
            }
        }
        else if (pAccion =="A") {

            var oresult = odb.update(
                NOMBRE_TABLA,
                oRegistro,
                " codigo = " + pAlu.codigo.toString(),
                null ).toInt()
            if (oresult == -1) {
                //Error de update
            }
        }
        odb.close()
    }

    public fun Lista(pAlu:AlumnoBean): ArrayList<AlumnoBean>
    {
        var oLista=ArrayList<AlumnoBean>()
        var odb:SQLiteDatabase= SQLiteDatabase.openDatabase(this.CadenaConexion(), null,
            SQLiteDatabase.CREATE_IF_NECESSARY)
        var oTabla: Cursor=odb.rawQuery("Select * from " + NOMBRE_TABLA, null)
        if (oTabla.moveToFirst())
        {
            do {
                oLista.add(
                   AlumnoBean(
                        oTabla.getInt(0), //Codigo
                        oTabla.getString(1), //nombres
                        oTabla.getString(2), //apellidos
                        oTabla.getString(3), //codigoAlumno
                       oTabla.getString(4)  //Seccion
                   )
                )
            } while (oTabla.moveToNext())
        }
        return oLista
    }

}
