package com.example.a7minute_workout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import com.example.a7minute_workout.databinding.ActivityExerciseBinding

class ExerciseActivity : AppCompatActivity() {

    private var exBinding: ActivityExerciseBinding? = null
    private var restTimer: CountDownTimer? = null
    private var restProgress = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //view Binding
        exBinding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(exBinding?.root)

        //must set up support for tool bar
        setSupportActionBar(exBinding?.toolBarExercise)

        //To use the back button must check that there is a support action Bar
        if(supportActionBar != null)
        {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        //Still works though it says its deprecated
        exBinding?.toolBarExercise?.setNavigationOnClickListener {
            onBackPressed()
        }
        setUpRestView()

    }

    //this way it will make sure the progress bar resets after going to another page
    private fun setUpRestView(){
        if(restTimer != null)
        {
            restTimer?.cancel()
            restProgress = 0
        }
        setRestProgressBar()
    }

    //This is a timer for rest period
    private fun setRestProgressBar(){
        exBinding?.progressTimer?.progress = restProgress

        //restTimer is a countdown timer object that will use the ontick
        restTimer = object : CountDownTimer(30000, 1000){
            override fun onTick(millisUntilFinished: Long) {
                restProgress++
                exBinding?.progressTimer?.progress = 30 - restProgress
                exBinding?.tvTimer?.text = ("${30-restProgress}")
            }

            //This automatically runs once the timer has hit zero
            override fun onFinish() {
                Toast.makeText(this@ExerciseActivity, "Timer Finished", Toast.LENGTH_LONG).show()
            }

        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        if(restTimer != null)
        {
            restTimer?.cancel()
            restProgress = 0
        }

        //Dont forget that you must destroy the binding at the end
        exBinding = null
    }
}