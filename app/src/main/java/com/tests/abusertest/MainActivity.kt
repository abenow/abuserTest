package com.tests.abusertest

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var r = 0
    private var i = 0
    private val arrayCount = IntArray(10)
    private val myArray = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(3, 2, 1),
        intArrayOf(2, 3, 1),
        intArrayOf(1, 3, 2),
        intArrayOf(1, 2, 3),
        intArrayOf(1, 2, 3),
        intArrayOf(1, 2, 3),
        intArrayOf(1, 2, 3),
        intArrayOf(2, 1, 3),
        intArrayOf(1, 2, 3)
    )

    private lateinit var textView1: TextView
    private lateinit var textView2: TextView
    private lateinit var radioGroup: RadioGroup
    private lateinit var radioButton1: RadioButton
    private lateinit var radioButton2: RadioButton
    private lateinit var radioButton3: RadioButton

    private val question: List<String> by lazy {
        listOf(
            getString(R.string.question1),
            getString(R.string.question2),
            getString(R.string.question3),
            getString(R.string.question4),
            getString(R.string.question5),
            getString(R.string.question6),
            getString(R.string.question7),
            getString(R.string.question8),
            getString(R.string.question9),
            getString(R.string.question10)
        )
    }

    private val answer: Array<Array<String>> by lazy {
        arrayOf(
            arrayOf(
                getString(R.string.answer1One),
                getString(R.string.answer1Two),
                getString(R.string.answer1Three)
            ),
            arrayOf(
                getString(R.string.answer2One),
                getString(R.string.answer2Two),
                getString(R.string.answer2Three)
            ),
            arrayOf(
                getString(R.string.answer3One),
                getString(R.string.answer3Two),
                getString(R.string.answer3Three)
            ),
            arrayOf(
                getString(R.string.answer4One),
                getString(R.string.answer4Two),
                getString(R.string.answer4Three)
            ),
            arrayOf(
                getString(R.string.answer5One),
                getString(R.string.answer5Two),
                getString(R.string.answer5Three)
            ),
            arrayOf(
                getString(R.string.answer6One),
                getString(R.string.answer6Two),
                getString(R.string.answer6Three)
            ),
            arrayOf(
                getString(R.string.answer7One),
                getString(R.string.answer7Two),
                getString(R.string.answer7Three)
            ),
            arrayOf(
                getString(R.string.answer8One),
                getString(R.string.answer8Two),
                getString(R.string.answer8Three)
            ),
            arrayOf(
                getString(R.string.answer9One),
                getString(R.string.answer9Two),
                getString(R.string.answer9Three)
            ),
            arrayOf(
                getString(R.string.answer10One),
                getString(R.string.answer10Two),
                getString(R.string.answer10Three)
            )
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView1 = findViewById(R.id.textView1)
        textView2 = findViewById(R.id.textView2)
        radioGroup = findViewById(R.id.radio_group)
        radioButton1 = findViewById(R.id.a)
        radioButton2 = findViewById(R.id.b)
        radioButton3 = findViewById(R.id.c)

        textView1.text = "Вопрос: ${i + 1} из ${question.size}"
        textView2.text = question[i]
        radioButton1.text = answer[i][0]
        radioButton2.text = answer[i][1]
        radioButton3.text = answer[i][2]
        radioGroup.clearCheck()
    }

    fun answerOnQuestion(view: View) {
        val radioBooleanA: Boolean = radioButton1.isChecked
        val radioBooleanB: Boolean = radioButton2.isChecked
        val radioBooleanC: Boolean = radioButton3.isChecked

        if (radioBooleanA) {
            arrayCount[i] = myArray[i][0]
            ++i
        } else if (radioBooleanB) {
            arrayCount[i] = myArray[i][1]
            ++i
        } else if (radioBooleanC) {
            arrayCount[i] = myArray[i][2]
            ++i
        } else {
            Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show()
        }
        r += arrayCount[i - 1]
        if (i < 10) {
            makeCount()
        } else {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            intent.putExtra("ageSendOne", r)
            startActivity(intent)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun makeCount() {
        radioGroup.clearCheck()
        textView1.text = "Вопрос: ${i + 1} из ${question.size}"
        textView2.text = question[i]
        radioButton1.text = answer[i][0]
        radioButton2.text = answer[i][1]
        radioButton3.text = answer[i][2]
    }


}