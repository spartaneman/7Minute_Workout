package com.example.a7minute_workout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a7minute_workout.databinding.ActivityExerciseBinding

class ExerciseActivity : AppCompatActivity() {

    private var exBinding: ActivityExerciseBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //view Binding
        exBinding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(exBinding?.root)

        //must set up support for tool bar
        setSupportActionBar(exBinding?.toolBarExercise)
    }
}