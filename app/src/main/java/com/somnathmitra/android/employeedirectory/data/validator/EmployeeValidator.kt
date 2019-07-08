package com.somnathmitra.android.employeedirectory.data.validator

import com.somnathmitra.android.employeedirectory.data.model.Employee

class EmployeeValidator {

    companion object{
        fun cleanData(employees : List<Employee>) : ArrayList<Employee> {

            val employeeMap: HashMap<String, Employee> = HashMap()
            for (employee in employees) {
                if (isValid(employee)) { // only employees that are valid will be inserted
                    if (!employeeMap.containsKey(employee.id)) {
                        // The first valid employee found is given priority
                        // Even if the second one with same id is found
                        // it will not be inserted
                        employeeMap.put(employee.id, employee)
                    }
                }
            }
            return ArrayList(employeeMap.values)
        }

        fun isValid(employee: Employee) : Boolean{

            // check required fields
            // assuming full_name / phone number / email address are id
            // are required fields
            var valid : Boolean = false
            employee.apply {
                valid = !id.isNullOrEmpty() &&
                        !fullName.isNullOrEmpty() &&
                        !phoneNumber.isNullOrEmpty() &&
                        !emailAddress.isNullOrEmpty()
            }
            return valid
        }
    }


}