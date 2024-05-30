package com.example.remindmeapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.lang.Exception

class AgregarCategoria : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_categoria)
        val nombreCategoria = findViewById<EditText>(R.id.nombreCategoria)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)

        btnGuardar.setOnClickListener {
            val nuevaCategoria = nombreCategoria.text.toString()
            if (nuevaCategoria.isNotEmpty()){
                val resultIntent = Intent()
                resultIntent.putExtra("NUEVA_CATEGORIA", nuevaCategoria)
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            } else {
                nombreCategoria.error = "El nombre de la categoria no puede estar vacio"
            }
        }


    }
}