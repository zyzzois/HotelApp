package com.example.apartments.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.apartments.databinding.FragmentApartmentsBinding
import com.example.apartments.di.ApartmentsDependenciesProvider
import com.example.apartments.di.DaggerApartmentsComponent
import com.example.apartments.presentation.model.EntityUiMapper
import com.example.apartments.presentation.recycler.ApartmentsListAdapter

class ApartmentsFragment : Fragment() {

    private var _binding: FragmentApartmentsBinding? = null
    private val binding: FragmentApartmentsBinding
        get() = _binding ?: throw RuntimeException("error")

    private lateinit var listAdapter: ApartmentsListAdapter

    private val component = DaggerApartmentsComponent
        .builder()
        .dependencies(ApartmentsDependenciesProvider.dependencies)
        .build()

    private val viewModel by lazy {
        component.getApartmentsViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentApartmentsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        listAdapter = ApartmentsListAdapter()
        binding.recyclerView.adapter = listAdapter
    }

    private fun observeViewModel() {
        viewModel.apartments.observe(viewLifecycleOwner) { list ->
            val mapper = EntityUiMapper(requireContext())
            val uiList = mapper.mapEntityListToUiModelList(list)
            listAdapter.submitList(uiList)
        }
    }

}