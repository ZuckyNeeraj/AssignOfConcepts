package com.example.displayuser

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.data.FemaleData
import com.example.data.MaleData
import com.example.displayuser.databinding.DataViewBinding


class FemaleDataAdapter(): RecyclerView.Adapter<FemaleDataAdapter.ToDoViewHolder>() {

    private var femaleData: ArrayList<FemaleData>? = null

    inner class ToDoViewHolder(val binding: DataViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataViewBinding.inflate(layoutInflater, parent, false)
        return ToDoViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        holder.binding.apply {
            // tvTitle this now works
            nameTextView.text = femaleData?.get(position)?.name
            roleTextView.text = femaleData?.get(position)?.role
        }
    }

    override fun getItemCount(): Int {
        return femaleData?.size ?: 0
    }


    @SuppressLint("NotifyDataSetChanged")
    fun setData(femaleDatas: ArrayList<FemaleData>?) {
        this.femaleData = femaleDatas
        notifyDataSetChanged()
    }

    fun addData(femaleDatas: FemaleData) {
        femaleData?.let {
            it.add(femaleDatas)
            notifyItemChanged(it.size-1)
        }
    }
}