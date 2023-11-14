package com.example.supernaturaltrivia.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        return binding.root

    }

    private fun easyModeObserver() {
        homeViewModel.onEasyButtonClicked.observe(viewLifecycleOwner) { isClicked ->
            if (isClicked) {
                findNavController().navigate(R.id.action_homeFragment_to_triviaFragment)
                homeViewModel.onEasyButtonClicked.value = false
            }

        }
    }
}