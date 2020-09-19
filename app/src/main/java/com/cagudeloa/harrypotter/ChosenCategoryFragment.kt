package com.cagudeloa.harrypotter

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ChosenCategoryFragment : Fragment() {

    private lateinit var category: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * Get arguments coming from CategoriesFragment
         */
        requireArguments().let {
            category = it.getString("category")!!
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        Log.d("Chosen", category)
        return inflater.inflate(R.layout.fragment_chosen_category, container, false)
    }
}