package com.davidchura.sistemamarina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.davidchura.sistemamarina.adapters.EmpleadoAdapter
import org.json.JSONArray

class EmpleadosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empleados)

        leerServicios()
    }

    private fun leerServicios() {
        val queue = Volley.newRequestQueue(this)
        val url = "https://servicios.campus.pe/empleados.php"

// Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET, url,
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
            val nombres = jsonArray.getJSONObject(i).getString("nombres");
            val apellidos = jsonArray.getJSONObject(i).getString("apellidos");
            val cargo = jsonArray.getJSONObject(i).getString("cargo");
            val foto = jsonArray.getJSONObject(i).getString("foto");

            val  map = HashMap<String, String>()
            map.put("nombres",nombres);
            map.put("apellidos",apellidos);
            map.put("cargo",cargo);
            map.put("foto",foto);
            arrayList.add(map);
        }

        val empleadoAdapter = EmpleadoAdapter(arrayList)
        val  rvEmpleados: RecyclerView = findViewById(R.id.rvEmpleados)
        rvEmpleados.adapter = empleadoAdapter
        val  linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        rvEmpleados.layoutManager = linearLayoutManager

    }
}