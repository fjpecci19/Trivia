package com.example.trivia_futbol

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import com.example.trivia_futbol.databinding.FragmentCorrectBinding

class CorrectFragment : Fragment() {

    private lateinit var binding: FragmentCorrectBinding
    private lateinit var binding2: FirstTriviaFragment
    private lateinit var binding3: SecondTriviaFragment
    private lateinit var binding4: ThirdTriviaFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_correct, container, false)

        binding.backCorrect.setOnClickListener {
            val mainFragment = MainFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_navigation_container, mainFragment)
            transaction.addToBackStack(null)
            transaction.commit()

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