package com.example.employeelist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_employee_description.*

class EmployeeDescription : AppCompatActivity() {

    val database by lazy { EmployeeDatabaseHelper(this)}
    val passedEmployee by lazy {intent?.getParcelableExtra<Employee>("employee")}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_description)
        tvFirstName.text= "First name: " + passedEmployee?.firstName
        tvLastName.text = "Last name: " + passedEmployee?.lastName
        tvStreet.text= "Street: " + passedEmployee?.streetAddress
        tvCity.text= "City: " + passedEmployee?.city
        tvState.text= "State: " + passedEmployee?.state
        tvZip.text= "Zip: " + passedEmployee?.zip
        tvTaxID.text= "Tax ID: " + passedEmployee?.taxID
        tvPosition.text= "Position: "+ passedEmployee?.position
        tvDepartment.text= "Department: " + passedEmployee?.department


    }

    fun onClick(view: View){
        when(view.id){
            R.id.btnUpdate -> {
                val intent = Intent(this, UpdateEmployeeActivity::class.java)
                intent.putExtra("employee", passedEmployee)
                startActivity(intent)
                finish()
            }
            R.id.btnDelete -> {
                database.removeEmployeeFromDatabase(passedEmployee?.taxID.toString())
                val intent = Intent(this, FilterEmployeeActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }


}
