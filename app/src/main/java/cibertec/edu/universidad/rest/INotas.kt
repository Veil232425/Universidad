package cibertec.edu.universidad

import cibertec.edu.universidad.pojos.NotasResponse
import cibertec.edu.universidad.tools.Constantes
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface IProveedor {

    @GET(Constantes.GETLISTA_NOTAS)
    @Headers( "Content-Type: application/json")
    fun getLista(
        @Query(value = "CodigoAlumno") pCodigoAlumno:Int
        , @Query(value = "AMoviles") pAMoviles:Int
        , @Query(value = "Finanzas") pFinanzas:Int
        , @Query(value = "Redes") pRedes:Int
        , @Query(value = "DisenioWeb") pDisenioWeb:Int
    ): Call<NotasResponse>


    @GET(Constantes.GETRegistraModifica_NOTAS)
    @Headers( "Content-Type: application/json")
    fun getRegistraModifica(
        @Query(value = "pTipoTransaccion") pTipoTransaccion:String
        , @Query(value = "CodigoProveedor") CodigoProveedor:Int
        ,@Query(value = "RazonSocial") RazonSocial: String
        ,@Query(value = "Direccion") Direccion: String
        ,@Query(value = "RazonSocial") Ruc: String
    ): Call<NotasResponse>

    ///RegistraModifica?pTipoTransaccion=N&CodigoProveedor=0&RazonSocial=abc&Direccion=av.Brasil&Ruc=10343444445



}