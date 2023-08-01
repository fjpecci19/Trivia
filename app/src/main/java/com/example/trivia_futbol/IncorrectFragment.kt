package com.example.trivia_futbol

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import com.example.trivia_futbol.databinding.FragmentIncorrectBinding

class IncorrectFragment : Fragment() {

    private lateinit var binding: FragmentIncorrectBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_incorrect, container, false)

        binding.backIncorrect.setOnClickListener {
            val mainFragment = MainFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_navigation_container, mainFragment)
            transaction.addToBackStack(null)
            transaction.commit()
            MainFragment.puntouno = false
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