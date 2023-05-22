package com.hyper.netclanuiassignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hyper.netclanuiassignment.databinding.FragmentExploreBinding



class Explore : Fragment() {

    private var binding : FragmentExploreBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExploreBinding.inflate(inflater,container,false)

        replaceFragment(Individual())

        binding!!.individual.setOnClickListener {
            replaceFragment(Individual())
        }
        binding!!.professional.setOnClickListener {
            replaceFragment(Professional())
        }
        binding!!.merchant.setOnClickListener {
            replaceFragment(Merchant())
        }

        return binding!!.root
    }


    private fun replaceFragment(fragment : Fragment){
        val fragmentTransaction = activity?.supportFragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.frame_layout,fragment)
        fragmentTransaction?.detach(fragment)
        fragmentTransaction?.attach(fragment)
        fragmentTransaction?.commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}