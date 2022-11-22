package com.example.quizapp.fragments.navmenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.R
import com.example.quizapp.recyclerView.listOfQuestions.ListOfQuestionsRecyclerViewAdapter
import com.example.quizapp.recyclerView.listOfQuestions.RecycleViewItemData
import com.example.quizapp.shared.QuizControllerViewModel

class ListOfQuestionsFragment : Fragment() {

    val dataList = generateDummyList()

    val model: QuizControllerViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_of_questions, container, false)

        view?.apply {
            initializeViewElements(this)
//            registerListeners(this)
        }

        return view
    }

    //fun removeItem

    private fun registerListeners(view: View) {

    }

    private fun initializeViewElements(view: View) {
        val recView: RecyclerView = view.findViewById(R.id.listOfQuestionsRecyclerView)

        recView.adapter = ListOfQuestionsRecyclerViewAdapter(dataList)
        recView.layoutManager = LinearLayoutManager(requireContext())
        recView.setHasFixedSize(true)
    }

    private fun generateDummyList(): ArrayList<RecycleViewItemData> {

        val list = ArrayList<RecycleViewItemData>()

        model.setUp(requireContext(), 4)
        val size = model.quizController.questions.size

        for (i in 0 until size) {
            val item = RecycleViewItemData(model.quizController.questions[i].text, model.quizController.questions[i].answers[0].text)
            list += item
        }

        return list
    }
}