package com.example.todolist

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.todolist.data.database
import com.example.todolist.data.user
import com.example.todolist.databinding.FragmentUpdatedataBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class updatedata : Fragment() {
    private lateinit var binding:FragmentUpdatedataBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentUpdatedataBinding.inflate(layoutInflater)
        val database=database.getDatabase(requireContext())
        // Inflate the layout for this fragment

       val a=arguments?.getInt("id")
        //Toast.makeText(requireContext(), a!!, Toast.LENGTH_SHORT).show()
        binding.adddatabutton.setOnClickListener {
            val description=binding.description.text.toString()
            GlobalScope.launch(Dispatchers.IO) {
                try {
                    val user=user(id=a!!,data=description)
                    database.userDao().updatedata(user)
                    withContext(Dispatchers.Main){
                        Toast.makeText(requireContext(), "data updated successfully", Toast.LENGTH_SHORT).show()
                    }
                }catch (e:Exception){

                }
            }


        }
        binding.backbutton.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.deletebutton.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                try {
                    val user=user(id=a!!,data="de")
                database.userDao().deletedata(user)
                withContext(Dispatchers.Main){
                    Toast.makeText(requireContext(), "file deleted successfully", Toast.LENGTH_SHORT).show()
                }
                }catch (e:Exception){}

            }
        }

        return binding.root
    }


}