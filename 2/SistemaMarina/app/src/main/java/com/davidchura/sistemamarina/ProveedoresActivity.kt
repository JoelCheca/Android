package com.davidchura.sistemamarina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.ListView
import android.widget.SimpleAdapter
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import kotlin.math.log

class ProveedoresActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_proveedores2)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true);

        leerServicios()
    }

    private fun leerServicios() {
        val queue = Volley.newRequestQueue(this)
        val url = "https://servicios.campus.pe/proveedores.php"

// Request a string response from the provided URL.
        val stringRequest = StringRequest(Request.Method.GET, url,
            Response.Listener<String> { response ->
                // Display the first 500 characters of the response string.
                Log.d("Datos", response)
                llenarLista(response);

            },
            Response.ErrorListener {
                Log.d("Datos error", it.message.toString())
            })

// Add the request to the RequestQueue.
        queue.add(stringRequest)

    }

    private fun llenarLista(response: String?) {
        val jsonArray = JSONArray(response)
        val arrayList = ArrayList<HashMap<String, String>>()
        for (i in 0 until jsonArray.length()){
            val nombreempresa = jsonArray.getJSONObject(i).getString("nombreempresa");
            val nombrecontacto = jsonArray.getJSONObject(i).getString("nombrecontacto");
            val pais = jsonArray.getJSONObject(i).getString("pais");
            val  map = HashMap<String, String>()
            map.put("nombreempresa",nombreempresa);
            map.put("nombrecontacto",nombrecontacto);
            map.put("pais",pais);
            arrayList.add(map);
        }
        val datosOrigen = arrayOf("nombreempresa","nombrecontacto","pais")
        val destino = intArrayOf(R.id.tvProveedorEmpresa,R.id.tvProveedorContacto,R.id.tvProveedorPais)

        val  listAdapter = SimpleAdapter(
            this,
            arrayList,
            R.layout.item_proveedor,
            datosOrigen,
            destino
        )
        val lvProveedores: ListView = findViewById(R.id.lvProveedores)
        lvProveedores.adapter = listAdapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean{
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}