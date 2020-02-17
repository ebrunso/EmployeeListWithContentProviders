package com.example.employeelist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_filter_employee.*
import kotlinx.android.synthetic.main.activity_filter_employee.view.*

class FilterEmployeeActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    var selection = ""

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        selection = snrDepartment.selectedItem.toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter_employee)

        val database = EmployeeDatabaseHelper(this)
        val spinner: Spinner = findViewById(R.id.snrDepartment)
        spinner.onItemSelectedListener = this
        val arrayOfDept = database.getAllDepartmentsFromDatabase()
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayOfDept)
        spinner.adapter = adapter

    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.btnDepartment -> {
                val intent = Intent(this, EmployeeListActivity::class.java)
                intent.putExtra("employee", selection)
                startActivity(intent)
                finish()
            }

        }
    }
}
