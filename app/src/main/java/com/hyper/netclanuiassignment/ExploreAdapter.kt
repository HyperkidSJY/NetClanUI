package com.hyper.netclanuiassignment

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hyper.netclanuiassignment.databinding.ListItemBinding

class ExploreAdapter(private  val context : Context, private val list: ArrayList<models>) : RecyclerView.Adapter<ExploreAdapter.ViewHolder>(){

    class ViewHolder(binding : ListItemBinding) : RecyclerView.ViewHolder(binding.root){
        val image = binding.ivProfile
        val name = binding.tvName
        val location = binding.tvLocation
        val purpose = binding.tvPurpose
        val availability = binding.tvAvailability
        val request = binding.tvRequest
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListItemBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = list[position]
        holder.name.text = model.name
        holder.location.text = model.location
        holder.availability.text = model.availability
        holder.purpose.text = model.purpose
        holder.image.setImageResource(list[position].image)
        holder.request.setOnClickListener {
            if(holder.request.text == "+ INVITE"){
                holder.request.text = "PENDING"
            }else{
                holder.request.text = "+ INVITE"
            }
        }
    }
}