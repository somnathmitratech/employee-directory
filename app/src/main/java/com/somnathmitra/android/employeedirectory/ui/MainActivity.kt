package com.somnathmitra.android.employeedirectory.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.somnathmitra.android.employeedirectory.MyApplication
import com.somnathmitra.android.employeedirectory.R
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.internal.schedulers.RxThreadFactory
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    lateinit var getValidResponseButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getValidResponseButton = findViewById(R.id.getValidResponseButton)
        getValidResponseButton.setOnClickListener{
            getValidResponses()
        }

    }

    fun getValidResponses(){
        Log.d("MainActivity","Clicked")
        // Get the text fragment instance
        val employeesListFragment = EmployeesListFragment()

        // Get the support fragment manager instance
        val manager = supportFragmentManager

        // Begin the fragment transition using support fragment manager
        val transaction = manager.beginTransaction()

        // Replace the fragment on container
        transaction.replace(R.id.rootLayout,employeesListFragment)
        transaction.addToBackStack(null)

        // Finishing the transition
        transaction.commit()
    }
}
