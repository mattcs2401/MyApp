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
import kotlinx.android.synthetic.main.toolbar_base.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

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
            R.id.id_navigation_shopping -> {
                navController.navigate(R.id.id_shopping_fragment)
            }
            R.id.id_navigation_admin -> {
                navController.navigate(R.id.id_admin_fragment)
            }
            R.id.id_navigation_settings -> {
                navController.navigate(R.id.id_settings_fragment)
            }
//            R.id.example_with_bundle -> {
//                val bundle = Bundle()
//                bundle.putInt(getString(R.string.key), Constants.SOME_CONSTANT)
//                navController.navigate(R.id.id_some_fragment, bundle)
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
