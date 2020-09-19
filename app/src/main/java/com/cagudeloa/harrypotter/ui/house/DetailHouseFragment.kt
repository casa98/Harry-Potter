package com.cagudeloa.harrypotter.ui.house

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cagudeloa.harrypotter.R

class DetailHouseFragment : Fragment() {

    private lateinit var house: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let {
            house = it.getString("house")!!
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        Log.d("T", house)
        return inflater.inflate(R.layout.fragment_detail_house, container, false)
    }
}