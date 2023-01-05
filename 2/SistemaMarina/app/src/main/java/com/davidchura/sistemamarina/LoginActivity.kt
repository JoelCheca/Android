package com.davidchura.sistemamarina

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import com.davidchura.sistemamarina.databinding.ActivityLoginBinding
import com.davidchura.sistemamarina.databinding.ActivityMapsBinding

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIniciarSesion.setOnClickListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_inicio, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.nav_Proveedores -> {
                startActivity(Intent(this, ProveedoresActivity::class.java))
                true
            }
            R.id.nav_Ayuda -> {
                startActivity(Intent(this, AyudaActivity::class.java))
                true
            }
            R.id.nav_Oficinas -> {
                startActivity(Intent(this, OficinasActivity::class.java))
                true
            }
            R.id.nav_Empleados -> {
                startActivity(Intent(this, EmpleadosActivity::class.java))
                true
            }

            R.id.nav_mapa -> {
                startActivity(Intent(this, MapsActivity::class.java))
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onClick(p0: View?) {
        startActivity( Intent(this, EscritorioActivity::class.java))
    }
}