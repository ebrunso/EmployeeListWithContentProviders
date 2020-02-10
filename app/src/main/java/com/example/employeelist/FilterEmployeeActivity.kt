package com.example.employeelist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class FilterEmployeeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter_employee)

    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.btnGoToNewEmployee -> startActivity(Intent(this, NewEmployeeActivity::class.java))
            R.id.btnDepartment -> startActivity(Intent(this, EmployeeListActivity::class.java))

        }
    }
}
