package com.example.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

const val TAG_MAIN : String = "Main activity"
const val EXTRA_MESSAGE = "userName"

class MainActivity : AppCompatActivity() {

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
    }
}