package com.example.apartments.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.apartments.R
import com.example.apartments.databinding.FragmentApartmentsBinding

class ApartmentsFragment : Fragment() {

    private var _binding: FragmentApartmentsBinding? = null
    private val binding: FragmentApartmentsBinding
        get() = _binding ?: throw RuntimeException("error")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentApartmentsBinding.inflate(inflater, container, false)
        return binding.root
    }

}