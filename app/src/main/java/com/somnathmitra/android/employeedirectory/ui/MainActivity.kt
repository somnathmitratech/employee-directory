package com.somnathmitra.android.employeedirectory.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.somnathmitra.android.employeedirectory.MyApplication
import com.somnathmitra.android.employeedirectory.R
import com.somnathmitra.android.employeedirectory.di.components.DaggerMainActivityComponent
import com.somnathmitra.android.employeedirectory.di.components.MainActivityComponent
import com.somnathmitra.android.employeedirectory.di.module.ActivityModule
import com.somnathmitra.android.employeedirectory.util.NetworkUtil
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var showValidResponseButton : Button

    lateinit var mainActivityComponent: MainActivityComponent

    @Inject
    lateinit var networkUtil: NetworkUtil

    companion object{
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showValidResponseButton = findViewById(R.id.getValidResponseButton)
        getDependencies()
        showValidResponseButton.setOnClickListener{
            showValidResponses()
        }

    }

    fun getDependencies(){
        mainActivityComponent = DaggerMainActivityComponent.builder().
            activityModule(ActivityModule(this))
            .applicationComponent((application as MyApplication).applicationComponent)
            .build()

        mainActivityComponent.inject(this)
    }

    fun showValidResponses(){
        Log.d("MainActivity","Clicked")
        // Get the text fragment instance
        Log.d(TAG,"Network connected = ${networkUtil.isNetworkConnected()}")
        if(networkUtil.isNetworkConnected()){

            val employeesListFragment = EmployeesListFragment()

            // Get the support fragment manager instance
            val manager = supportFragmentManager

            // Begin the fragment transition using support fragment manager
            val transaction = manager.beginTransaction()

            // Replace the fragment on container
            transaction.replace(R.id.rootLayout,employeesListFragment)

            // Finishing the transition
            transaction.commit()
        } else {
            Toast.makeText(this,"Internet is not connected.",Toast.LENGTH_SHORT).show()
        }

    }
}
