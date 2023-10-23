package com.example.convenience
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class CadInfoActivity : AppCompatActivity() {

    private lateinit var dateIdaEditText: EditText
    private lateinit var timeIdaEditText: EditText
    private lateinit var dateVoltaEditText: EditText
    private lateinit var timeVoltaEditText: EditText

    private lateinit var tripInfoIdaTextView: TextView
    private lateinit var tripInfoVoltaTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cad_info)

        dateIdaEditText = findViewById(R.id.dateIdaEditText)
        timeIdaEditText = findViewById(R.id.timeIdaEditText)
        dateVoltaEditText = findViewById(R.id.dateVoltaEditText)
        timeVoltaEditText = findViewById(R.id.timeVoltaEditText)

        tripInfoIdaTextView = findViewById(R.id.tripInfoIdaTextView)
        tripInfoVoltaTextView = findViewById(R.id.tripInfoVoltaTextView)


        val editIdaButton: Button = findViewById(R.id.editIdaButton)
        editIdaButton.setOnClickListener {
            enableEditing(dateIdaEditText, timeIdaEditText)
        }

        val editVoltaButton: Button = findViewById(R.id.editVoltaButton)
        editVoltaButton.setOnClickListener {
            enableEditing(dateVoltaEditText, timeVoltaEditText)
        }

        val saveButton: Button = findViewById(R.id.saveButton)
        saveButton.setOnClickListener {
            saveTripInfo()
        }
    }



    private fun enableEditing(dateEditText: EditText, timeEditText: EditText) {
        dateEditText.isEnabled = true
        timeEditText.isEnabled = true
        dateEditText.requestFocus()
    }

    private fun saveTripInfo() {
        val tripDateIda = dateIdaEditText.text.toString()
        val tripTimeIda = timeIdaEditText.text.toString()
        val tripDateVolta = dateVoltaEditText.text.toString()
        val tripTimeVolta = timeVoltaEditText.text.toString()

        val tripInfoIda = "Informações de ida:\nData: $tripDateIda\nHora: $tripTimeIda"
        val tripInfoVolta = "Informações de volta:\nData: $tripDateVolta\nHora: $tripTimeVolta"

        // Passar as informações para a InformacoesActivity
        val intent = Intent(this, InformacoesActivity::class.java).apply {
            putExtra("TRIP_INFO_IDA", tripInfoIda)
            putExtra("TRIP_INFO_VOLTA", tripInfoVolta)
        }
        startActivity(intent)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}

