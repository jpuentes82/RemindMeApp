package com.example.remindmeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val usuarioValido = "Juan"
    private val contrasenaValida = "Juan123"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usUsuario = findViewById<EditText>(R.id.usUsuario)
        val usContrasena = findViewById<EditText>(R.id.usContrasena)
        val btnInicioSession = findViewById<Button>(R.id.btnInicioSesion)


        btnInicioSession.setOnClickListener {
            val usuario = usUsuario.text.toString()
            val contrasena = usContrasena.text.toString()

            if(validarCredenciales(usuario, contrasena)){
            val intent = Intent(this, MenuRecordatorio::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
        }
    }
}
    private fun validarCredenciales (usuario: String, contrasena: String): Boolean {
        return usuario == usuarioValido && contrasena == contrasenaValida
    }
}