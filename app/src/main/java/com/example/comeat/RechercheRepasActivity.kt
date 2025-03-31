package com.example.comeat

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class RechercheRepasActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recherche_repas)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val spinerSpecialite = findViewById<Spinner>(R.id.selectionSpecialite)
        val spcialites = Modele.getSpecialites()
        val adaptateur = ArrayAdapter(this, android.R.layout.simple_spinner_item, spcialites)
        var specialite = ""
        var entreDate = ""


        adaptateur.setDropDownViewResource(android.R.layout.simple_spinner_item)
        spinerSpecialite.adapter = adaptateur
        spinerSpecialite.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected( parentView: AdapterView<*>,
                                         selectedItemView: View?,
                                         position: Int,
                                         id: Long
            ) {
                specialite = Modele.getSpecialites().get(position).toString().toString()
                println(specialite)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        val buttonDate: Button = findViewById(R.id.buttonDateSelec)
        val tvDate = findViewById<TextView>(R.id.selectionnerDate)
        buttonDate.setOnClickListener {
            val dateCourante = LocalDate.now()
            val annee = dateCourante.year
            val mois = dateCourante.monthValue - 1
            val jour = dateCourante.dayOfMonth
            val datePickerDialog = DatePickerDialog(
                this ,
                {
                        view , anneeSelect , moisSelect , jourSelect ->
                    val dateSelectionnee = LocalDate.of(
                        anneeSelect ,
                        moisSelect + 1 ,
                        jourSelect
                    )
                    val formateur = DateTimeFormatter.ofPattern( "dd/MM/yyyy" )
                    val dateFormatee = dateSelectionnee.format( formateur )

                    tvDate.text = dateFormatee
                    entreDate = tvDate.toString()
                    println(entreDate)

                } ,
                annee , mois , jour
            )
            datePickerDialog.show()

        }

        val buttonValider = findViewById<Button>(R.id.buttonValider)
        buttonValider.setOnClickListener {
            if(entreDate.toString() != "" && specialite.toString() != ""){
                startActivity(Intent(this, ListeRepasActivity::class.java))
            }
        }

    }
}