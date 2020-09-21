package com.cagudeloa.harrypotter.ui.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.cagudeloa.harrypotter.R
import kotlinx.android.synthetic.main.fragment_game_won.*

class GameWonFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_won, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        playAgainButton.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_gameWonFragment_to_quizFragment)
        }
        leaveGameButton.setOnClickListener {view ->
            view.findNavController().navigate(R.id.action_gameWonFragment_to_categoriesFragment)
        }
    }
}