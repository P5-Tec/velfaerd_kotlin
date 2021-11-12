package com.example.vaelfardsapp.viewmodels
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vaelfardsapp.constants.Questions
import com.example.vaelfardsapp.models.questionModel

class QuestionsViewModel(): ViewModel() {
    private val questions = Questions.getQuestions()
    private var currentIndex = 0

    val questionAnswer: MutableLiveData<Int> by lazy{ MutableLiveData<Int>() }

    init {
        questionAnswer.value = 3
    }

    val returnValFloat: Float?
        get(){return questionAnswer.value?.toFloat() }


    val currentQuestionText: String get() {
        return questions[currentIndex].questionMainText
    }

    val currentQuestionSubHeader: String get(){
        return questions[currentIndex].questionSubheader
    }

    val currentQuestionVideo: Int get(){
        return questions[currentIndex].questionVideo
    }

    val getFirstIndex: Int get(){
        return questions.size - questions.size
    }

    val getCurrentIndex: Int get(){
        return currentIndex
    }

    val getQuestionsMax: Int get(){
        return (questions.lastIndex)
    }

    fun resetSlider(){
        questionAnswer.value = 3
    }

    fun nextQuestion() {
        if (currentIndex < questions.lastIndex){currentIndex++}
    }

    fun prevQuestion(){
        if (currentIndex <= questions.lastIndex && (currentIndex != 0)){ currentIndex-- }
    }
}