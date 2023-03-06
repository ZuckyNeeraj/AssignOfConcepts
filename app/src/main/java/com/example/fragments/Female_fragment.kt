package com.example.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.data.FemaleData
import com.example.data.MaleData
import com.example.displayuser.DataAdapter
import com.example.displayuser.FemaleDataAdapter
import com.example.displayuser.R


class Female_fragment: Fragment(){


    private var recyclerViewF: RecyclerView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_female_fragment, container, false)
        recyclerViewF = view.findViewById(R.id.femaleRV)
        val dataAdapterF = FemaleDataAdapter()
        val femaleName = view.findViewById<EditText>(R.id.editTextFemaleName)
        val femaleRole = view.findViewById<EditText>(R.id.editTextFemaleRole)
        view.findViewById<Button>(R.id.buttonFemale).setOnClickListener{
            dataAdapterF.addData(FemaleData(femaleName.text.toString(), femaleRole.text.toString()))
        }
        recyclerViewF?.adapter = dataAdapterF
        return view
    }
}