package com.somnathmitra.android.employeedirectory.data.validator

import com.somnathmitra.android.employeedirectory.data.model.Employee

class EmployeeValidator {

    companion object{
        fun cleanData(employees : List<Employee>) : ArrayList<Employee> {

            val employeeMap: HashMap<String, Employee> = HashMap()
            for (employee in employees) {
                if (employee.isValid()) { // only employees that are valid will be inserted
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
    }


}