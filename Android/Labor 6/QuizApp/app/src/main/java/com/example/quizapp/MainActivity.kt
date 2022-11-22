package com.example.quizapp

import android.app.AlertDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.OnBackPressedCallback
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.quizapp.fragments.navmenu.HomeFragment
import com.example.quizapp.fragments.navmenu.ListOfQuestionsFragment
import com.example.quizapp.fragments.navmenu.NewQuestionFragment
import com.example.quizapp.fragments.navmenu.ProfileFragment
import com.example.quizapp.fragments.quiz.QuizStartFragment
import com.example.quizapp.shared.QuizControllerViewModel
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView

const val TAG_MAIN : String = "Main activity"
const val EXTRA_MESSAGE = "userName"


class MainActivity : AppCompatActivity() {

    private lateinit var topAppBar : MaterialToolbar
    private lateinit var drawerLayout : DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var appBarConfiguration: AppBarConfiguration

    private lateinit var toggle: ActionBarDrawerToggle

    //private val getPerson

    override fun onStart() {
        super.onStart()
        Log.i(TAG_MAIN, "onStart() Called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG_MAIN, "onRestart() Called")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG_MAIN, "onResume() Called")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG_MAIN, "onPause() Called")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG_MAIN, "onStop() Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG_MAIN, "onDestroy Called")
    }

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
                R.id.item3 -> {
                    // Handle menu item selected
                    menuItem.isChecked = true
                    drawerLayout.close()

                    navController.navigate(R.id.profileFragment)

                    true
                }
                R.id.item4 -> {
                    // Handle menu item selected
                    menuItem.isChecked = true
                    drawerLayout.close()

                    navController.navigate(R.id.listOfQuestionsFragment)

                    true
                }
                R.id.item5 -> {
                    // Handle menu item selected
                    menuItem.isChecked = true
                    drawerLayout.close()

                    navController.navigate(R.id.newQuestionFragment)

                    true
                }
                else -> false
            }
        }
    }
}