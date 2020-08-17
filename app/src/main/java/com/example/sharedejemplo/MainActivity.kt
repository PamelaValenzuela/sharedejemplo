package com.example.sharedejemplo

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
//1. tener una variable de referencia para shared preferences
    lateinit var mSharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //2. tener una value para el nombre del archivo de SharedPreferences
        val mFileName = "package com.example.sharedejemplo"
          //3.Instanciar las shared Preferences
        // el context es la clase Context
        mSharedPreferences = getSharedPreferences(mFileName, Context.MODE_PRIVATE)
var mUserKey ="user"
        var mUser = "pamela.valezuela@usach.cl"

        //aplicar el cambio
        //sincronico se guarda de inmediato, asincronico se guarda el hilo por detras
       // apply asincronico, commit sincronico
        mSharedPreferences.edit().putString(mUserKey,mUser).apply()
        // creamos el metodo
        // update se utiliza la misma llave y se guarda informacion

        var mUserRead = mSharedPreferences.getString(mUserKey,"")
        Log.d("TAG",mUserRead)

        //para eliminar
        mSharedPreferences.edit().remove(mUserKey).apply()
        // para eliminar todos los campos
        mSharedPreferences.edit().clear().apply()

}}