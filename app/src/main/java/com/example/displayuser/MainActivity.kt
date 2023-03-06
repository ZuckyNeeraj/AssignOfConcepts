package com.example.displayuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.data.FemaleData
import com.example.data.MaleData
import com.example.fragments.Female_fragment
import com.example.fragments.Male_fragment

class MainActivity : AppCompatActivity() {

    private var recyclerViewM: RecyclerView? = null
    private var recyclerViewF: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val maleFragment = Male_fragment()
        val femaleFragment = Female_fragment()

        val maleButton = findViewById<Button>(R.id.maleButton)
        val femaleButton = findViewById<Button>(R.id.femaleButton)

        supportFragmentManager.beginTransaction().add(R.id.frameLayout, maleFragment).addToBackStack(null).commit()

        maleButton.setOnClickListener{
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, maleFragment).addToBackStack(null).commit()
        }

        femaleButton.setOnClickListener{
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout, femaleFragment).addToBackStack(null).commit()
        }

    }

}