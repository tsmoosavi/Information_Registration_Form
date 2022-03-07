package com.example.informationregistrationform

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.informationregistrationform.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding :ActivityMain2Binding
    var editPermission = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        buttonsListener()

    }
    private fun initView() {
        val shPref: SharedPreferences = getSharedPreferences("saveInfo", Context.MODE_PRIVATE)
        binding.idView.text = shPref.getString("id","کد ملی")
        binding.birthPlaceView.text = shPref.getString( "birthPlace","محل تولد")
        binding.addressView.text = shPref.getString("address","آدرس")
        binding.PostalCodeView.text = shPref.getString("postalCode", "کد پستی")
        if (shPref.getBoolean("female",false)){
            binding.genderView.text = "female"
        }else if (shPref.getBoolean("male",false)){
            binding.genderView.text = "male"
        }else{
            null
        }
    }
    fun buttonsListener(){
        binding.changeInfoBtn.setOnClickListener{
            editPermission = true
            val shPref: SharedPreferences = getSharedPreferences("saveInfo", Context.MODE_PRIVATE)
            val editor = shPref.edit()
            editor.putBoolean("permissionForEdit", editPermission)
            editor.apply()
            var backToFirstPage = Intent(this, MainActivity::class.java)
            startActivity(backToFirstPage)

        }
        binding.newUser.setOnClickListener{
            val shPref: SharedPreferences = getSharedPreferences("saveInfo", Context.MODE_PRIVATE)
            shPref.edit().clear().apply()
            editPermission = true
            val editor = shPref.edit()
            editor.putBoolean("permissionForEdit", editPermission)
            editor.apply()
            var backToFirstPage = Intent(this, MainActivity::class.java)
            startActivity(backToFirstPage)

        }
    }

}
