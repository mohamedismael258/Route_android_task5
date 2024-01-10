package com.example.assigment3

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.view.View
import com.example.assigment3.databinding.ActivityContactMainBinding
import com.example.assigment3.databinding.ContactBinding

lateinit var contactList: MutableList<Contact>
lateinit var adabter: Adabter

class MainContactsActivity : AppCompatActivity() {
    lateinit var binding: ActivityContactMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        initRecyclerView()
        binding.saveBtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                validate(binding.name1.text.toString(), binding.phoneNumber1.text.toString())
            }
        })
    }

    private fun initRecyclerView() {
        creatContactList()
        adabter = Adabter(contactList)
        binding.ContactsRecyclarview.adapter = adabter
        adabter.onClickListner(object : Adabter.OnItemClick {
            override fun onItemClick(position: Int, contact: Contact) {
                val intent = Intent(this@MainContactsActivity, ContactDetailsActivity::class.java)
                intent.putExtra("name_key", contact.name)
                intent.putExtra("phone number_Key", contact.phoneNumber)
                startActivity(intent)
            }
        })
    }

    private fun validate(name: String, phoneNumber: String) {
        if (name.length < 3) {
            binding.name1.setError("invalid name")
        } else if (phoneNumber.length != 11) {
            binding.phoneNumber1.setError("invalid phone number")
        } else {
            setData()
        }
    }

    private fun setData() {
        val contact = Contact(
            R.drawable.avatar,
            binding.name1.text.toString(),
            binding.phoneNumber1.text.toString()
        )
        addToContactList(contact)
        binding.name1.setText("")
        binding.phoneNumber1.setText("")
        binding.Description1.setText("")
    }

    private fun creatContactList() {
        contactList = mutableListOf()
    }

    private fun addToContactList(contact: Contact) {
        contactList.add(contact)
    }


}