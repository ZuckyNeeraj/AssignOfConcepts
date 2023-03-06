package com.example.displayuser

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.data.FemaleData
import com.example.data.MaleData
import com.example.displayuser.databinding.DataViewBinding


class DataAdapter(): RecyclerView.Adapter<DataAdapter.ToDoViewHolder>() {

    private var maleData: ArrayList<MaleData>? = null

    inner class ToDoViewHolder(val binding: DataViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataViewBinding.inflate(layoutInflater, parent, false)
        return ToDoViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        holder.binding.apply {
            // tvTitle this now works
            nameTextView.text = maleData?.get(position)?.name
            roleTextView.text = maleData?.get(position)?.role
        }
    }

    override fun getItemCount(): Int {
        return maleData?.size ?: 0
    }


    @SuppressLint("NotifyDataSetChanged")
    fun setData(maleDatas: ArrayList<MaleData>?) {
        this.maleData = maleDatas
        notifyDataSetChanged()
    }

    fun addData(maleDatas: MaleData) {
        maleData?.let {
            it.add(maleDatas)
            notifyItemChanged(it.size-1)
        }
    }
}


