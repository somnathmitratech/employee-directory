package com.somnathmitra.android.employeedirectory.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.somnathmitra.android.employeedirectory.MyApplication
import com.somnathmitra.android.employeedirectory.R
import com.somnathmitra.android.employeedirectory.di.components.DaggerEmployeeListFragmentComponent
import com.somnathmitra.android.employeedirectory.ui.adapter.EmployeeAdapter
import javax.inject.Inject

class EmployeesListFragment : Fragment() {

    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var recyclerView: RecyclerView
    lateinit var employeeAdapter: EmployeeAdapter
    @Inject
    lateinit var employeesListViewModel: EmployeesListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       var view : View = inflater.inflate(R.layout.layout_generic_list, container,false)
        recyclerView = view.findViewById(R.id.recyclerView)
        getDependencies()
        return view
    }

    fun getDependencies(){
        var application : MyApplication = activity!!.application as MyApplication
        DaggerEmployeeListFragmentComponent.builder().applicationComponent(application.applicationComponent)
            .build()
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        linearLayoutManager = LinearLayoutManager(context)
        employeeAdapter = EmployeeAdapter(context)
        recyclerView.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = linearLayoutManager
            // set the custom adapter to the RecyclerView
            adapter = employeeAdapter
        }
        employeesListViewModel.employees.observe(this, Observer{
            employeeAdapter.setList(it)
        })
        employeesListViewModel.getEmployees()
    }

    override fun onDestroy() {
        employeesListViewModel.onDestroy()
        super.onDestroy()
    }

}