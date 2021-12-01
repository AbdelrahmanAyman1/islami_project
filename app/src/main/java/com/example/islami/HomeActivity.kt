package com.example.islami

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class HomeActivity : AppCompatActivity() {
    lateinit var bottomNavigation: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomNavigation = findViewById(R.id.bottom_navigation_bar)
        bottomNavigation.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener { menuItem ->
            if (menuItem.itemId == R.id.navigation_quran) {
                pushFragment(QuranFragment())

            } else if (menuItem.itemId == R.id.navigation_hadeth) {
                pushFragment(HadethFragment())
            } else if (menuItem.itemId == R.id.navigation_radio) {
                pushFragment(RadioFragment())

            } else if (menuItem.itemId == R.id.navigation_sebha) {
                pushFragment(TasbehFragment())
            }
            return@OnItemSelectedListener true
        })
        bottomNavigation.selectedItemId = R.id.navigation_quran
    }

    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}