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

        //To use the back button must check that there is a support action Bar
        if(supportActionBar != null)
        {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        //Still works though it says its deprecated
        exBinding?.toolBarExercise?.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}