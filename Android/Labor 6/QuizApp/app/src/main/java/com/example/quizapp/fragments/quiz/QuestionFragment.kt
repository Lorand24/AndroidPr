package com.example.quizapp.fragments.quiz

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.core.view.forEach
import androidx.core.view.get
import androidx.core.view.size
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.quizapp.R
import com.example.quizapp.models.Question
import com.example.quizapp.shared.QuizControllerViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [QuestionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuestionFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var questionTextView: TextView
    lateinit var radioGroup: RadioGroup
    lateinit var button: Button
    lateinit var currentQuestion: Question

    val model: QuizControllerViewModel by activityViewModels()

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
        val view = inflater.inflate(R.layout.fragment_question, container, false)

        currentQuestion = model.getNextQuestion()

        view?.apply {
            initializeViewElements(this)
            registerListeners(this)
        }

        return view
    }

    private fun registerListeners(view: View) {

        button.setOnClickListener {

            var index = radioGroup.indexOfChild(
                view.findViewById<RadioButton>(radioGroup.checkedRadioButtonId)
            )

            if(index == -1) {
                //TODO: Display a toast or w/e
                return@setOnClickListener
            }

            model.onAnswerChecked(index)

            if (model.isLastQuestion()) {
                findNavController().navigate(R.id.action_questionFragment_to_endQuizFragment)
            }
            else {
                findNavController().navigate(R.id.action_questionFragment_self)
            }
        }
    }

    private fun initializeViewElements(view: View) {
        questionTextView = view.findViewById(R.id.questionTextView)
        radioGroup = view.findViewById(R.id.radioGroup)
        button = view.findViewById(R.id.submitButton)

        if (model.isLastQuestion()) {
            button.text = "SUBMIT"
        } else
        {
            button.text = "Next"
        }

        questionTextView.text = currentQuestion.text

        for (i in 0 until radioGroup.size) {
            val radioButton = view.findViewById<RadioButton>(radioGroup[i].id)
            radioButton.text = currentQuestion.answers[i].text
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback: OnBackPressedCallback = object : OnBackPressedCallback(
            true // default to enabled
        ) {
            override fun handleOnBackPressed() {
                val dialog = AlertDialog.Builder(context)
                dialog.setCancelable(true)

                dialog.setMessage("Are you sure you want to end the quiz?")
                dialog.setPositiveButton("Yes")
                {
                        dial, which ->
                    findNavController().navigate(R.id.action_questionFragment_to_endQuizFragment)
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
         * @return A new instance of fragment QuestionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            QuestionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}