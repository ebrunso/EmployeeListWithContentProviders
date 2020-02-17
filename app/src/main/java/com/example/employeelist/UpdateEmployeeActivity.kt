package com.example.employeelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_update_employee.*

class UpdateEmployeeActivity : AppCompatActivity() {

    val passedEmployee by lazy{intent?.getParcelableExtra<Employee>("employee")}
    val databaseHelper by lazy{ EmployeeDatabaseHelper(this)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_employee)
        etFirstName.setText(passedEmployee?.firstName)
        etLastName.setText(passedEmployee?.lastName)
        etStreet.setText(passedEmployee?.streetAddress)
        etCity.setText(passedEmployee?.city)
        etState.setText(passedEmployee?.state)
        etZip.setText(passedEmployee?.zip)
        etTaxID.setText(passedEmployee?.taxID)
        etPosition.setText(passedEmployee?.position)
        etDepartment.setText(passedEmployee?.department)
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.btnAddEmployeeToList -> {
                val firstName = etFirstName.text.toString()
                val lastName = etLastName.text.toString()
                val streetAddress = etStreet.text.toString()
                val city = etCity.text.toString()
                val state = etState.text.toString()
                val zip = etZip.text.toString()
                val taxID = etTaxID.text.toString()
                val position = etPosition.text.toString()
                val department = etDepartment.text.toString()
                databaseHelper.insertEmployeeIntoDatabase(Employee(firstName, lastName,
                    streetAddress, city, state, zip, taxID, position, department))
                Toast.makeText(this@UpdateEmployeeActivity,
                    "Employee database entry updated!", Toast.LENGTH_LONG)
            }
        }
    }
}
