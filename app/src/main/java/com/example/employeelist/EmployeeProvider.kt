package com.example.employeelist

import android.content.ContentProvider
import android.content.ContentUris
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri

const val EMPLOYEE = 100
const val EMPLOYEE_ITEM = 101

class EmployeeProvider : ContentProvider() {

    val employeeDatabaseHelper by lazy {EmployeeDatabaseHelper(context!!)}
    val uriMatcher by lazy {buildUriMatcher()}

    fun buildUriMatcher() : UriMatcher {
        val returnMatcher = UriMatcher(UriMatcher.NO_MATCH)
        returnMatcher.addURI(CONTENT_AUTHORITY, PATH_EMPLOYEE, EMPLOYEE)
        returnMatcher.addURI(CONTENT_AUTHORITY, "$PATH_EMPLOYEE/#", EMPLOYEE_ITEM)
        return returnMatcher
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        val database = employeeDatabaseHelper.writableDatabase
        val rowsDeleted = database.delete(TABLE_NAME, "$COL_TAXID = ?", selectionArgs)
        if(rowsDeleted > 0){
            context?.contentResolver?.notifyChange(uri, null)
        }
        return rowsDeleted
    }

    override fun getType(uri: Uri): String? {
        return when(uriMatcher.match(uri)){
            EMPLOYEE -> EmployeeEntry.CONTENT_TYPE
            EMPLOYEE_ITEM -> EmployeeEntry.CONTENT_ITEM_TYPE
            else -> null
        }
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        val database = employeeDatabaseHelper.writableDatabase
        val id = database.insert(TABLE_NAME, null, values)
        return when {
            id > 0 -> {
                EmployeeEntry.buildEmployeeUri(id)
            }
            else -> throw UnsupportedOperationException("Unable to insert row into $uri")
        }

    }

    private fun completeInsert(id : Long, uri : Uri) : Uri? {
        context?.contentResolver?.notifyChange(uri, null)
        return EmployeeEntry.buildEmployeeUri(id)
    }

    override fun onCreate(): Boolean {
        return true
    }

    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? {
        val database = employeeDatabaseHelper.writableDatabase
        var returnCursor : Cursor? = null

        when(uriMatcher.match(uri)){
            EMPLOYEE -> {
                returnCursor = database.query(
                    TABLE_NAME,
                    projection,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    sortOrder)
            }
            EMPLOYEE_ITEM -> {
                var id = ContentUris.parseId(uri).toString()
                returnCursor = database.query(
                    TABLE_NAME,
                    projection,
                    "$COL_TAXID = ?",
                    arrayOf(id),
                    null,
                    null,
                    sortOrder)
            }
        }
        return returnCursor
    }

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        val databaseHelper = employeeDatabaseHelper.writableDatabase
        val rowsAffected = databaseHelper.update(TABLE_NAME, values, "$COL_TAXID = ?", selectionArgs)
        if(rowsAffected > 0) {
            context?.contentResolver?.notifyChange(uri, null)
        }
        return rowsAffected
    }
}
