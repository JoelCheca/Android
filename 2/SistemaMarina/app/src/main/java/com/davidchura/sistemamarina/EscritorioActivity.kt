package com.davidchura.sistemamarina

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.davidchura.sistemamarina.databinding.ActivityEscritorioBinding
import com.davidchura.sistemamarina.databinding.ActivityTiendaBinding

class EscritorioActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityEscritorioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEscritorioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTienda.setOnClickListener(this)
        binding.btnEmpleados.setOnClickListener(this)
        binding.btnCaja.setOnClickListener(this)
        binding.btnCoorporacion.setOnClickListener(this)
        binding.btnCerrarSesion.setOnClickListener(this)
        binding.btnSalir.setOnClickListener(this)
    }

    override fun onClick(view: View) {
       when(view.id){
           R.id.btnTienda -> startActivity( Intent(this, TiendaActivity::class.java))
       }
    }
}