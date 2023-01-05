package com.davidchura.sistemamarina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.davidchura.sistemamarina.adapters.CategoriaAdapter
import com.davidchura.sistemamarina.adapters.EmpleadoAdapter
import com.davidchura.sistemamarina.databinding.ActivityLoginBinding
import com.davidchura.sistemamarina.databinding.ActivityTiendaBinding
import org.json.JSONArray

class TiendaActivity : AppCompatActivity(), CategoriaAdapter.RecyclerViewClickListener {
    private lateinit var binding: ActivityTiendaBinding
    val arrayList = ArrayList<HashMap<String, String>>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTiendaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        leerServicios()
    }

    private fun leerServicios() {
        val queue = Volley.newRequestQueue(this)
        val url = "https://servicios.campus.pe/categorias.php"


        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                // Display the first 500 characters of the response string.
                Log.d("Datos", response)
                llenarLista(response)

            },
            Response.ErrorListener {
                Log.d("Datos error", it.message.toString())
            })


        queue.add(stringRequest)
    }

    private fun llenarLista(response: String?) {
        val jsonArray = JSONArray(response)
        for (i in 0 until jsonArray.length()){
            val idcategoria = jsonArray.getJSONObject(i).getString("idcategoria");
            val nombre = jsonArray.getJSONObject(i).getString("nombre");
            val descripcion = jsonArray.getJSONObject(i).getString("descripcion");


            val  map = HashMap<String, String>()
            map.put("idcategoria",idcategoria);
            map.put("nombre",nombre);
            map.put("descripcion",descripcion);
            arrayList.add(map);
        }

        val categoriaAdapter = CategoriaAdapter(arrayList, this)

        binding.rvCategorias.adapter = categoriaAdapter
        val  linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.rvCategorias.layoutManager = linearLayoutManager

    }

    override fun onItemClick(position: Int) {
        val map = arrayList.get(position);
        val nombre = map.get("nombre")
        Toast.makeText(this, nombre, Toast.LENGTH_SHORT).show()
    }
}


