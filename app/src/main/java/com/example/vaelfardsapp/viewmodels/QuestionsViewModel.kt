package com.example.vaelfardsapp.viewmodels

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vaelfardsapp.constants.Questions
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class QuestionsViewModel : ViewModel() {

    private val questions = Questions.getQuestions()
    private var currentIndex = 0

    val questionAnswer: MutableLiveData<Int> by lazy { MutableLiveData<Int>() }

    private var array2dFromSP = Array(24) { IntArray(2) }
    private lateinit var sharedPrefs: SharedPreferences

    init {
        questionAnswer.value = 3
    }

    val DEFAULT_SLIDER_VALUE: Int
        get() {
            return 3
        }

    val returnValFloat: Float?
        get() {
            return questionAnswer.value?.toFloat()
        }

    val currentQuestionText: String
        get() {
            return questions[currentIndex].styrkeTxt
        }

    val currentQuestionSubHeader: String
        get() {
            return questions[currentIndex].styrkeName
        }

    val currentQuestionVideo: Int
        get() {
            return questions[currentIndex].videoPath
        }

    val getFirstIndex: Int
        get() {
            return questions.size - questions.size
        }

    val getCurrentIndex: Int
        get() {
            return currentIndex
        }

    val getQuestionsMax: Int
        get() {
            return (questions.lastIndex)
        }

    fun resetSlider() {
        questionAnswer.value = DEFAULT_SLIDER_VALUE
    }

    fun nextQuestion() {
        if (currentIndex < questions.lastIndex) {
            currentIndex++
        }
    }

    fun prevQuestion() {
        if (currentIndex <= questions.lastIndex && (currentIndex != 0)) {
            currentIndex--
        }
    }

    fun saveAnswersToSP(context: Context, array2d: Array<IntArray> = Array(24) { IntArray(2) }) {
        // Init sharedPrefs
        sharedPrefs = context.getSharedPreferences("questionsAns", Context.MODE_PRIVATE)!!
        // Saving the 2d array to shared preferences
        sharedPrefs.edit().putString("array2d", Json.encodeToString(array2d)).apply()
    }

    fun getAnswersFromSP(context: Context): List<IntArray> {
        // Init sharedPrefs
        sharedPrefs = context.getSharedPreferences("questionsAns", Context.MODE_PRIVATE)!!
        // Getting the 2d array back from shared preferences
        array2dFromSP = Json.decodeFromString(sharedPrefs.getString("array2d", "No value found")!!)
        // Sorting the array by index 1: the answers
        array2dFromSP.sortWith(compareByDescending { it[1] })

        // Getting the 5 highest answers from the sorted array and returning those
        return array2dFromSP.take(5)
    }


    // FIXME TEMPORARY, DELETE BEFORE RELEASE
    fun skipQuestions() {
        currentIndex = 23
    }
}