package com.example.countdown

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.*
import kotlin.concurrent.thread
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    val timerTextView: TextView by lazy{
        findViewById(R.id.timerTextView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Job() + Dispatchers.Default).launch {
            repeat(100){
                (100 - it).toString().run{
                    Log.d("CountDown", this)
                    timerTextView.text = this@run
                }

                delay(1000)
            }
        }

    }
}