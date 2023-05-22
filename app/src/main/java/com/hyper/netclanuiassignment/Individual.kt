package com.hyper.netclanuiassignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.hyper.netclanuiassignment.databinding.FragmentIndividualBinding


class Individual : Fragment() {

    private var binding : FragmentIndividualBinding? = null
    private var mExploreData: ArrayList<models> = exploreData.getIndividualData()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentIndividualBinding.inflate(inflater,container,false)

        binding?.rvExplore?.layoutManager = LinearLayoutManager(context)
        val exploreAdapter = ExploreAdapter(requireContext(),mExploreData)
        binding?.rvExplore?.adapter = exploreAdapter




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



    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun replaceFragment(fragment : Fragment){
        val fragmentTransaction = activity?.supportFragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.frame_layout,fragment)
        fragmentTransaction?.detach(fragment)
        fragmentTransaction?.attach(fragment)
        fragmentTransaction?.commit()
    }

}