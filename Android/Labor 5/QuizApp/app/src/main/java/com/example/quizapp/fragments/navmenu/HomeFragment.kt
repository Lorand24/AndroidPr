package com.example.quizapp.fragments.navmenu

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.example.quizapp.R
import kotlin.system.exitProcess


class HomeFragment : Fragment() {

    private lateinit var testYourSkillsButton: Button
    private lateinit var readQuestionsButton: Button
    private lateinit var createQuestionButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        view?.apply {
            initializeViewElements(this)
            registerListeners(this)
        }

        return view
    }

    private fun registerListeners(view: View) {
        testYourSkillsButton.setOnClickListener {
            findNavController().navigate(R.id.quizStartFragment)
        }
    }

    private fun initializeViewElements(view: View) {
        testYourSkillsButton = view.findViewById(R.id.homeTestYourSkillsButton)
        readQuestionsButton = view.findViewById(R.id.homeReadQuestionsButton)
        createQuestionButton = view.findViewById(R.id.homeCreateQuestionButton)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback: OnBackPressedCallback = object : OnBackPressedCallback(
            true // default to enabled
        ) {
            override fun handleOnBackPressed() {
                val dialog = AlertDialog.Builder(context)
                dialog.setCancelable(true)

                dialog.setMessage("Are you sure you want to exit?")
                dialog.setPositiveButton("Yes")
                {
                        dial, which -> exitProcess(0)
                }
                dialog.setNegativeButton("No")
                {
                        dial, which ->

                }
                dialog.show()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            this,  // LifecycleOwner
            callback
        )
    }
}