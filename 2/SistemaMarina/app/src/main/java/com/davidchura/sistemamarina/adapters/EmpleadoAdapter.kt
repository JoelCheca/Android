package com.davidchura.sistemamarina.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.davidchura.sistemamarina.R
import com.squareup.picasso.Picasso

class EmpleadoAdapter (val arrayList: ArrayList<HashMap<String,String>>):RecyclerView.Adapter<EmpleadoAdapter.ViewHolder>() {

    class ViewHolder(view:View):RecyclerView.ViewHolder(view) {
        val tvNombres : TextView = view.findViewById(R.id.tvNombres)
        val tvCargo : TextView = view.findViewById(R.id.tvCargo)
        val ivEmpleadoFoto :ImageView = view.findViewById(R.id.ivEmpleadoFoto)

        fun bind(map: HashMap<String, String>){
            tvNombres.text = map["nombres"] + " " + map["apellidos"];
            tvCargo.text = map["cargo"].toString()
            Picasso.get().load("https://servicios.campus.pe/fotos/"+map["foto"].toString()).into(ivEmpleadoFoto);
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_empleado, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(arrayList.get(position))
    }

    override fun getItemCount(): Int {
        return  arrayList.size
    }
}