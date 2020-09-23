package com.cagudeloa.harrypotter.ui.house

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.cagudeloa.harrypotter.R
import com.cagudeloa.harrypotter.data.DataSource
import com.cagudeloa.harrypotter.data.model.House
import com.cagudeloa.harrypotter.domain.RepositoryImplementation
import com.cagudeloa.harrypotter.ui.viewmodel.DetailHouseViewModel
import com.cagudeloa.harrypotter.ui.viewmodel.ViewModelFactory
import com.cagudeloa.harrypotter.vo.Resource
import kotlinx.android.synthetic.main.fragment_detail_house.*

class DetailHouseFragment : Fragment() {

    private lateinit var currentHouse: String
    private val viewModel by viewModels<DetailHouseViewModel>{ViewModelFactory(RepositoryImplementation(DataSource()))}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let {
            currentHouse = it.getString("house")!!
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_house, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.fetchHouseList.observe(viewLifecycleOwner, {housesList ->
            when(housesList){
                is Resource.Loading -> {
                    // Show a progress bar, e.g
                }
                is Resource.Success -> {
                    val housesData = housesList.data
                    when(currentHouse){
                        "Gryffindor" -> {
                            val house = housesData[0]
                            setData(house)
                        }
                        "Slytherin" -> {
                            val house = housesData[1]
                            setData(house)
                        }
                        "Hufflepuff" -> {
                            val house = housesData[2]
                            setData(house)
                        }
                        "Ravenclaw" -> {
                            val house = housesData[3]
                            setData(house)
                        }
                    }
                }
                is Resource.Failure -> {
                    Toast.makeText(requireContext(), "An error occurred fetching data :c", Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun setData(house: House) {
        houseTitleText.text = house.name
        houseColorText.text = "${house.colors[0]}, ${house.colors[1]}"
        houseValuesText.text = "${house.values[0]}, ${house.values[1]}, ${house.values[2]}, ${house.values[3]}"
        houseAnimalText.text = house.animal
        houseElementText.text = house.element
        houseGhostText.text = house.ghost
        houseFounderText.text = house.founder
        houseRoomText.text = house.common_room
    }
}