package com.example.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.data.MaleData
import com.example.displayuser.DataAdapter
import com.example.displayuser.R
import kotlin.math.log

class Male_fragment: Fragment(){

    private var recyclerViewM: RecyclerView? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_male_fragment, container, false)
        recyclerViewM = view.findViewById(R.id.maleRV)
        val dataAdapterM = DataAdapter()
        val maleName = view.findViewById<EditText>(R.id.editTextMaleName)
        val maleRole = view.findViewById<EditText>(R.id.editTextMaleRole)
        view.findViewById<Button>(R.id.buttonMale).setOnClickListener{
            dataAdapterM.addData(MaleData(maleName.text.toString(), maleRole.text.toString()))
        }
        recyclerViewM?.adapter = dataAdapterM
        return view
    }
}