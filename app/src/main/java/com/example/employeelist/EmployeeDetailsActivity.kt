package com.example.employeelist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class EmployeeDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_details)
    }
    fun onClick(view: View) {
        when (view.id) {
            R.id.btnGoToDeleteEmployee -> startActivity(Intent(this, DeleteEmployeeActivity::class.java))
            R.id.btnGoToUpdateEmployee -> startActivity(Intent(this, UpdateEmployeeActivity::class.java))

        }
    }

}
