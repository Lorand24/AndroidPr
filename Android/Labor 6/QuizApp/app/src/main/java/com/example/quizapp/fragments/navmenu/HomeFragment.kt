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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var testYourSkillsButton: Button
    private lateinit var readQuestionsButton: Button
    private lateinit var createQuestionButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
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

        readQuestionsButton.setOnClickListener {
            findNavController().navigate(R.id.listOfQuestionsFragment)
        }

        createQuestionButton.setOnClickListener {
            findNavController().navigate(R.id.newQuestionFragment)
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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}