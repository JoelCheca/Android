package com.davidchura.sistemamarina.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.davidchura.sistemamarina.R
import com.squareup.picasso.Picasso

class CategoriaAdapter (val arrayList: ArrayList<HashMap<String,String>>,
    private val listener: RecyclerViewClickListener): RecyclerView.Adapter<CategoriaAdapter.ViewHolder>() {

   inner class ViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener {
        val tvCategoriaNombre : TextView = view.findViewById(R.id.tvCategoriaNombre)
        val tvCategoriaDescripcion: TextView = view.findViewById(R.id.tvCategoriaDescripcion)


        fun bind(map: HashMap<String, String>){
            tvCategoriaNombre.text = map["nombre"].toString()
            tvCategoriaDescripcion.text = map["descripcion"].toString()

        }
        init{
            view.setOnClickListener(this)

        }

        override fun onClick(p0: View?) {
            val posicion: Int = this.layoutPosition
            if (posicion!=RecyclerView.NO_POSITION){
                listener.onItemClick(posicion)
            }
        }
    }

    interface  RecyclerViewClickListener{
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_categoria, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(arrayList.get(position))
    }

    override fun getItemCount(): Int {
        return  arrayList.size
    }
}