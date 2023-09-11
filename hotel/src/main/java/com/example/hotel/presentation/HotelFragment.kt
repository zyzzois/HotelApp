package com.example.hotel.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hotel.databinding.FragmentHotelBinding

class HotelFragment : Fragment() {

    private var _binding: FragmentHotelBinding? = null
    private val binding: FragmentHotelBinding
        get() = _binding ?: throw RuntimeException("error")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHotelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonNavigateToApartments.setOnClickListener {

        }

    }


}