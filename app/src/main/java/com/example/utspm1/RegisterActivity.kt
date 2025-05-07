package com.example.utspm1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity  : AppCompatActivity() {
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val etNama = findViewById<EditText>(R.id.etNama)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        sharedPref = getSharedPreferences("UserTicketApp", MODE_PRIVATE)

        btnRegister.setOnClickListener {
            val nama = etNama.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            if (nama.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Semua data wajib diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Simpan data ke SharedPreferences
            sharedPref.edit()
                .putString("NAMA", nama)
                .putString("EMAIL", email)
                .putString("PASSWORD", password)
                .apply()

            Log.d("REGISTER", "Nama: $nama, Email: $email")
            Toast.makeText(this, "Pendaftaran berhasil! Selamat membeli tiket, $nama", Toast.LENGTH_LONG).show()

            // Kembali ke Login
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}