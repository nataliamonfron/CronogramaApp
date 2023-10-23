package com.example.convenience

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.convenience.databinding.ActivityCadastroBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding
    private val auth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCadastro.setOnClickListener {view ->
            val email = binding.editEmailCadastro.text.toString()
            val senha = binding.editSenhaCadastro.text.toString()

            if(email.isEmpty() || senha.isEmpty()) {
                val snackbar = Snackbar.make(view, "Preencha todos os campos!", Snackbar.LENGTH_LONG)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()
            } else {
                auth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener { cadastro ->
                    if (cadastro.isSuccessful){
                        val snackbar = Snackbar.make(view, "Sucesso ao cadastrar!", Snackbar.LENGTH_LONG)
                        snackbar.setBackgroundTint(Color.BLUE)
                        snackbar.show()
                        binding.editEmailCadastro.setText("")
                        binding.editSenhaCadastro.setText("")

                    }
                }.addOnFailureListener { exception ->

                    val mensagemErro = when(exception){
                        is FirebaseAuthWeakPasswordException -> "Digite uma senha com mais de 6 caracteres."
                        is FirebaseAuthInvalidCredentialsException -> "Digite um e-mail válido."
                        is FirebaseAuthUserCollisionException -> "Esta conta já existe."
                        is FirebaseNetworkException -> "Sem conexão com a internet."
                        else -> "Erro ao cadastrar o usuário."
                    }
                    val snackbar = Snackbar.make(view, mensagemErro, Snackbar.LENGTH_LONG)
                    snackbar.setBackgroundTint(Color.RED)
                    snackbar.show()

                }
            }


        }
    }
}