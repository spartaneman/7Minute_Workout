package com.example.a7minute_workout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import com.example.a7minute_workout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //Creating a viewBinding variable
    //Activity binding is automatically created for any activity created for the program
    private var binding:ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //This is how we bind the activity
        //We must inflate it with layoutInflater
        //root is the xml activity
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        //Can directly call item from xml
        //Don't have to set the object globally can be called using the binding outside of create
        binding?.flStart?.setOnClickListener{
            val intent = Intent(this, ExerciseActivity::class.java)
            startActivity(intent)
        }

    }

    //make sure to unassing the binding, to avoid memory leak
    override fun onDestroy() {
        super.onDestroy()

        binding = null
    }
}