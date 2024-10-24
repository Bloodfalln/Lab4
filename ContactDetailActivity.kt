package com.example.lab4

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ContactDetailActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val name = intent.getStringExtra("CONTACT_NAME")
        val number = intent.getStringExtra("CONTACT_NUMBER")
        val city = intent.getStringExtra("CONTACT_CITY")
        val email = intent.getStringExtra("CONTACT_EMAIL")

        findViewById<TextView>(R.id.contact_name).text = name
        findViewById<TextView>(R.id.contact_number).text = number
        findViewById<TextView>(R.id.contact_city).text = city
        findViewById<TextView>(R.id.contact_email).text = email
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}