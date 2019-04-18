package com.mcssoft.myapp.ui.activity

import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.mcssoft.myapp.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_base.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

//    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
//        when (item.itemId) {
//            R.id.navigation_todo -> {
//                id_tv_main_message.setText(R.string.title_todo)
//                return@OnNavigationItemSelectedListener true
//            }
//            R.id.navigation_shopping -> {
//                id_tv_main_message.setText(R.string.title_shopping)
//                return@OnNavigationItemSelectedListener true
//            }
//            R.id.navigation_admin -> {
//                id_tv_main_message.setText(R.string.title_admin)
//                return@OnNavigationItemSelectedListener true
//            }
//            R.id.navigation_preferences -> {
//                id_tv_main_message.setText(R.string.title_preferences)
//                return@OnNavigationItemSelectedListener true
//            }
//        }
//        false
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialise()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    //<editor-fold defaultstate="collapsed" desc="Region: Bottom navigation listener">
    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when(menuItem.itemId) {
            R.id.id_navigation_todo -> {
                navController.navigate(R.id.id_todo_fragment)
            }
//            R.id.id_add -> {
////                val bundle = Bundle()
////                bundle.putInt(getString(R.string.key_edit_type), Constants.EDIT_RACE_NEW)
//                navController.navigate(R.id.id_edit_fragment, bundle)
//            }
        }
        return false
    }
    //</editor-fold>

    private fun initialise() {
        // Toolbar.
        setSupportActionBar(id_toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        // Navigation.
        navController = Navigation.findNavController(this, R.id.id_nav_host_fragment)
        bottomNavView = findViewById(R.id.id_bottom_nav_view)
        NavigationUI.setupWithNavController(bottomNavView, navController)
        bottomNavView.setOnNavigationItemSelectedListener(this)

        // Back Navigation.
        setupActionBarWithNavController(this, navController)
    }

    private lateinit var navController: NavController
    private lateinit var bottomNavView: BottomNavigationView

}
