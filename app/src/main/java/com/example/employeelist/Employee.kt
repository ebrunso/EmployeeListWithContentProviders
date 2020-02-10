package com.example.employeelist

// 1. FirstName
//    2. LastName
//    3. StreetAddress
//    4. City
//    5. State
//    6. Zip
//    7. TaxID
//    8. Position
//    9. Department

data class Employee(
    var firstName : String,
    var lastName : String,
    var streetAddress : String,
    var city : String,
    var state : String,
    var zip : String,
    var taxID : String,
    var position : String,
    var department : String)