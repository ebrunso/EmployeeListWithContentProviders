package com.example.employeelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_delete_employee.*

class DeleteEmployeeActivity : AppCompatActivity() {

    val databaseHelper by lazy{ EmployeeDatabaseHelper(this)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_employee)
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.btnAddEmployeeToList -> {
                Toast.makeText(this@DeleteEmployeeActivity,
                    "Employee deleted from database!", Toast.LENGTH_LONG)
                val taxID = etTaxID.text.toString()
                databaseHelper.removeEmployeeFromDatabase(taxID)
            }
        }
    }
}
