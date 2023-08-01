package com.example.trivia_futbol

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.trivia_futbol.databinding.FragmentFirstTriviaBinding
import com.example.trivia_futbol.databinding.FragmentSecondTriviaBinding

class SecondTriviaFragment : Fragment() {

    private lateinit var binding: FragmentSecondTriviaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second_trivia, container, false)

        binding.option4.setOnClickListener {
            val incorrectFragment = IncorrectFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_navigation_container, incorrectFragment)
            transaction.addToBackStack(null)
            transaction.commit()
            MainFragment.puntodos = false
            MainFragment.finishedtwo = true
        }

        binding.option3.setOnClickListener {
            val correctFragment = CorrectFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_navigation_container, correctFragment)
            transaction.addToBackStack(null)
            transaction.commit()
            MainFragment.puntodos = true
            MainFragment.finishedtwo = true
        }

        return binding.root
    }
}
