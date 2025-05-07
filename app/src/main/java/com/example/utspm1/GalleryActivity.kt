package com.example.utspm1

import android.os.Bundle
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity

    class GalleryActivity : AppCompatActivity() {
        // Array gambar poster tiket
        private val tickets = arrayOf(
            R.drawable.ticket_concert,
            R.drawable.ticket_movie,
            R.drawable.ticket_sport,
            R.drawable.ticket_theater
        )

        // Judul tiket yang ditampilkan
        private val ticketTitles = arrayOf(
            "Konser Musik",
            "Film Box Office",
            "Pertandingan Bola",
            "Drama Teater"
        )

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_gallry)

            val gridView = findViewById<GridView>(R.id.gridView)
            gridView.adapter = TicketAdapter(this, tickets, ticketTitles)
        }
    }
