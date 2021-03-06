package com.example.employeelist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_employee_details.*
import kotlinx.android.synthetic.main.activity_employee_list.*
import kotlinx.android.synthetic.main.activity_filter_employee.*

class EmployeeListActivity : AppCompatActivity(), EmployeeCallback {

    val databaseHelper by lazy{ EmployeeDatabaseHelper(this)}
    //val adapter by lazy {EmployeeRVAdapter(databaseHelper.getAllDepartmentsFromDatabase(name), this)}
    lateinit var adapter: EmployeeRVAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_list)
        val name = intent.getStringExtra("employee")
        adapter = EmployeeRVAdapter(databaseHelper.getAllDatabaseObjectsFromDatabase(name),this)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvEmployee.layoutManager = layoutManager
        rvEmployee.adapter = adapter
        //adapter.updateList(databaseHelper.getAllEmployeesFromDatabase())
    }

    override fun passEmployee(employee: Employee) {
        tvFirstName.setText(employee.firstName)
        tvLastName.setText(employee.lastName)
//        tvStreet.setText(employee.streetAddress)
//        tvCity.setText(employee.streetAddress)
//        tvState.setText(employee.streetAddress)
//        tvZip.setText(employee.streetAddress)
//        tvTaxID.setText(employee.streetAddress)
//        tvPosition.setText(employee.streetAddress)
        tvDepartment.setText(employee.streetAddress)
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.btnGoToNewEmployee -> startActivity(Intent(this, NewEmployeeActivity::class.java))
            R.id.btnGoToDeleteEmployee -> startActivity(Intent(this, DeleteEmployeeActivity::class.java))
            R.id.btnGoToUpdateEmployee -> startActivity(Intent(this, UpdateEmployeeActivity::class.java))
            R.id.btnGoToFilterEmployee -> startActivity(Intent(this, FilterEmployeeActivity::class.java))
        }
    }

}
