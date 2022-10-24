package com.example.quizapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

const val TAG_MAIN: String = "MainActivity"
const val EXTRA_MESSAGE: String = "userName"

class MainActivity : AppCompatActivity() {

    private lateinit  var userName: EditText
    private lateinit var startButton: Button
    private lateinit var chooseContactButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeView()
        registerListeners()
    }

    private fun registerListeners() {
        chooseContactButton.setOnClickListener{
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE
            startActivityForResult(intent,111)
        }

        startButton.setOnClickListener{
            Toast.makeText(applicationContext,"Start button pressed !",Toast.LENGTH_LONG).show()
            Log.i(TAG_MAIN,userName.text.toString())
            val intent = Intent(this,SecondActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE,userName.text.toString())
            }
            startActivity(intent)
        }
    }

    private fun initializeView(){
        userName = findViewById(R.id.editTextTextPersonName)
        startButton = findViewById(R.id.buttonQuizStartGetStarted)
        chooseContactButton = findViewById(R.id.buttonQuizStartChooseContact)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 111 && resultCode == Activity.RESULT_OK){
            var contact = data?.data ?: return
            var cols = arrayOf(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
            var rs = contentResolver.query(contact,cols,null,null,null)
            if (rs?.moveToFirst()!!){
                userName.setText(rs.getString(0))
            }
        }
    }

}