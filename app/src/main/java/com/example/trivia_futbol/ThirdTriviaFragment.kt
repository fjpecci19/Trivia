package com.example.trivia_futbol

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import com.example.trivia_futbol.databinding.FragmentThirdTriviaBinding

class ThirdTriviaFragment : Fragment() {

    private lateinit var binding: FragmentThirdTriviaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_third_trivia, container, false)

        binding.option6.setOnClickListener {
            val incorrectFragment = IncorrectFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_navigation_container, incorrectFragment)
            transaction.addToBackStack(null)
            transaction.commit()
            MainFragment.puntotres = 1
            MainFragment.finishedthree = 2
        }

        binding.option5.setOnClickListener {
            val correctFragment = CorrectFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_navigation_container, correctFragment)
            transaction.addToBackStack(null)
            transaction.commit()
            MainFragment.puntotres = 2
            MainFragment.finishedthree = 2
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
