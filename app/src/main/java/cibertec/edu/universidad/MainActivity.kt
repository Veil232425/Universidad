package cibertec.edu.universidad

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import cibertec.edu.universidad.pojos.NotasResponse
import cibertec.edu.universidad.pojos.ObjListaNota
import cibertec.edu.universidad.tools.Constantes
import cibertec.edu.universidad.tools.ObjectRequest
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.listado_notas.*
import kotlinx.android.synthetic.main.registro_notas.*

class MainActivity : AppCompatActivity() {

    lateinit var oLista:List<ObjListaNota>
     lateinit var oAdaptadorNotas:AdaptadorNotas
    lateinit var oLista2:ArrayList<ObjListaNota>
    var TIPOACCION:String = "N"

    lateinit var oNuevoNotas: Dialog
    lateinit var oContexto: Context
    lateinit var oObjNota: ObjListaNota


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listado_notas)
        oContexto=this

      btnBuscarAlumno.setOnClickListener()
        {
            ConsultarVolley()
            //buscarProveedor();

        }


       /* oAdaptadorNotas = AdaptadorNotas(oLista){

                oObjNota = it
                TIPOACCION = "A"
                // CargarVentanaProveedor()
            //MostrarRegistro()

        }

        */




        //MostrarListado()
        /*btnNuevoProveedor.setOnClickListener()
        {
            CargarVentanaProveedor();
        }

         */
    }


   fun MostrarListado()
    {
        oAdaptadorNotas= AdaptadorNotas(oLista)
        {
            oObjNota = it
            TIPOACCION = "A"
            // CargarVentanaProveedor()
            MostrarRegistro()
        }
        lvListaNotas.setAdapter(oAdaptadorNotas)

        val llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.VERTICAL
        lvListaNotas.setLayoutManager(llm)
        lvListaNotas.setHasFixedSize(true)
        lvListaNotas.setAdapter(oAdaptadorNotas)
    }



    fun MostrarRegistro()
    {
        var oedtCodigoAlumno = oNuevoNotas.findViewById(R.id.txtCodigoAlumno) as TextView
        var oedtAMoviles = oNuevoNotas.findViewById(R.id.txtAMoviles) as TextView
        var oedtFinanzas = oNuevoNotas.findViewById(R.id.txtFinanzas) as TextView


        oedtCodigoAlumno.setText(oObjNota.codigoAlumno)
        oedtAMoviles.setText(oObjNota.aMoviles)
        oedtFinanzas.setText(oObjNota.finanzas)

    }




    /* public fun buscarProveedor()
      {
          oLista = ArrayList<ObjListaPROVEEDOR>();
          val oIProveedor: IProveedor
          oIProveedor = RestProveedor().getPROVEEDOR()!!.create( IProveedor::class.java )
          val call: Call<PROVEEDORRESPONSE> = oIProveedor.getLista( 0,
              edtRazonSocial.text.toString(),
              "","")

          call.enqueue(object : Callback<PROVEEDORRESPONSE?> {
              override fun onResponse( call: Call<PROVEEDORRESPONSE?>?,
                                       response: retrofit2.Response<PROVEEDORRESPONSE?>
              ) {
                  Log.d("body", response.body().toString())
                  try {
                      oLista = response.body()!!.objListaPROVEEDOR
                      MostrarListado()
                  } catch (e: java.lang.Exception) {
                      Log.d("app", e.toString())
                  }
              }

              override fun onFailure(
                  call: Call<PROVEEDORRESPONSE?>?,
                  t: Throwable
              ) {
                  Log.d("ERROR", t.toString())
              }
          })
      }

*/

    /*  public fun CargarVentanaProveedor()
      {
          oNuevoPRoveedor = Dialog(oContexto)
          oNuevoPRoveedor.requestWindowFeature(Window.FEATURE_NO_TITLE)
          oNuevoPRoveedor.setCancelable(false)
          oNuevoPRoveedor.setContentView(R.layout.activity_nuevo_proveedor)
          // CargarRegistro()
          val obtnagregarNuevoprov = oNuevoPRoveedor.findViewById(R.id.btnagregarNuevoprov) as Button
          val obtnCancelarNuevoprov = oNuevoPRoveedor.findViewById(R.id.btnCancelarNuevoprov) as Button
          obtnagregarNuevoprov.setOnClickListener {
              GrabarRegistro()
              oNuevoPRoveedor.dismiss() }
          obtnCancelarNuevoprov.setOnClickListener { oNuevoPRoveedor.dismiss() }
          oNuevoPRoveedor.show()
      }
      */
     /*

      fun GrabarRegistro()
      {
          val oedtrazonsocialnuevo = oNuevoPRoveedor.findViewById(R.id.edtrazonsocialnuevo) as EditText
          val oedtdireccionnuevo = oNuevoPRoveedor.findViewById(R.id.edtdireccionnuevo) as EditText
          val oedtrucnuevo = oNuevoPRoveedor.findViewById(R.id.edtrucnuevo) as EditText

          if (TIPOACCION == "N")
          {
              oObjPROVEEDOR = ObjListaPROVEEDOR()
              oObjPROVEEDOR.codigoProveedor=0;
          }

          oObjPROVEEDOR.razonSocial = oedtrazonsocialnuevo.text.toString()
          oObjPROVEEDOR.direccion = oedtdireccionnuevo.text.toString()
          oObjPROVEEDOR.ruc = oedtrucnuevo.text.toString()

          val oIProveedor: IProveedor
          oIProveedor = RestProveedor().getPROVEEDOR()!!.create( IProveedor::class.java )
          val call: Call<ObjPROVEEDOR> = oIProveedor.getRegistraModifica( TIPOACCION,oObjPROVEEDOR.codigoProveedor,
              oObjPROVEEDOR.razonSocial,
              oObjPROVEEDOR.direccion,
              oObjPROVEEDOR.ruc)

          call.enqueue(object : Callback<ObjPROVEEDOR?> {
              override fun onResponse( call: Call<ObjPROVEEDOR?>?,
                                       response: retrofit2.Response<ObjPROVEEDOR?>
              ) {
                  Log.d("body", response.body().toString())
                  try {
                      oObjPROVEEDOR.codigoProveedor = response.body()!!.codigoProveedor
                      ConsultarPRoveedores()
                  } catch (e: java.lang.Exception) {
                      Log.d("app", e.toString())
                  }
              }

              override fun onFailure(
                  call: Call<ObjPROVEEDOR?>?,
                  t: Throwable
              ) {
                  Log.d("ERROR", t.toString())
              }
          })


      }
*/






    fun ConsultarVolley()
    {
        var oVolley= Volley.newRequestQueue(this)
        var strUrl= Constantes.ENDPOINT + Constantes.GETLISTA_NOTAS
/*
        val objJson=JsonObjectRequest(strUrl,null,
            com.android.volley.Response.Listener {

                Log.d("app",it.toString())
                //print("Response is: ${it.getJSONArray("ObjListaPROVEEDOR")}")
            },
            com.android.volley.Response.ErrorListener {
                Log.d("app","Error:" + it.message)
                print("Response is: ${it.message}")
            }
        )
        oVolley.add(objJson)
*/
        /*
        val stringRequest = StringRequest(
            Request.Method.GET, strUrl,
           com.android.volley.Response.Listener<String> { response ->
                print("Response is: ${response}")
            },
            com.android.volley.Response.ErrorListener {
                print("Response is: ${it.message}") })

        // Add the request to the RequestQueue.
        oVolley.add(stringRequest)
*/
        val params = HashMap<String, String>()
        System.out.println(txtAlumno.text.toString())
        params["CodigoAlumno"] = txtAlumno.text.toString()

        var objRequest= ObjectRequest<NotasResponse>(
            Request.Method.GET,
                strUrl,
                params as Map<String, Any>?,
                NotasResponse::class.java,
                Response.Listener {
                    oLista = it.objListaNotas
                    MostrarListado()
                },
                Response.ErrorListener {
                    print("Response is: ${it.message}")
                }
        )
        oVolley.add(objRequest)
    }

   /*   fun ConsultarPRoveedores()
      {
          var oVolley= Volley.newRequestQueue(this)
          var strUrl=Constantes.ENDPOINT + Constantes.GETLISTA_PROVEEDOR

          val params = HashMap<String,String>()
          params["RazonSocial"] = edtRazonSocial.text.toString()

          var objRequest=ObjectRequest<PROVEEDORRESPONSE>(Request.Method.GET,
              strUrl,
              params as Map<String, Any>?,
              PROVEEDORRESPONSE::class.java,
              Response.Listener {
                  oLista = it.objListaPROVEEDOR
                  MostrarListado()
              },
              Response.ErrorListener {
                  print("Response is: ${it.message}")
              }
          )
          oVolley.add(objRequest)
      }

*/
}