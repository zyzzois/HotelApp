package com.example.reservation.presentation

import android.animation.LayoutTransition
import android.net.Uri
import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.core_ui.navigation.Routes
import com.example.reservation.R
import com.example.reservation.databinding.FragmentReservationBinding
import com.example.reservation.di.DaggerReservationComponent
import com.example.reservation.di.ReservationDependenciesProvider
import com.example.reservation.util.NumberMaskValidator

class ReservationFragment : Fragment() {

    private var _binding: FragmentReservationBinding? = null
    private val binding: FragmentReservationBinding
        get() = _binding ?: throw RuntimeException("error")

    private val component = DaggerReservationComponent
        .builder()
        .dependencies(ReservationDependenciesProvider.dependencies)
        .build()

    private val viewModel by lazy {
        component.getReservationViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReservationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupInitialData()
        setupTextInputLayout()
        observeViewModel()
        setupClickListener()
    }

    private fun setupTextInputLayout() {
        val editText = binding.editNumber
        editText.addTextChangedListener(NumberMaskValidator())

        binding.editNumber.doOnTextChanged { _, _, _, _ ->
            viewModel.resetErrorInputNumber()
        }

        binding.editMail.doOnTextChanged { _, _, _, _ ->
            viewModel.resetErrorInputMail()
        }
    }

    private fun setupInitialData() {
        viewModel.touristsCounter++
        binding.touristList.addView(createInflatedTouristView())
    }

    private fun setupClickListener() = with(binding) {
        buttonBack.setOnClickListener {
            findNavController().popBackStack()
        }
        buttonNavigateToPayment.setOnClickListener {
            if (viewModel.inputContactsIsValid(editMail.toString(), editNumber.toString())) {
                val uri = Uri.parse(Routes.PAYMENT_SCREEN)
                val navOptions = NavOptions.Builder()
                    .setEnterAnim(com.example.core_ui.R.anim.slide_in_right)
                    .setExitAnim(com.example.core_ui.R.anim.slide_out_left)
                    .setPopEnterAnim(com.example.core_ui.R.anim.slide_in_left)
                    .setPopExitAnim(com.example.core_ui.R.anim.slide_out_right)
                    .build()
                findNavController().navigate(uri, navOptions, null)
            }
        }
        buttonAddTourist.setOnClickListener {
            addTouristView()
        }
    }

    private fun observeViewModel() = with(binding) {
        viewModel.currentWeather.observe(viewLifecycleOwner) {
            tvRating.text = getString(com.example.core_ui.R.string.rating_text, it.hotelRating, it.roomDescription)
            tvHotelName.text = it.hotelName
            tvHotelLocation.text = it.hotelAddress
            tvDeparture.text = it.departure
            tvArrival.text = it.arrivalCountry
            tvTripDate.text = getString(R.string.trip_date_sample, it.tourDateStart, it.tourDateStop)
            tvNightsNumber.text = getString(R.string.nights_number_sample, it.numberOfNights)
            tvHotelNameSecond.text = it.hotelName
            tvHotelDescription.text = it.roomDescription
            tvNutrition.text = it.nutrition
            tvTripPrice.text = getString(R.string.price_sample, it.tourPrice)
            tvFuelCharge.text = getString(R.string.price_sample, it.fuelCharge)
            tvServiceFee.text = getString(R.string.price_sample, it.serviceCharge)
            val sum = it.tourPrice + it.fuelCharge + it.serviceCharge
            tvSummaryPrice.text = getString(R.string.price_sample, sum)
            binding.buttonNavigateToPayment.text = getString(R.string.pay, sum)
        }

        viewModel.errorInputNumber.observe(viewLifecycleOwner) { invalidNumber ->
            val message = if (invalidNumber)
                requireContext().getString(R.string.error_number)
            else null
            binding.tilNumber.error = message
        }

        viewModel.errorInputMail.observe(viewLifecycleOwner) { invalidMail ->
            val message = if (invalidMail)
                requireContext().getString(R.string.error_mail)
            else null
            binding.tilMail.error = message
        }

        viewModel.errorInputDetails.observe(viewLifecycleOwner) { invalidDetails ->
            val message = if (invalidDetails)
                requireContext().getString(R.string.error_not_all_data)
            else null
            binding.tilMail.error = message
        }

    }

    private fun addTouristView() {
        viewModel.touristsCounter++
        binding.touristList.addView(createInflatedTouristView())
    }

    private fun createInflatedTouristView(): View {
        val inflater = LayoutInflater.from(requireContext())
        val inflatedView = inflater.inflate(R.layout.tourist_list_item, null)

        val textView = inflatedView.findViewById<TextView>(R.id.tvTouristNumber)
        val buttonExpand = inflatedView.findViewById<ImageButton>(R.id.buttonExpand)
        val touristList = inflatedView.findViewById<LinearLayout>(R.id.expandableList)
        buttonExpand.setOnClickListener {
            touristList.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
            val visibility = if (touristList.visibility == View.GONE) View.VISIBLE else View.GONE
            TransitionManager.beginDelayedTransition(touristList, AutoTransition())
            touristList.visibility = visibility
        }

        when ( viewModel.touristsCounter) {
            1 -> textView.text = tourists[0]
            2 -> textView.text = tourists[1]
            3 -> textView.text = tourists[2]
            4 -> textView.text = tourists[3]
            5 -> textView.text = tourists[4]
        }

        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        inflatedView.layoutParams = layoutParams
        return inflatedView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.touristsCounter = 1
    }

    companion object {
        private val tourists = listOf(
            "Первый турист",
            "Второй турист",
            "Третий турист",
            "Четвертый турист",
            "Пятый турист"
        )
    }

}