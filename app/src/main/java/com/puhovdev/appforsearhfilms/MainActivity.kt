package com.puhovdev.appforsearhfilms

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
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
                    val tag= "favourite"
                    val fragment = checkFragmentExistence(tag)
                    changeFragment(fragment?: FavoritesFragment(), tag)
                    true
                }
                R.id.bottom_home -> {
                    val tag= "home"
                    val fragment = checkFragmentExistence(tag)
                    changeFragment(fragment?: HomeFragment(), tag)
                    true
                }
                R.id.bottom_library -> {
                    val tag= "library"
                    val fragment = checkFragmentExistence(tag)
                    changeFragment(fragment?: LibraryFragment(), tag)
                    true
                }
                else -> false
            }
        }
    }

    private fun checkFragmentExistence(tag: String): Fragment? = supportFragmentManager.findFragmentByTag(tag)

    private fun changeFragment(fragment: Fragment, tag: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_placeholder, fragment, tag)
            .addToBackStack(null)
            .commit()
    }

    companion object {
        const val TIME_INTERVAL = 2000
        const val ENTRY_COUNT = 1
    }



}
