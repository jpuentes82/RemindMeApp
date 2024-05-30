package com.example.remindmeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnInicioSession = findViewById<Button>(R.id.btnInicioSesion)
        btnInicioSession.setOnClickListener {
            val intent = Intent(this, MenuRecordatorio::class.java)
            startActivity(intent)
        }
    }
}