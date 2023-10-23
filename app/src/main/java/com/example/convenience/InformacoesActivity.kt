package com.example.convenience

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class InformacoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacoes)

        val tripInfoIda = intent.getStringExtra("TRIP_INFO_IDA")
        val tripInfoVolta = intent.getStringExtra("TRIP_INFO_VOLTA")

        val tripInfoIdaTextView: TextView = findViewById(R.id.tripInfoIdaTextView)
        val tripInfoVoltaTextView: TextView = findViewById(R.id.tripInfoVoltaTextView)

        tripInfoIdaTextView.text = tripInfoIda
        tripInfoVoltaTextView.text = tripInfoVolta
    }
}