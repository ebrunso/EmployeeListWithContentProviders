package com.example.employeelist

import android.content.ContentValues
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
                var valsToUpdate = ContentValues().apply{
                    put(COL_FIRST_NAME, etFirstName.text.toString())
                    put(COL_LAST_NAME, etLastName.text.toString())
                    put(COL_STREET_ADDRESS, etStreet.text.toString())
                    put(COL_CITY, etCity.text.toString())
                    put(COL_STATE, etState.text.toString())
                    put(COL_ZIP, etZip.text.toString())
                    put(COL_TAXID, etTaxID.text.toString())
                    put(COL_POSITION, etPosition.text.toString())
                    put(COL_DEPARTMENT, etDepartment.text.toString())
                }
                contentResolver.update(CONTENT_URI, valsToUpdate, etTaxID.text.toString(),null)
                Toast.makeText(this@UpdateEmployeeActivity,
                    "Employee database entry updated!", Toast.LENGTH_LONG)
            }
        }
    }
}
