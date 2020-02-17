package com.example.employeelist

import android.content.ContentValues
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
                var newVals = ContentValues().apply{
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
                contentResolver.insert(CONTENT_URI, newVals)
                var toast = Toast.makeText(this@NewEmployeeActivity,
                    "New Employee entered into database!", Toast.LENGTH_LONG)
                toast.show()
            }
        }
    }
}
