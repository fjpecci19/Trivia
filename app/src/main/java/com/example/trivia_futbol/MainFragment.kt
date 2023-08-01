package com.example.trivia_futbol

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import com.example.trivia_futbol.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)

        binding.first.setOnClickListener {
            val firstTriviaFragment = FirstTriviaFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_navigation_container, firstTriviaFragment)
            transaction.addToBackStack(null)
            transaction.commit()
            FirstTriviaFragment.puntouno = false
        }

        binding.second.setOnClickListener {
            val secondTriviaFragment = SecondTriviaFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_navigation_container, secondTriviaFragment)
            transaction.addToBackStack(null)
            transaction.commit()
            SecondTriviaFragment.puntodos = false
        }

        binding.third.setOnClickListener {
            val thirdTriviaFragment = ThirdTriviaFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_navigation_container, thirdTriviaFragment)
            transaction.addToBackStack(null)
            transaction.commit()
            ThirdTriviaFragment.puntotres = false
        }

        if (FirstTriviaFragment.puntouno) {
            cont += 1
        }

        else if (SecondTriviaFragment.puntodos){
            cont += 1
        }

        else if (ThirdTriviaFragment.puntotres){
            cont += 1
        }

        if (finishedone){
            binding.first.isEnabled = false
        }

        if (finishedtwo){
            binding.second.isEnabled = false
        }

        if (finishedthree){
            binding.third.isEnabled = false
        }

        binding.points.text = cont.toString()

        return binding.root
    }
    companion object{
        var cont: Int = 0
        var finishedone: Boolean = false
        var finishedtwo: Boolean = false
        var finishedthree: Boolean = false
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
            }
        })
    }
}