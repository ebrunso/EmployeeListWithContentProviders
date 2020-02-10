package com.example.employeelist

//    1. FirstName
//    2. LastName
//    3. StreetAddress
//    4. City
//    5. State
//    6. Zip
//    7. TaxID
//    8. Position
//    9. Department

const val DATABASE_NAME = "data_emp_database"
const val TABLE_NAME = "employee_table"
const val DATABASE_VERSION = 1
const val COL_FIRST_NAME = "first_name"
const val COL_LAST_NAME = "last_name"
const val COL_STREET_ADDRESS = "street_address"
const val COL_CITY = "city"
const val COL_STATE = "state"
const val COL_ZIP = "zip"
const val COL_TAXID = "tax_id"
const val COL_POSITION = "position"
const val COL_DEPARTMENT = "department"


const val CREATE_EMPLOYEE_TABLE =
    "CREATE TABLE $TABLE_NAME (" +
            "$COL_FIRST_NAME String," +
            "$COL_LAST_NAME String," +
            "$COL_STREET_ADDRESS String," +
            "$COL_CITY String," +
            "$COL_STATE String," +
            "$COL_ZIP String PRIMARY_KEY," +
            "$COL_TAXID String," +
            "$COL_POSITION String," +
            "$COL_DEPARTMENT String)"