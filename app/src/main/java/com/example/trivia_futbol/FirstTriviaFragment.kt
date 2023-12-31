package com.example.trivia_futbol

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import com.example.trivia_futbol.databinding.FragmentFirstTriviaBinding

class FirstTriviaFragment : Fragment() {

    private lateinit var binding: FragmentFirstTriviaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first_trivia, container, false)

        binding.option1.setOnClickListener {
            val incorrectFragment = IncorrectFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_navigation_container, incorrectFragment)
            transaction.addToBackStack(null)
            transaction.commit()
            MainFragment.puntouno = 1
            MainFragment.finishedone = 2
        }

        binding.option2.setOnClickListener {
            val correctFragment = CorrectFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_navigation_container, correctFragment)
            transaction.addToBackStack(null)
            transaction.commit()
            MainFragment.puntouno = 2
            MainFragment.finishedone = 2
        }

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
            }
        })
    }
}