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
            transaction.commit()
            puntouno = 0
        }

        binding.second.setOnClickListener {
            val secondTriviaFragment = SecondTriviaFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_navigation_container, secondTriviaFragment)
            transaction.commit()
            puntodos = 0
        }

        binding.third.setOnClickListener {
            val thirdTriviaFragment = ThirdTriviaFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_navigation_container, thirdTriviaFragment)
            transaction.commit()
            puntotres = 0
        }

        if (puntouno == 2) {
            cont += 1
        }

        else if (puntodos == 2){
            cont += 1
        }

        else if (puntotres == 2){
            cont += 1
        }

        binding.points.text = cont.toString()

        if (finishedone){
            binding.first.isEnabled = false
        }

        else if (finishedtwo){
            binding.second.isEnabled = false
        }

        else if (finishedthree){
            binding.third.isEnabled = false
        }

        return binding.root
    }
    companion object{
        var cont: Int = 0
        var puntouno: Int = 0
        var puntodos: Int = 0
        var puntotres: Int = 0
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