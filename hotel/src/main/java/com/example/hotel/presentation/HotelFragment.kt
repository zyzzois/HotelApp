package com.example.hotel.presentation

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.example.core_ui.R
import com.example.core_ui.navigation.Routes.APARTMENTS_SCREEN
import com.example.hotel.databinding.FragmentHotelBinding
import com.example.hotel.di.DaggerHotelComponent
import com.example.hotel.di.HotelDependenciesProvider
import com.example.hotel.presentation.model.ViewMapper

class HotelFragment : Fragment() {

    private var _binding: FragmentHotelBinding? = null
    private val binding: FragmentHotelBinding
        get() = _binding ?: throw RuntimeException("error")

    private val component
            = DaggerHotelComponent.builder().dependencies(HotelDependenciesProvider.dependencies).build()

    private val viewModel by lazy {
        component.getHotelViewModel()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHotelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupData()
        setupButtons()
    }

    private fun setupData() = with(binding) {
        viewModel.currentWeather.observe(viewLifecycleOwner) { it ->
            val hotel = ViewMapper(requireContext()).mapDomainEntityToPresentationEntity(it)
            imageSlider.setImageList(hotel.hotelImages, ScaleTypes.FIT)
            chip.text = hotel.hotelRating
            tvHotelName.text = hotel.hotelName
            tvHotelLocation.text = hotel.hotelLocation
            tvHotelPrice.text = hotel.price.price
            tvPriceDescription.text = hotel.price.description

            hotel.chips.forEach {
                scroller.addView(it)
            }
            tvHotelDescription.text = hotel.description
        }
    }

    private fun setupButtons() = with(binding) {
        buttonNavigateToApartments.setOnClickListener {
            val uri = Uri.parse(APARTMENTS_SCREEN)
            val navOptions = NavOptions.Builder()
                .setEnterAnim(R.anim.slide_in_right)
                .setExitAnim(R.anim.slide_out_left)
                .setPopEnterAnim(R.anim.slide_in_left)
                .setPopExitAnim(R.anim.slide_out_right)
                .build()
            findNavController().navigate(uri, navOptions, null)
        }
    }

}