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

        actMainBind.topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.search -> {
                    Toast.makeText(this, "Поиск", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.more -> {
                    Toast.makeText(this, "Больше", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
        actMainBind.bottomNavigation.setOnItemSelectedListener  {
            when (it.itemId) {
                R.id.bottom_home -> {
                    Toast.makeText(this, "Домой", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.bottom_favourite -> {
                    Toast.makeText(this, "Избранное", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.bottom_library -> {
                    Toast.makeText(this, "Подборка", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}