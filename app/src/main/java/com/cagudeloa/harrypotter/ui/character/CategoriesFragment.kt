package com.cagudeloa.harrypotter.ui.character

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.cagudeloa.harrypotter.R
import kotlinx.android.synthetic.main.fragment_categories.*

class CategoriesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * Handle clicks on each text view and navigate to the next screen
         */
        setListeners()
    }

    private fun setListeners() {
        val clickableViews: List<View> = listOf(
            studentsText, staffText, housesText, quizText
        )
        for (item in clickableViews){
            item.setOnClickListener {
                makeColored(it)
            }
        }
    }

    private fun makeColored(option: View) {
        when(option.id){
            R.id.studentsText -> {
                val bundle = Bundle()
                bundle.putString("category", "student")
                findNavController().navigate(R.id.action_categoriesFragment_to_chosenCategoryFragment, bundle)
            }
            R.id.staffText -> {
                val bundle = Bundle()
                bundle.putString("category", "staff")
                findNavController().navigate(R.id.action_categoriesFragment_to_chosenCategoryFragment, bundle)
            }
            R.id.housesText -> {
                findNavController().navigate(R.id.action_categoriesFragment_to_houseFragment)
            }
            R.id.quizText -> {
                findNavController().navigate(R.id.action_categoriesFragment_to_quizFragment)
            }
        }
    }
}