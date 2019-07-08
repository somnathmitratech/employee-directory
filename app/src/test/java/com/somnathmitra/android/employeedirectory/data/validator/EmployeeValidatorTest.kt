package com.somnathmitra.android.employeedirectory.data.validator

import com.somnathmitra.android.employeedirectory.data.model.Employee
import org.junit.Assert
import org.junit.Test

class EmployeeValidatorTest() {

    var employee1 = Employee(
        "0d8fcc12-4d0c-425c-8355-390b312b909c",
        "Justine Mason",
        "5553280123",
        "jmason.demo@squareup.com",
        "",
        "",
        "",
        "",
        ""
    )

    var employee2 = Employee(
        "a98f8a2e-c975-4ba3-8b35-01f719e7de2d",
        "Camille Rogers",
        "5558531970",
        "crogers.demo@squareup.com",
        "",
        "",
        "",
        "",
        ""
    )

    var employee3 = Employee(
        "",
        "",
        "5557510409",
        "tnakamura.demo@squareup.com",
        "",
        "",
        "",
        "",
        ""
    )

    var employee4 = Employee(
        "ca020d09-76c6-44a5-ada9-8459d281c317",
        "Michael Morin",
        "5557976363",
        "mmorin.demo@squareup.com",
        "",
        "",
        "",
        "",
        ""
    )

    var employee5 = Employee(
        "ca020d09-76c6-44a5-ada9-8459d281c317",
        "Jack Dorsey",
        "5554544932",
        "jdorsey.demo@squareup.com",
        "",
        "",
        "",
        "",
        ""
    )

    fun getCleanDataList() : ArrayList<Employee> {
      return arrayListOf(employee1,employee2)
    }

    fun getMalformedDataList() : ArrayList<Employee> {
        return arrayListOf(employee1,employee2,employee3,employee4,employee5)
    }

    fun getEmptyDataList() : ArrayList<Employee> {
        return arrayListOf()
    }

    @Test
    fun test_isValid_True_CorrectInput() {
        Assert.assertTrue(EmployeeValidator.isValid(employee1))
        Assert.assertTrue(EmployeeValidator.isValid(employee2))
    }

    @Test
    fun test_isValid_False_MalformedInput() {
        Assert.assertFalse(EmployeeValidator.isValid(employee3))
    }

    @Test
    fun test_cleanData_CorrectInput(){
        val input = getCleanDataList()
        val output = EmployeeValidator.cleanData(input)
        Assert.assertTrue(input.size == 2)
        Assert.assertTrue(output.size == 2)
    }

    @Test
    fun test_cleanData_MalformedInput(){
        val input = getMalformedDataList()
        val output = EmployeeValidator.cleanData(input)
        Assert.assertTrue(input.size == 5)
        Assert.assertTrue(output.size == 3)
    }

    @Test
    fun test_cleanData_EmptyInput(){
        val input = getEmptyDataList()
        val output = EmployeeValidator.cleanData(input)
        Assert.assertTrue(input.size == 0)
        Assert.assertTrue(output.size == 0)
    }
}