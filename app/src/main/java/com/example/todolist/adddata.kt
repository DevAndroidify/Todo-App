package com.example.todolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.todolist.data.database
import com.example.todolist.data.user
import com.example.todolist.databinding.FragmentAdddataBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class adddata : Fragment() {

      private lateinit var binding:FragmentAdddataBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentAdddataBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        val database=database.getDatabase(requireContext())

        binding.adddatabutton.setOnClickListener {
            val description=binding.description.text.toString()
            GlobalScope.launch(Dispatchers.IO) {
                try {
                    val data= user(data=description)
                    database.userDao().insert(data)
                       withContext(Dispatchers.Main){
                           Toast.makeText(requireContext(), "data inserted", Toast.LENGTH_SHORT).show()

                       }

                }catch (e:Exception){

                }
            }

        }
        binding.backbutton.setOnClickListener {
              findNavController().navigateUp()
        }
        return binding.root
    }


}