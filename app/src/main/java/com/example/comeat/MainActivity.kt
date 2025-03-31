package com.example.comeat

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val emailSaisie = findViewById<TextView>(R.id.email)
        val mdpSaisie = findViewById<TextView>(R.id.mdp)
        val connexion: Button = findViewById(R.id.bouttonConnexion)
        val annuler = findViewById<Button>(R.id.annuler)

        connexion.setOnClickListener {
            val email = emailSaisie.text.toString()
            val mdp = mdpSaisie.text.toString()
            Log.d("ACT_CONN", "Connexion : $email/$mdp")

            var r : Utilisateur? = Modele.findUtilisateur(email, mdp)

            if( r != null ){
                Session.ouvrir(utilisateur = r)
                startActivity(Intent(this, MenuRepasActivity::class.java))
            }
            else{
                println("Aucun utilisateur trouvé !")
            }

        }

        annuler.setOnClickListener {
            emailSaisie.text = ""
            mdpSaisie.text = ""

            Log.d("ACT_CONN", "Annulation")
        }

    }
}





