package com.puhovdev.appforsearhfilms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 = findViewById<Button>(R.id.central_menu_button_1)
        button1.setOnClickListener {
            Toast.makeText(applicationContext, resources.getString(R.string.button_1), Toast.LENGTH_SHORT).show()
        }
        val button2 = findViewById<Button>(R.id.central_menu_button_2)
        button2.setOnClickListener {
            Toast.makeText(applicationContext, resources.getString(R.string.button_2), Toast.LENGTH_SHORT).show()
        }
        val button3 = findViewById<Button>(R.id.central_menu_button_3)
        button3.setOnClickListener {
            Toast.makeText(applicationContext, resources.getString(R.string.button_3), Toast.LENGTH_SHORT).show()
        }
        val button4 = findViewById<Button>(R.id.central_menu_button_4)
        button4.setOnClickListener {
            Toast.makeText(applicationContext, resources.getString(R.string.button_4), Toast.LENGTH_SHORT).show()
        }
    }
}