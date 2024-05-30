package com.example.remindmeapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class MenuRecordatorio : AppCompatActivity() {

    private lateinit var adaptador: ArrayAdapter<String>
    private val categorias = mutableListOf("Trabajo", "Estudio", "Reuniones")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_recordatorio)

        val listaCategorias = findViewById<ListView>(R.id.listaCategorias)
        adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, categorias)
        listaCategorias.adapter = adaptador

        listaCategorias.setOnItemClickListener { parent, view, position, id ->
            val categoriaSeleccionada = categorias[position]
            if (categoriaSeleccionada == "Trabajo") {
                abrirAgregarRecordatorio()
            }
        }

        val btnAgregar = findViewById<Button>(R.id.btnAgregar)
        btnAgregar.setOnClickListener {
            abrirAgregarCategoria()
        }
    }

    private fun abrirAgregarCategoria() {
        val intent = Intent(this, AgregarCategoria::class.java)
        startActivityForResult(intent, REQUEST_CODE_AGREGAR_CATEGORIA)
    }

    private fun abrirAgregarRecordatorio() {
        val intent = Intent(this, AgregarRecordatorioActivity::class.java)
        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_AGREGAR_CATEGORIA && resultCode == Activity.RESULT_OK) {
            val nuevaCategoria = data?.getStringExtra("NUEVA_CATEGORIA")
            if (nuevaCategoria != null) {
                categorias.add(nuevaCategoria)
                adaptador.notifyDataSetChanged()
            }
        }
    }

    companion object {
        const val REQUEST_CODE_AGREGAR_CATEGORIA = 1
    }
}
