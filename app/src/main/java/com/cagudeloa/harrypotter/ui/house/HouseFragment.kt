package com.cagudeloa.harrypotter.ui.house

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.cagudeloa.harrypotter.R
import kotlinx.android.synthetic.main.fragment_house.*

class HouseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_house, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners() {
        val clickableViews: List<View> = listOf(
            house1Card, house2Card, house3Card, house4Card
        )
        for (item in clickableViews){
            item.setOnClickListener {
                makeColored(it)
            }
        }
    }

    private fun makeColored(house: View) {
        val bundle = Bundle()
        when(house.id){
            R.id.house1Card -> {
                bundle.putString("house", "Ravenclaw")
                findNavController().navigate(R.id.action_houseFragment_to_detailHouseFragment, bundle)
            }
            R.id.house2Card -> {
                bundle.putString("house", "Hufflepuff")
                findNavController().navigate(R.id.action_houseFragment_to_detailHouseFragment, bundle)
            }
            R.id.house3Card -> {
                bundle.putString("house", "Slytherin")
                findNavController().navigate(R.id.action_houseFragment_to_detailHouseFragment, bundle)
            }
            R.id.house4Card -> {
                bundle.putString("house", "Gryffindor")
                findNavController().navigate(R.id.action_houseFragment_to_detailHouseFragment, bundle)
            }
        }
    }
}