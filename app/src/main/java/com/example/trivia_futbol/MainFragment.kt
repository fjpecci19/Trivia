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
    private var puntos = ""

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
        }

        binding.second.setOnClickListener {
            val secondTriviaFragment = SecondTriviaFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_navigation_container, secondTriviaFragment)
            transaction.commit()
        }

        binding.third.setOnClickListener {
            val thirdTriviaFragment = ThirdTriviaFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_navigation_container, thirdTriviaFragment)
            transaction.commit()
        }

        binding.restart.setOnClickListener {
            cont = 0
            puntouno = 0
            puntodos = 0
            puntotres = 0
            finishedone = 0
            finishedtwo = 0
            finishedthree = 0
            puntos = getString(R.string.points)
            puntos += " $cont"
            binding.points.text = puntos
            binding.first.isEnabled = true
            binding.second.isEnabled = true
            binding.third.isEnabled = true
            binding.first.text = getString(R.string.first_trivia)
            binding.second.text = getString(R.string.second_trivia)
            binding.third.text = getString(R.string.third_trivia)
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

        puntos = getString(R.string.points)
        puntos += " $cont"
        binding.points.text = puntos

        if (finishedone == 2){
            binding.first.isEnabled = false
            binding.first.text = getString(R.string.first_trivia_done)
        }

        if (finishedtwo == 2){
            binding.second.isEnabled = false
            binding.second.text = getString(R.string.second_trivia_done)
        }

        if (finishedthree == 2){
            binding.third.isEnabled = false
            binding.third.text = getString(R.string.third_trivia_done)
        }

        return binding.root
    }
    companion object{
        var cont: Int = 0
        var puntouno: Int = 0
        var puntodos: Int = 0
        var puntotres: Int = 0
        var finishedone: Int = 0
        var finishedtwo: Int = 0
        var finishedthree: Int = 0
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
            }
        })
    }
}