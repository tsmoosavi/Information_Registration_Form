package com.example.informationregistrationform

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.informationregistrationform.databinding.ActivityMain2Binding
import com.example.informationregistrationform.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val shPref: SharedPreferences = getSharedPreferences("saveInfo", Context.MODE_PRIVATE)
//        if ( shPref.contains(""))
//        if ( shPref != null){
//            var goToPage2 = Intent(this, MainActivity2::class.java)
//            startActivity(goToPage2)
//        }else{
            initView()
//        }
    }

    private fun initView() {
        val shPref: SharedPreferences = getSharedPreferences("saveInfo", Context.MODE_PRIVATE)
        val editor = shPref.edit()
        binding.name.setText(shPref.getString("name",""))
        binding.id.setText(shPref.getString("id",""))
        binding.birthplace.setText(shPref.getString( "birthPlace",""))
        binding.address.setText( shPref.getString("address",""))
        binding.PostalCode.setText(shPref.getString("postalCode",""))
        if (shPref.getBoolean("female",false)){
            binding.radioButton.isChecked = true
        }else if (shPref.getBoolean("male",false)){
            binding.radioButton2.isChecked = true
        }


        binding.register?.setOnClickListener {
            if (binding.name.text.isNullOrBlank()) {
                    binding.name.error = "فیلد را پر کنید."
                }
            else if (binding.id.text.isNullOrBlank()) {
                    binding.id.error = "فیلد را پر کنید."
                }
            else if(binding.id.text.toString().length != 10){
                    binding.id.error = "کد ملی باید 10 رقم باشد."
                }
            else if (binding.birthplace.text.isNullOrBlank()) {
                    binding.birthplace.error = "فیلد را پر کنید."
                }
            else if (binding.address.text.isNullOrBlank()) {
                    binding.address.error = "فیلد را پر کنید."
                }
            else if (binding.PostalCode.text.isNullOrBlank()) {
                    binding.PostalCode.error = "فیلد را پر کنید."
                }
            else if (!binding.radioButton.isChecked && !binding.radioButton2.isChecked) {
                    binding.gender.error = "جنسیت خود را انتخاب کنید."
                }
            else {
                editor.putString("name", binding.name.text.toString())
                editor.putString("id", binding.id.text.toString())
                editor.putString("birthPlace", binding.birthplace.text.toString())
                editor.putString("address", binding.address.text.toString())
                editor.putString("postalCode", binding.PostalCode.text.toString())
                editor.putBoolean("female", binding.radioButton.isChecked)
                editor.putBoolean("male", binding.radioButton2.isChecked)
                editor.apply()

                var goToPage2 = Intent(this, MainActivity2::class.java)
                startActivity(goToPage2)

            }



        }

    }
}

