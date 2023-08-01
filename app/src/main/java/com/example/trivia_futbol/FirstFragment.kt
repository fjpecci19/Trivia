package com.example.trivia_futbol

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.trivia_futbol.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    public var cont = 0
    private var correct = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)


        binding.option1.setOnClickListener {
            val secondFragment = SecondFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_navigation_container, secondFragment)
            transaction.addToBackStack(null)
            transaction.commit()
            correct = false
        }

        binding.option2.setOnClickListener {
            val thirdFragment = ThirdFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_navigation_container, thirdFragment)
            transaction.addToBackStack(null)
            transaction.commit()
            correct = true
            cont += 1
        }


        if (correct && cont > 0){
            binding.option1.isEnabled = false
            binding.option2.isEnabled = false
            binding.results.text = getString(R.string.correct)
        } else{
            binding.option1.isEnabled = false
            binding.option2.isEnabled = false
            binding.results.text = getString(R.string.incorrect)
        }

        binding.restart.setOnClickListener {
            cont = 0
            binding.results.text = ""
            binding.option1.isEnabled = true
            binding.option2.isEnabled = true
        }

        return binding.root
    }
}
