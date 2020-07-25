package cibertec.edu.universidad

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cibertec.edu.universidad.beans.NotasBean
import cibertec.edu.universidad.pojos.ObjListaNota
import kotlinx.android.synthetic.main.registro_notas.view.*
import android.text.Editable as TextEditable


class AdaptadorNotas(val ListaInterna:List<ObjListaNota>, val clickListener: (ObjListaNota) -> Unit ) :
    RecyclerView.Adapter<AdaptadorNotas.NotasBeanHolder>() {

    var onItemClick: ((ObjListaNota)-> Unit)? = null

    public class NotasBeanHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        fun bindItems(oNotasBean: ObjListaNota)
        {
            val tvCodigoAlumno = itemView.findViewById(R.id.txtCodigoAlumno) as TextView
            val tvAMoviles = itemView.findViewById(R.id.txtAMoviles) as TextView
            val tvFinanzas = itemView.findViewById(R.id.txtFinanzas) as TextView
            val tvRedes = itemView.findViewById(R.id.txtRedes) as TextView
            val tvDisenioWeb = itemView.findViewById(R.id.txtDisenioWeb) as TextView
            tvCodigoAlumno.text = oNotasBean.codigoAlumno.toString()
            tvAMoviles.text = oNotasBean.aMoviles.toString()
            tvFinanzas.text = oNotasBean.finanzas.toString()
            tvRedes.text = oNotasBean.redes.toString()
            tvDisenioWeb.text = oNotasBean.disenioWeb.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdaptadorNotas.NotasBeanHolder {
        val v: View = LayoutInflater.from(parent?.context)
            .inflate(R.layout.registro_notas,parent,false)
        return NotasBeanHolder(v)
    }

    override fun getItemCount(): Int {
        return ListaInterna.size
    }

    override fun onBindViewHolder(holder: NotasBeanHolder, position: Int) {
        holder?.itemView.txtCodigoAlumno?.text = ListaInterna.get(position).codigoAlumno.toString()
        holder?.itemView.txtAMoviles?.text = ListaInterna.get(position).aMoviles.toString()
        holder?.itemView.txtFinanzas?.text = ListaInterna.get(position).finanzas.toString()
        holder?.itemView.txtRedes?.text = ListaInterna.get(position).redes.toString()
        holder?.itemView.txtDisenioWeb?.text = ListaInterna.get(position).disenioWeb.toString()
        holder?.itemView.setOnClickListener()
        {
            clickListener(ListaInterna.get(position))
        }
    }

    inner class viewHolder(pVista:View): RecyclerView.ViewHolder(pVista), View.OnClickListener
    {
        init {
            pVista.setOnClickListener()
            {
                onItemClick?.invoke(ListaInterna[adapterPosition])
            }
        }

        override fun onClick(v: View?) {
            onItemClick?.invoke(ListaInterna[adapterPosition])
        }
    }


}