package com.somnathmitra.android.employeedirectory.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.somnathmitra.android.employeedirectory.R
import com.somnathmitra.android.employeedirectory.data.model.Employee

class EmployeeAdapter(private var context: Context? , private var dataList:ArrayList<Employee>) :
    RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {

    fun setList(dataList: ArrayList<Employee>){
        this.dataList = dataList;
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        return EmployeeViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_employee, parent, false))
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val employee : Employee = dataList.get(position)
        Glide
            .with(context!!)
            .load(employee.photoUrlSmall)
            .centerCrop()
            .placeholder(R.drawable.ic_person_black_60dp)
            .into(holder.photoImageView)
        holder.nameTextView.text = employee.fullName
        holder.phoneTextView.text = employee.phoneNumber
        holder.emailTextView.text = employee.emailAddress
        holder.employeeTypeTextView.text = employee.employeeType
        holder.employeeTypeTextView.text = employee.employeeType
        holder.biographyTextView.text = employee.biography

    }


    class EmployeeViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var photoImageView:ImageView = itemView.findViewById(R.id.photoImageView)
        var nameTextView:TextView = itemView.findViewById(R.id.nameTextView)
        var phoneTextView:TextView = itemView.findViewById(R.id.phoneTextView)
        var emailTextView:TextView = itemView.findViewById(R.id.emailTextView)
        var employeeTypeTextView:TextView = itemView.findViewById(R.id.employeeTypeTextView)
        var biographyTextView:TextView = itemView.findViewById(R.id.biographyTextView)
    }
}