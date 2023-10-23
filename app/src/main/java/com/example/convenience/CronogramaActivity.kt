package com.example.convenience

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.convenience.ui.ListaDeAtividadesFragment

class CronogramaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cronograma)


        val listaFragment = ListaDeAtividadesFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, listaFragment)
            .commit()

    }

}
