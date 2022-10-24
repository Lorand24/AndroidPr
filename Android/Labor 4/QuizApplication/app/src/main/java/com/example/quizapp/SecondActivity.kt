package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

private lateinit var textname: EditText

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val actionBar = supportActionBar
        actionBar!!.title = "Second Activity"
        actionBar.setDisplayHomeAsUpEnabled(true)
        var name = intent.getStringExtra(EXTRA_MESSAGE)
        initializeView()
        textname.setText(name)
    }

    private fun initializeView(){
        textname = findViewById(R.id.editTextTextPersonName2)
    }

}