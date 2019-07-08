package com.somnathmitra.android.employeedirectory.ui

import android.content.Context
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
    var callType: Int = WELL_FORMED_RESPONSE

    companion object {

        const val CALL_TYPE_KEY = "CALL_TYPE"
        const val WELL_FORMED_RESPONSE = 1
        const val MALFORMED_RESPONSE = 2
        const val EMPTY_RESPONSE = 3

        @JvmStatic
        fun newInstance(callType : Int) = EmployeesListFragment().apply {
            arguments = Bundle().apply {
                putInt(CALL_TYPE_KEY, callType)
            }
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        arguments?.getInt(CALL_TYPE_KEY)?.let {
            callType = it
        }
    }


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
        when(callType){
            MALFORMED_RESPONSE -> employeesListViewModel.getEmployeesMalformedResponse()
            EMPTY_RESPONSE -> employeesListViewModel.getEmptyResponse()
            else -> {
                employeesListViewModel.getEmployees()
            }
        }

    }

    override fun onDestroy() {
        employeesListViewModel.onDestroy()
        super.onDestroy()
    }

}