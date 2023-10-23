package com.example.convenience

//import CadInfoActivity
//import InformacoesActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var btnCrono: Button
    private lateinit var btnDeslogar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCrono = findViewById(R.id.btnCrono)
        btnCrono.setOnClickListener {
            var intent = Intent(this, CronogramaActivity::class.java)
            startActivity(intent)
        }

        btnDeslogar = findViewById(R.id.btnDeslogar)
        btnDeslogar.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            val voltarTelaLogin = Intent(this, LoginActivity::class.java)
            startActivity(voltarTelaLogin)
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.itemInfo -> cadastrActivityInfo()
            else -> super.onOptionsItemSelected(item)
        }

    }
        private fun cadastrActivityInfo(): Boolean {
            var intent = Intent(this, CadInfoActivity::class.java)
            startActivity(intent)
            return true

        }



    }
