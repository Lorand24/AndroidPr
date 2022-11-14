package com.example.quizapp.models

import android.content.Context
import com.example.quizapp.R
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

data class HighScore(var context: Context)
{
    var playerName: String
    var highScoreValue : Int = 0
    init {
        val isreader: InputStream = context.resources.openRawResource(R.raw.highscore)
        val reader = BufferedReader(InputStreamReader(isreader))
        val lines = reader.readLines()

        playerName = lines[0]
        highScoreValue = lines[1].toInt()
    }
}
