package com.example.informationregistrationform

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.informationregistrationform.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding :ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        val shPref: SharedPreferences = getSharedPreferences("saveInfo", Context.MODE_PRIVATE)
        binding.idView.text = shPref.getInt("id",0).toString()
        binding.birthPlaceView.text = shPref.getString( "birthPlace","")
        binding.addressView.text = shPref.getString("address","")
        binding.PostalCodeView.text = shPref.getInt("postalCode", 0).toString()
        if (shPref.getBoolean("female",false)){
            binding.genderView.text = "female"
        }else{
            binding.genderView.text = "male"
        }

    }
}