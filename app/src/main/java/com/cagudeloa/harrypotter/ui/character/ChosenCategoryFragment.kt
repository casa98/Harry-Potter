package com.cagudeloa.harrypotter.ui.character

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.cagudeloa.harrypotter.R
import com.cagudeloa.harrypotter.data.DataSource
import com.cagudeloa.harrypotter.data.model.Student
import com.cagudeloa.harrypotter.domain.RepositoryImplementation
import com.cagudeloa.harrypotter.ui.viewmodel.ChosenCategoryViewModel
import com.cagudeloa.harrypotter.ui.viewmodel.ViewModelFactory
import com.cagudeloa.harrypotter.vo.Resource
import kotlinx.android.synthetic.main.fragment_chosen_category.*

class ChosenCategoryFragment : Fragment(), ChosenCategoryAdapter.OnItemClickListener {

    private lateinit var category: String
    private val viewModel by viewModels<ChosenCategoryViewModel> { ViewModelFactory(RepositoryImplementation(DataSource())) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * Get arguments coming from CategoriesFragment
         */
        requireArguments().let {
            category = it.getString("category")!!
        }
        // Send this info to the ViewModel so that it knows which label I selected, then fetch this info and display it
        viewModel.setOption(category)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chosen_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        viewModel.fetchStudentsList.observe(viewLifecycleOwner, {studentsList->
            when(studentsList){
                is Resource.Loading -> {
                    progressBarLayout.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    progressBarLayout.visibility = View.GONE
                    myRecyclerView.adapter = ChosenCategoryAdapter(requireContext(), this, studentsList.data,)
                }
                is Resource.Failure -> {
                    progressBarLayout.visibility = View.GONE
                    Toast.makeText(requireContext(), "An error occurred fetching data :c", Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun setupRecyclerView(){
        myRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        myRecyclerView.addItemDecoration(DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL))
    }

    override fun onItemClick(student: Student) {
        // This is triggered when an item is clicked
        val bundle = Bundle()
        bundle.putParcelable("student", student)
        findNavController().navigate(R.id.action_chosenCategoryFragment_to_detailsFragment, bundle)
    }

}