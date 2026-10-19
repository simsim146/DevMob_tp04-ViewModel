package com.example.devmob_tp_04_carnetpatient_cycledevie

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {



    private val patients = mutableListOf<Patient>()
    private lateinit var tvPatients: TextView
    private lateinit var tvNombrePatients: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        Log.d("MainActivity","onCreate Called")


        // Configuration d'affichage autour des barres système.
        val main = findViewById<View>(R.id.main)
        val marge = (16 * resources.displayMetrics.density).toInt()
        ViewCompat.setOnApplyWindowInsetsListener(main) { vue, insets ->
            val barres = insets.getInsets(
                WindowInsetsCompat.Type.systemBars()
            )
            vue.setPadding(
                marge + barres.left, marge + barres.top,
                marge + barres.right, marge + barres.bottom
            )
            insets
        }
        val etId = findViewById<EditText>(R.id.etId)
        val etNom = findViewById<EditText>(R.id.etNom)
        val btnAjouter = findViewById<Button>(R.id.btnAjouter)
        tvPatients = findViewById(R.id.tvPatients)
        tvNombrePatients = findViewById(R.id.tvNombrePatients)
        afficherPatients()
        btnAjouter.setOnClickListener {
            etId.error = null
            etNom.error = null
            val id = etId.text.toString().trim().toIntOrNull()
            val nom = etNom.text.toString().trim()
            if (id == null || id <= 0) {
                etId.error = "Saisir un identifiant positif"
            } else if (nom.isBlank()) {
                etNom.error = "Saisir le nom du patient"
            } else if (patients.any { it.id == id }) {
                etId.error = "Cet identifiant existe déjà"
            } else {
                val patient = Patient(id, nom)
                patients.add(patient)
                afficherPatients()
                etId.text.clear()
                etNom.text.clear()
                etId.requestFocus()
            }
        }
    }
    private fun afficherPatients() {
        tvNombrePatients.text =
            "Nombre de patients : ${patients.size}"
        tvPatients.text = if (patients.isEmpty()) {
            "Aucun patient enregistré"
        } else {
            patients.joinToString("\n") {
                "${it.id} — ${it.nom}"
            }
        }
    }


    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume Called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity", "onRestart Called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy Called")
    }

}