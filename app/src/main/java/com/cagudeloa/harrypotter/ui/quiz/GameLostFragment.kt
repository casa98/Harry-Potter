package com.cagudeloa.harrypotter.ui.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.cagudeloa.harrypotter.R
import kotlinx.android.synthetic.main.fragment_game_lost.*

class GameLostFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_lost, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        playAgainButton.setOnClickListener {view ->
            view.findNavController().navigate(R.id.action_gameLostFragment_to_quizFragment)
        }
        leaveGameButton.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_gameLostFragment_to_categoriesFragment)
        }
    }
}