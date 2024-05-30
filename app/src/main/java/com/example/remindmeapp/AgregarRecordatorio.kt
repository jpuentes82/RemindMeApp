package com.example.remindmeapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
class AgregarRecordatorioActivity : AppCompatActivity() {

    private lateinit var editTextTitulo: EditText
    private lateinit var editTextDescripcion: EditText
    private lateinit var btnGuardar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_recordatorio)

        // Inicializar vistas
        editTextTitulo = findViewById(R.id.editTextTitulo)
        editTextDescripcion = findViewById(R.id.editTextDescripcion)
        btnGuardar = findViewById(R.id.btnGuardar)

        // Configurar clic en el botón de guardar
        btnGuardar.setOnClickListener {
            Log.d("AgregarRecordatorio", "Clic en guardar detectado") // Agrega este Log para verificar el clic
            guardarRecordatorio()
        }

    }

    private fun guardarRecordatorio() {

        Log.d("AgregarRecordatorio", "Guardando recordatorio")
        val titulo = editTextTitulo.text.toString()
        val descripcion = editTextDescripcion.text.toString()

    }
}
