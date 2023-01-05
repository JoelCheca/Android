package com.davidchura.sistemamarina

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnEmpezar: Button = findViewById(R.id.btnEmpezar)
        btnEmpezar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        startActivity( Intent(this, EmpezarActivity::class.java))
    }
}