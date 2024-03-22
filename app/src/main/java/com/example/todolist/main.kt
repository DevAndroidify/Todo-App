package com.example.todolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.todolist.data.database
import com.example.todolist.databinding.FragmentMainBinding


class main : Fragment() {

        private lateinit var binding:FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentMainBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        binding.addnewdata.setOnClickListener {
            findNavController().navigate(R.id.action_main_to_adddata)
        }
        val database=database.getDatabase(requireContext())
        database.userDao().readdata().observe(viewLifecycleOwner, Observer {

               binding.mainrecylerview.adapter=adapter(requireActivity(),it)
        })
        return binding.root
    }


}