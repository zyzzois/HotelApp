package com.example.payment.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.payment.databinding.FragmentPaymentBinding

class PaymentFragment : Fragment() {

    private var _binding: FragmentPaymentBinding? = null
    private val binding: FragmentPaymentBinding
        get() = _binding ?: throw RuntimeException("error")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPaymentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListener()
    }

    private fun setupClickListener() {
        binding.buttonNavigateToHotel.setOnClickListener {
            val navController = findNavController()
            navController.popBackStack(navController.graph.startDestinationId, false)
        }
        binding.buttonBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}