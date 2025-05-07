package com.example.utspm1

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvRegister = findViewById<TextView>(R.id.btnRegister)

        sharedPref = getSharedPreferences("UserTicketApp", MODE_PRIVATE)

        btnLogin.setOnClickListener {
            val emailInput = etEmail.text.toString()
            val passwordInput = etPassword.text.toString()

            val savedEmail = sharedPref.getString("EMAIL", null)
            val savedPassword = sharedPref.getString("PASSWORD", null)

            if (emailInput == savedEmail && passwordInput == savedPassword) {
                Toast.makeText(this, "Login berhasil! Selamat membeli tiket 🎟️", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, GalleryActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Email atau password salah", Toast.LENGTH_SHORT).show()
            }
        }

        tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}