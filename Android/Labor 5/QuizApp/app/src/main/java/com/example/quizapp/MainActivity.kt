package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import com.example.quizapp.shared.QuizControllerViewModel
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView

const val TAG_MAIN : String = "Main activity"
const val EXTRA_MESSAGE = "userName"


class MainActivity : AppCompatActivity() {

    private lateinit var topAppBar : MaterialToolbar
    private lateinit var drawerLayout : DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model: QuizControllerViewModel by viewModels()
        initializeView()
    }

    private fun initializeView() {
        topAppBar = findViewById(R.id.topAppBar)
        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navView)

        topAppBar.setNavigationOnClickListener {
            drawerLayout.open()
        }

        navigationView.setNavigationItemSelectedListener { menuItem ->
            // Handle menu item selected
            menuItem.isChecked = true
            drawerLayout.close()

            true
        }



        val navController = findNavController(R.id.nav_host_fragment)

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.item1 -> {
                    // Handle menu item selected
                    menuItem.isChecked = true
                    drawerLayout.close()

                    navController.navigate(R.id.homeFragment)

                    true
                }
                R.id.item2 -> {
                    // Handle menu item selected
                    menuItem.isChecked = true
                    drawerLayout.close()

                    navController.navigate(R.id.quizStartFragment)

                    true
                }
                else -> false
            }
        }
    }
}