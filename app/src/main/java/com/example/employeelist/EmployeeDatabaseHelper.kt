package com.example.employeelist

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf

class EmployeeDatabaseHelper(context : Context)
    : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(sqLiteDatabase: SQLiteDatabase?) {
        sqLiteDatabase?.execSQL(CREATE_EMPLOYEE_TABLE)
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase?, previousVersion: Int, newVersion: Int) {
        onCreate(sqLiteDatabase)
    }

    fun insertEmployeeIntoDatabase(employee: Employee){
        val database = writableDatabase
        val contentValues = ContentValues()

        contentValues.put(COL_FIRST_NAME, employee.firstName)
        contentValues.put(COL_LAST_NAME, employee.lastName)
        contentValues.put(COL_STREET_ADDRESS, employee.streetAddress)
        contentValues.put(COL_CITY, employee.city)
        contentValues.put(COL_STATE, employee.state)
        contentValues.put(COL_ZIP, employee.zip)
        contentValues.put(COL_TAXID, employee.taxID)
        contentValues.put(COL_POSITION, employee.position)
        contentValues.put(COL_DEPARTMENT, employee.department)

        database.insert(TABLE_NAME, null, contentValues)
        database.close()

    }

    fun getOneEmployeeFromDatabase(taxID : String) : Employee? {
        val database = readableDatabase
        var employee : Employee? = null
        val cursor = database
            .rawQuery("SELECT * FROM $TABLE_NAME WHERE $COL_TAXID = '$taxID'",
                null)

        if(cursor.moveToFirst()) {
            val firstName = cursor.getString(cursor.getColumnIndex(COL_FIRST_NAME))
            val lastName = cursor.getString(cursor.getColumnIndex(COL_LAST_NAME))
            val streetAddress = cursor.getString(cursor.getColumnIndex(COL_STREET_ADDRESS))
            val city = cursor.getString(cursor.getColumnIndex(COL_CITY))
            val state = cursor.getString(cursor.getColumnIndex(COL_STATE))
            val zip = cursor.getString(cursor.getColumnIndex(COL_ZIP))
            val taxID = cursor.getString(cursor.getColumnIndex(COL_TAXID))
            val position = cursor.getString(cursor.getColumnIndex(COL_POSITION))
            val department = cursor.getString(cursor.getColumnIndex(COL_DEPARTMENT))

            employee = Employee(firstName, lastName, streetAddress, city,
                state, zip, taxID, position, department)
        }
        cursor.close()
        database.close()
        return employee
    }

    fun getAllEmployeesFromDatabase() : ArrayList<Employee> {
        val database = readableDatabase
        var employeeList : ArrayList<Employee> = ArrayList<Employee>()
        val cursor = database
            .rawQuery("SELECT * FROM $TABLE_NAME",
                null)

        if(cursor.moveToFirst()) {
            do {
                val firstName = cursor.getString(cursor.getColumnIndex(COL_FIRST_NAME))
                val lastName = cursor.getString(cursor.getColumnIndex(COL_LAST_NAME))
                val streetAddress = cursor.getString(cursor.getColumnIndex(COL_STREET_ADDRESS))
                val city = cursor.getString(cursor.getColumnIndex(COL_CITY))
                val state = cursor.getString(cursor.getColumnIndex(COL_STATE))
                val zip = cursor.getString(cursor.getColumnIndex(COL_ZIP))
                val taxID = cursor.getString(cursor.getColumnIndex(COL_TAXID))
                val position = cursor.getString(cursor.getColumnIndex(COL_POSITION))
                val department = cursor.getString(cursor.getColumnIndex(COL_DEPARTMENT))
                val employee = Employee(firstName, lastName, streetAddress, city,
                    state, zip, taxID, position, department)
                employeeList.add(employee)
            } while(cursor.moveToNext())
        }

        cursor.close()
        database.close()
        return employeeList
    }

    fun updateEmployeeInDatabase(employee : Employee) {
        val database = writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_FIRST_NAME, employee.firstName)
        contentValues.put(COL_LAST_NAME, employee.lastName)
        contentValues.put(COL_STREET_ADDRESS, employee.streetAddress)
        contentValues.put(COL_CITY, employee.city)
        contentValues.put(COL_STATE, employee.state)
        contentValues.put(COL_ZIP, employee.zip)
        contentValues.put(COL_TAXID, employee.taxID)
        contentValues.put(COL_POSITION, employee.position)
        contentValues.put(COL_DEPARTMENT, employee.department)


        database.update(TABLE_NAME, contentValues, "$COL_TAXID = ?", arrayOf(employee.taxID))
        database.close()
    }

    fun removeEmployeeFromDatabase(taxID : String) {
        val database = writableDatabase
        database.delete(TABLE_NAME, "$COL_TAXID = ?", arrayOf(taxID))
        database.close()
    }
}