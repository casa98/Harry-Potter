package com.cagudeloa.harrypotter.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cagudeloa.harrypotter.R
import com.cagudeloa.harrypotter.data.model.Student

class DetailsFragment : Fragment() {

    private lateinit var person: Student

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let {
            person = it.getParcelable<Student>("student")!!
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        Log.d("TAG", person.toString())
        return inflater.inflate(R.layout.fragment_details, container, false)
    }
}