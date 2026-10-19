package com.example.devmob_tp_04_carnetpatient_cycledevie

import android.util.Log
import androidx.lifecycle.ViewModel


class PatientViewModel : ViewModel() {

    private val _patients = mutableListOf<Patient>()

    val patients: List<Patient>
        get() = _patients

    fun ajouter(id:Int ,nom:String ){
        val patient = Patient (id, nom)
        _patients.add(patient)
    }

    init{
        Log.d("ViewModel","Creation du ViewModel")
    }

    override fun onCleared(){
        super.onCleared()
        Log.d("ViewModel","Liberation du ViewModel")
    }

    //faut modifier la classe et l'appeler en main kotlin

}