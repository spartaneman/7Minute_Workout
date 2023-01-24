package com.example.a7minute_workout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
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

        val flStartButton: FrameLayout = findViewById(R.id.fl_start)
        flStartButton.setOnClickListener{

        }

    }
}