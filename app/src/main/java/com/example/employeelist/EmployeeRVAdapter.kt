package com.example.employeelist

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_employee_details.view.*

class EmployeeRVAdapter(var employeeList : ArrayList<Employee>, val callback: EmployeeCallback)
    : RecyclerView.Adapter<EmployeeRVAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_employee_details, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.populateEmployeeItem(employeeList[position])

    override fun getItemCount() = employeeList.size

    fun updateList(passedList : ArrayList<Employee>) {
        employeeList = passedList
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun populateEmployeeItem(employee : Employee) {
            itemView.tvFirstName.text = employee.firstName
            itemView.tvLastName.text = employee.lastName
            //itemView.tvStreet.text = employee.streetAddress
            //itemView.tvCity.text = employee.city
            //itemView.tvState.text = employee.state
            //itemView.tvZip.text = employee.zip
           //itemView.tvTaxID.text = employee.taxID
            //itemView.tvPosition.text = employee.position
            //itemView.tvDepartment.text = employee.department
            itemView.setOnClickListener {
                val intent = Intent(it.context, EmployeeDescription::class.java)
                intent.putExtra("employee", employee)
                it.context.startActivity(intent)
            }
                //callback.passEmployee(employee)}
        }
    }

}