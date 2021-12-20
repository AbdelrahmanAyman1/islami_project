package com.example.islami.ui.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.islami.*
import com.example.islami.ui.home.fragments.HadethFragment
import com.example.islami.ui.home.fragments.QuranFragment
import com.example.islami.ui.home.fragments.RadioFragment
import com.example.islami.ui.home.fragments.TasbehFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.switchmaterial.SwitchMaterial

class HomeActivity : AppCompatActivity() {
    lateinit var bottomNavigation: BottomNavigationView
    lateinit var switchButton: SwitchMaterial
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomNavigation = findViewById(R.id.bottom_navigation_bar)
        switchButton = findViewById(R.id.dark_mode_switch_button)
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
        switchButton.setOnClickListener(View.OnClickListener {
            if (switchButton.isChecked == false) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        })
    }


    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}