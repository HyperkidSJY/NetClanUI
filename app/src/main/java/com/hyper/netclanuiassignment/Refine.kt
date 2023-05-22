package com.hyper.netclanuiassignment

import android.os.Bundle
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.hyper.netclanuiassignment.databinding.FragmentRefineBinding





class Refine : Fragment() {
    private var binding : FragmentRefineBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRefineBinding.inflate(inflater,container,false)

        val availability = resources.getStringArray(R.array.availability)
        val arrayAdapter = ArrayAdapter(requireContext(),R.layout.drop_down_item,availability)
        binding!!.actvAvailability.setAdapter(arrayAdapter)

        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}