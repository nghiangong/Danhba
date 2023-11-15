package com.example.phonebook

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ContactDetail : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contact_detail)

        try {
            val avatar = intent.getStringExtra("avatar")
            val name = intent.getStringExtra("name")
            val phoneNumber = intent.getStringExtra("phoneNumber")
            val email = intent.getStringExtra("email")
            val address = intent.getStringExtra("address")

            val avatarTextView: TextView = findViewById(R.id.avatar)
            val nameTextView: TextView = findViewById(R.id.name)
            val phoneNumberTextView: TextView = findViewById(R.id.phonenumber)
            val emailTextView: TextView = findViewById(R.id.email)


            nameTextView.text = "$name"
            avatarTextView.text = "$avatar"
            emailTextView.text = "$email"
            phoneNumberTextView.text = "$phoneNumber"

            setResult(Activity.RESULT_OK, intent)
        } catch (ex: Exception) {
            setResult(Activity.RESULT_CANCELED)
        }
    }
}