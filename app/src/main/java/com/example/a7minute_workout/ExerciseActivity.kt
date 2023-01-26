package com.example.a7minute_workout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import com.example.a7minute_workout.databinding.ActivityExerciseBinding

class ExerciseActivity : AppCompatActivity() {

    private var exBinding: ActivityExerciseBinding? = null
    private var restTimer: CountDownTimer? = null
    private var workoutTimer: CountDownTimer? = null

    private var restProgress = 0
    private var workoutProgress = 0
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
        exBinding?.flTimer2?.visibility = View.GONE
        exBinding?.flTimer?.visibility = View.VISIBLE
        if(restTimer != null)
        {
            restTimer?.cancel()
            restProgress = 0
        }
        setRestProgressBar()
    }

    private fun setupWorkoutView(){
        exBinding?.flTimer?.visibility = View.GONE
        exBinding?.tvTitle?.text = "Workout"
        exBinding?.flTimer2?.visibility = View.VISIBLE
        if(workoutTimer != null) {
            workoutTimer?.cancel()
            workoutProgress = 0
        }
        setWorkoutProgressBar()
    }

    //This is a timer for rest period
    private fun setRestProgressBar(){
        exBinding?.progressTimer?.progress = restProgress

        //restTimer is a countdown timer object that will use the ontick
        restTimer = object : CountDownTimer(10000, 1000){
            override fun onTick(millisUntilFinished: Long) {
                restProgress++
                exBinding?.progressTimer?.progress = 10 - restProgress
                exBinding?.tvTimer?.text = ("${10-restProgress}")
            }

            //This automatically runs once the timer has hit zero
            override fun onFinish() {
                Toast.makeText(this@ExerciseActivity, "Rest Finished", Toast.LENGTH_LONG).show()
                setupWorkoutView()

            }

        }.start()
    }

    private fun setWorkoutProgressBar(){
        exBinding?.progressTimer2?.progress = workoutProgress

        workoutTimer = object : CountDownTimer(20000, 1000)
        {
            override fun onTick(millisUntilFinished: Long) {
                workoutProgress++
                exBinding?.progressTimer2?.progress = 20 - workoutProgress
                exBinding?.tvTimer2?.text = "${20-workoutProgress}"
            }

            override fun onFinish() {
                Toast.makeText(this@ExerciseActivity, "Rest Time", Toast.LENGTH_LONG).show()
                setUpRestView()
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
        if(workoutTimer != null)
        {
            workoutTimer?.cancel()
            workoutProgress = 0
        }
        //Dont forget that you must destroy the binding at the end
        exBinding = null
    }
}