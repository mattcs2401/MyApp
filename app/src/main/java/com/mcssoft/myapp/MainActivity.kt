package com.mcssoft.myapp

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_todo -> {
                message.setText(R.string.title_todo)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_shopping -> {
                message.setText(R.string.title_shopping)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_admin -> {
                message.setText(R.string.title_admin)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_preferences -> {
                message.setText(R.string.title_preferences)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
