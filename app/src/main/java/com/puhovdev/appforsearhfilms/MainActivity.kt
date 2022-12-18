package com.puhovdev.appforsearhfilms

import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.puhovdev.appforsearhfilms.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var backPressed = 0L
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initNavigation()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_placeholder, HomeFragment())
            .addToBackStack(null)
            .commit()

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
        if (supportFragmentManager.backStackEntryCount == ENTRY_COUNT) {
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

    private fun initNavigation() = with(binding) {

        bottomNavigation.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.bottom_favourite -> {
                    Toast.makeText(this@MainActivity, "Избранное", Toast.LENGTH_SHORT).show()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_placeholder, FavoritesFragment())
                        .addToBackStack(null)
                        .commit()
                    true
                }
                R.id.bottom_home -> {
                    Toast.makeText(this@MainActivity, "Home", Toast.LENGTH_SHORT).show()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_placeholder, HomeFragment())
                        .addToBackStack(null)
                        .commit()
                    true
                }
                R.id.bottom_library -> {
                    Toast.makeText(this@MainActivity, "Подборка", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }

    companion object {
        const val TIME_INTERVAL = 2000
        const val ENTRY_COUNT = 1
    }



}
