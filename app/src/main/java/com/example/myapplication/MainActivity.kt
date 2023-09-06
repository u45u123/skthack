package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale
import java.util.Timer
import kotlin.concurrent.timer


class MainActivity : AppCompatActivity() {

    lateinit var whereto: EditText
    /*
    private val RQ_SPEECH_REC = 102
    var tv_test : TextView = findViewById(R.id.tv_test)
    var button : Button = findViewById(R.id.button)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.practice)
        button.setOnClickListener{
            askSpeechInput()
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RQ_SPEECH_REC && resultCode == Activity.RESULT_OK) {
            val result = data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
            tv_test.text = result?.get(0).toString()
        }
    }

    private fun askSpeechInput() {
        if (!SpeechRecognizer.isRecognitionAvailable(this)) {
            Toast.makeText(this, "Speech recognition is not available", Toast.LENGTH_SHORT).show()
        } else {
            val i = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            i.putExtra(
                RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
            )
            i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
            i.putExtra(RecognizerIntent.EXTRA_PROMPT, "말하세요!")
            startActivityForResult(i, RQ_SPEECH_REC)
        }
    }
*/


    fun page1() {
        setContentView(R.layout.activity_main)

        val txt1: TextView = findViewById(R.id.textview1)
        val btn_start: Button = findViewById(R.id.btn_start)

        btn_start.setOnClickListener() {
            page3()
        }
    }


    fun page2() {
        setContentView(R.layout.activity_walk)

        var sec: Int = 60
        var isRunning = true
        var timerTask: Timer? = null


        val txt: TextView = findViewById(R.id.textview1)
        val timer: TextView = findViewById(R.id.timer)
        val btncdStart: Button = findViewById(R.id.btn_cdstart)

        btncdStart.setOnClickListener {
            if(isRunning) {
                timerTask = kotlin.concurrent.timer(period = 1000) {
                    sec--
                    runOnUiThread {
                        timer.text = sec.toString()
                    }
                    if (sec == 0) {
                        isRunning = false
                        timerTask?.cancel()
                        btncdStart.text = "다음"
                    }
                }
            }

            else{
                page3()
            }
            }


    }

    fun page3(){
        setContentView(R.layout.activity_finishwalk)

        val btn_again : Button = findViewById(R.id.btn_again)
        val btn_service : Button = findViewById(R.id.btn_service)

        btn_again.setOnClickListener(){
            page2()
        }

        btn_service.setOnClickListener(){
            page4()
        }
    }

    fun page4(){
       setContentView(R.layout.activity_whereto)

        whereto = findViewById(R.id.edittextwhere)
        println(whereto)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        page1()

    }
}

