package com.example.employeelist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_new_employee.*

class NewEmployeeActivity : AppCompatActivity() {

    val databaseHelper by lazy{ EmployeeDatabaseHelper(this)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_employee)
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
                var toast = Toast.makeText(this@NewEmployeeActivity,
                    "New Employee entered into database!", Toast.LENGTH_LONG)
                toast.show()
            }
        }
    }
}
