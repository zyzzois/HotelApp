package com.example.apartments.presentation

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.apartments.databinding.FragmentApartmentsBinding
import com.example.apartments.di.ApartmentsDependenciesProvider
import com.example.apartments.di.DaggerApartmentsComponent
import com.example.apartments.presentation.model.EntityUiMapper
import com.example.apartments.presentation.recycler.ApartmentsListAdapter
import com.example.core_ui.R
import com.example.core_ui.navigation.Routes

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
        setupClickListener()
    }

    private fun setupClickListener() {

        listAdapter.onItemClickListener = {
            val uri = Uri.parse(Routes.RESERVATION_SCREEN)
            val navOptions = NavOptions.Builder()
                .setEnterAnim(R.anim.slide_in_right)
                .setExitAnim(R.anim.slide_out_left)
                .setPopEnterAnim(R.anim.slide_in_left)
                .setPopExitAnim(R.anim.slide_out_right)
                .build()
            findNavController().navigate(uri, navOptions, null)
        }

        binding.buttonBack.setOnClickListener {
            findNavController().popBackStack()
        }

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