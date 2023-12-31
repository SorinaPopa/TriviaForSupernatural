package com.example.supernaturaltrivia.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.supernaturaltrivia.R
import com.example.supernaturaltrivia.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.homeViewModel = homeViewModel

        easyModeObserver()
        mediumModeObserver()
        hardModeObserver()

        return binding.root

    }

    private fun easyModeObserver() {
        homeViewModel.onEasyButtonClicked.observe(viewLifecycleOwner) { isClicked ->
            if (isClicked) {
                findNavController().navigate(R.id.action_homeFragment_to_triviaFragment)

                if (homeViewModel.onEasyButtonClicked.value == true) {
                    Toast.makeText(requireContext(), "From Easy", Toast.LENGTH_LONG).show()
                }
                homeViewModel.onEasyButtonClicked.value = false
            }

        }
    }

    private fun mediumModeObserver() {
        homeViewModel.onMediumButtonClicked.observe(viewLifecycleOwner) { isClicked ->
            if (isClicked) {
                findNavController().navigate(R.id.action_homeFragment_to_triviaFragment)
                homeViewModel.onMediumButtonClicked.value = false
            }
            if (homeViewModel.onMediumButtonClicked.value == true) {
                Toast.makeText(requireContext(), "From Medium", Toast.LENGTH_LONG).show()
            }
            homeViewModel.onMediumButtonClicked.value = false

        }
    }

    private fun hardModeObserver() {
        homeViewModel.onHardButtonClicked.observe(viewLifecycleOwner) { isClicked ->
            if (isClicked) {
                findNavController().navigate(R.id.action_homeFragment_to_triviaFragment)
                homeViewModel.onHardButtonClicked.value = false
            }
            if (homeViewModel.onHardButtonClicked.value == true) {
                Toast.makeText(requireContext(), "From Hard", Toast.LENGTH_LONG).show()
            }
            homeViewModel.onHardButtonClicked.value = false
        }
    }
}
