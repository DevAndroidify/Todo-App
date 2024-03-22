package com.example.todolist

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.data.user
import com.example.todolist.databinding.FragmentMainBinding


class adapter(val context: FragmentActivity, val productList: List<user>) : RecyclerView.Adapter<adapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapterlayout, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        val currentItem = productList[position]
        holder.description.text=currentItem.data
        val id=currentItem.id
        holder.itemView.setOnClickListener {
            val action = mainDirections.actionMainToUpdatedata(id)


            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return productList.size
    }

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
val description:TextView=itemView.findViewById(R.id.layoutdescription)


    }
}
