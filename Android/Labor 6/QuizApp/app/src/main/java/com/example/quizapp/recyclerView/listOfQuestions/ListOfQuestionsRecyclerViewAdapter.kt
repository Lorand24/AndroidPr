package com.example.quizapp.recyclerView.listOfQuestions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.R

class ListOfQuestionsRecyclerViewAdapter(val dataList : List<RecycleViewItemData>) :RecyclerView.Adapter<ListOfQuestionsRecyclerViewAdapter.LOQViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LOQViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return LOQViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LOQViewHolder, position: Int) {
        val currentItem = dataList[position]

        holder.questionView.setText(currentItem.question)
        holder.correctAnswerView.setText(currentItem.correctAnswer)

        holder.deleteButton.setText("Delete")
        holder.detailsButton.setText("Details")
    }

    override fun getItemCount() = dataList.size

    class LOQViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //recyclerViewQuestionTextView
        val questionView: TextView = itemView.findViewById(R.id.recyclerViewQuestionTextView)
        val correctAnswerView : TextView = itemView.findViewById(R.id.recyclerViewCorrectAnswer)
        val detailsButton : Button = itemView.findViewById(R.id.recyclerViewDetailsButton)
        val deleteButton : Button = itemView.findViewById(R.id.recyclerViewDeleteButton)
    }
}