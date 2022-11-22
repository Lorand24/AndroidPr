package com.example.quizapp.fragments.navmenu

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.quizapp.R
import com.example.quizapp.models.Answer
import com.example.quizapp.models.Question
import com.example.quizapp.shared.QuizControllerViewModel
import java.lang.StringBuilder

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NewQuestionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewQuestionFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var questionEditText: EditText
    private lateinit var correctAnswerEditText: EditText
    private lateinit var answer1EditText: EditText
    private lateinit var answer2EditText: EditText
    private lateinit var answer3EditText: EditText
    private lateinit var addQuestionButton: Button

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
        val view = inflater.inflate(R.layout.fragment_new_question, container, false)

        view?.apply {
            initializeViewElements(this)
            registerListeners(this)
        }

        return view
    }

    private fun registerListeners(view: View) {
        addQuestionButton.setOnClickListener {
            var answersTemp = arrayListOf<Answer>()
            answersTemp.add(Answer(correctAnswerEditText.text.toString(), true))
            answersTemp.add(Answer(answer1EditText.text.toString()))
            answersTemp.add(Answer(answer2EditText.text.toString()))
            answersTemp.add(Answer(answer3EditText.text.toString()))

            model.addQuestion(Question(questionEditText.text.toString(), answersTemp))

            findNavController().navigate(R.id.newQuestionFragment)
        }
    }

    private fun initializeViewElements(view: View) {

        model.setUp(requireContext(), 4)

        questionEditText = view.findViewById(R.id.newQuestionQuestionEditText)
        correctAnswerEditText = view.findViewById(R.id.newQuestionCorrectAnswerEditText)
        answer1EditText = view.findViewById(R.id.newQuestionIncorrectAnswerEditText1)
        answer2EditText = view.findViewById(R.id.newQuestionIncorrectAnswerEditText2)
        answer3EditText = view.findViewById(R.id.newQuestionIncorrectAnswerEditText3)

        addQuestionButton = view.findViewById(R.id.newQuestionAddQuestionButton)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NewQuestionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NewQuestionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}