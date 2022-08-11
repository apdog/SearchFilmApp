package com.puhovdev.appforsearhfilms

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.puhovdev.appforsearhfilms.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var actMainBind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actMainBind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(actMainBind.root)

        actMainBind.centralMenuButton1.setOnClickListener{
            Toast.makeText(applicationContext, resources.getString(R.string.button_1), Toast.LENGTH_SHORT).show()
        }
        actMainBind.centralMenuButton2.setOnClickListener {
            Toast.makeText(applicationContext, resources.getString(R.string.button_2), Toast.LENGTH_SHORT).show()
        }
        actMainBind.centralMenuButton3.setOnClickListener {
            Toast.makeText(applicationContext, resources.getString(R.string.button_3), Toast.LENGTH_SHORT).show()
        }
        actMainBind.centralMenuButton4.setOnClickListener {
            Toast.makeText(applicationContext, resources.getString(R.string.button_4), Toast.LENGTH_SHORT).show()
        }
        actMainBind.topAppBar.setNavigationOnClickListener {
            Toast.makeText(this, "Здесь соро будет меню", Toast.LENGTH_SHORT).show()
        }
        actMainBind.topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.search -> {
                    Toast.makeText(this, "Поиск", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.favourite -> {
                    Toast.makeText(this, "Избранное", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.more -> {
                    Toast.makeText(this, "Больше", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}