package com.cagudeloa.harrypotter.ui.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cagudeloa.harrypotter.R
import com.cagudeloa.harrypotter.data.model.Student
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : Fragment() {

    private lateinit var person: Student

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Hide AppBar()
        //(activity as AppCompatActivity).supportActionBar?.hide()
        requireArguments().let {
            person = it.getParcelable("student")!!
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * Set values that came from recent fragment, into this one
         * Some values are unknown, I want it to display {Unknown} instead of nothing
         */
        val unknown = "Unknown"
        characterNameValue.text = person.name
        houseValue.text = person.house
        specieValue.text = if (person.species.isEmpty()) person.species else unknown
        ancestryValue.text = if (person.ancestry.isNotEmpty()) person.ancestry else unknown
        patronusValue.text = if (person.patronus.isNotEmpty()) person.patronus else unknown
        dateOfBirthValue.text = if (person.dateOfBirth.isNotEmpty()) person.dateOfBirth else unknown
        eyesColourValue.text = if (person.eyeColour.isNotEmpty()) person.eyeColour else unknown
        actorNameValue.text = if (person.actor.isNotEmpty()) person.actor else unknown
    }
}