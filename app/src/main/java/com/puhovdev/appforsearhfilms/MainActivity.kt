package com.puhovdev.appforsearhfilms

import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.puhovdev.appforsearhfilms.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var backPressed = 0L
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_placeholder, HomeFragment())
            .addToBackStack(null)
            .commit()

        binding.bottomNavigation.setOnItemSelectedListener  {
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

    fun launchDetailsFragment(film: Film) {
        val bundle = Bundle()
        bundle.putParcelable("film", film)
        val fragment = DetailsFragment()
        fragment.arguments = bundle

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_placeholder, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1){
            if (backPressed + TIME_INTERVAL > System.currentTimeMillis()) {
                super.onBackPressed()
                finish()
            } else {
                Toast.makeText(this, "Нажмите два раза для выхода", Toast.LENGTH_SHORT).show()
            }
        } else {
            super.onBackPressed()
        }

        backPressed = System.currentTimeMillis()
    }

    companion object{
        const val TIME_INTERVAL = 2000
    }


}
