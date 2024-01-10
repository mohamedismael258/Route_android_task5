package com.example.assigment3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.assigment3.databinding.ActivityContactMainBinding
import com.example.assigment3.databinding.ActivityDetailsContactBinding

class ContactDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailsContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDetailsContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name = intent.getStringExtra("name_key")
        val phoneNumber=intent.getStringExtra("phone number_Key")
        binding.phoneNumber.setText(phoneNumber)
        binding.name.setText(name)
        binding.imageUser.setImageResource(R.drawable.avatar)
        binding.descrbtion.setText("Descrption")
    }
}