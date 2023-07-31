package com.example.trivia_futbol

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_first, container, false)
        val option1 = view.findViewById<Button>(R.id.option1)
        val option2 = view.findViewById<Button>(R.id.option2)
        val option3 = view.findViewById<Button>(R.id.option3)
        val option4 = view.findViewById<Button>(R.id.option4)

        option1.setOnClickListener {
            val secondFragment = SecondFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_navigation_container, secondFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        option2.setOnClickListener {
            val thirdFragment = ThirdFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_navigation_container, thirdFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        option3.setOnClickListener {
            val thirdFragment = ThirdFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_navigation_container, thirdFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        option4.setOnClickListener {
            val secondFragment = SecondFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_navigation_container, secondFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
        return view
    }
}
