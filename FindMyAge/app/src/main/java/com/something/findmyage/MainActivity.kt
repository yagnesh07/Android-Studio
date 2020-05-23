package com.something.findmyage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            buFindage.setOnClickListener(){

                val YearOfBirth:Int = txtYearofBirth1.text.toString().toInt()
                val CurrentYear= Calendar.getInstance().get(Calendar.YEAR)
                val MyAge= CurrentYear-YearOfBirth.toInt()
                tvShowAge.text= "Your Age is $MyAge Years"

            }
    }

}



