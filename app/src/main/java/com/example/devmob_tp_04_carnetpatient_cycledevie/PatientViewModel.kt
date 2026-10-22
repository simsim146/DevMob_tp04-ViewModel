package com.example.devmob_tp_04_carnetpatient_cycledevie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class PatientViewModel : ViewModel() {

  //  private val _patients = mutableListOf<Patient>()

    private val _patients = MutableLiveData<List<Patient>>(emptyList())


    //val patients: List<Patient>
    //get() = _patients
    val patients: LiveData<List<Patient>>
        get() = _patients

    /*fun ajouter(id:Int ,nom:String ){
        val patient = Patient (id, nom)
        _patients.add(patient)
    }*/

    fun ajouter(id:Int , nom:String): Boolean
    {
        val patient = Patient(id, nom)
        val liste = _patients.value.orEmpty().toMutableList()
        if(liste.any { it.id == patient.id } )
        {return false}
        liste.add(patient)
        _patients.value = liste
        return true

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