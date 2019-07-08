package com.somnathmitra.android.employeedirectory.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.somnathmitra.android.employeedirectory.MyApplication
import com.somnathmitra.android.employeedirectory.R
import com.somnathmitra.android.employeedirectory.data.model.Employee
import com.somnathmitra.android.employeedirectory.data.model.EmployeesResponse
import com.somnathmitra.android.employeedirectory.ui.adapter.EmployeeAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class EmployeesListFragment : Fragment() {

    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var recyclerView: RecyclerView
    lateinit var employeeAdapter: EmployeeAdapter
    lateinit var employees : ArrayList<Employee>
    lateinit var employeesListViewModel: EmployeesListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       var view : View = inflater.inflate(R.layout.layout_generic_list, container,false)
        recyclerView = view.findViewById(R.id.recyclerView)
        employees = ArrayList()
        var myApplication : MyApplication = activity!!.application as MyApplication
        employeesListViewModel = EmployeesListViewModel(myApplication.compositeDisposable,myApplication.networkService)
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        linearLayoutManager = LinearLayoutManager(context)
        employeeAdapter = EmployeeAdapter(context,employees)
        recyclerView.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = linearLayoutManager
            // set the custom adapter to the RecyclerView
            adapter = employeeAdapter
        }
        employeesListViewModel.employees.observe(this, Observer{
            employees.clear()
            employees.addAll(it)
            employeeAdapter.setList(employees)
        })
        employeesListViewModel.getEmployees()
    }

    override fun onDestroy() {
        employeesListViewModel.onDestroy()
        super.onDestroy()
    }

}