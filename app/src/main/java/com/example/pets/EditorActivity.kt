package com.example.pets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.core.app.NavUtils

class EditorActivity : AppCompatActivity() {
    private lateinit var nameEditText: EditText
    private lateinit var breedEditText: EditText
    private lateinit var weightEditText: EditText
    private lateinit var genderSpinner: Spinner
    private var gender:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)
        nameEditText=findViewById(R.id.name_et)
        breedEditText=findViewById(R.id.breed_et)
        weightEditText=findViewById(R.id.weight_et)
        genderSpinner=findViewById(R.id.spinner_gender)

        setUpSpinner()
    }

    private fun setUpSpinner() {
        // createFromResource() returns a arrayAdapter which is being created by string array.
        ArrayAdapter.createFromResource(
            this,
            R.array.gender_array_spinner,           // resource id of string array
            android.R.layout.simple_spinner_item    // layout resource id which is use to create view of specified strings.
        ).also {                                    //using lambda function which use adapter created above as parameter.
            adapter->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)  // layout resource id which is use to define the drop down list view
            genderSpinner.adapter=adapter           // set the adapter to the spinner
        }
        // when spinner's menu is selected, spinner object receives "on item selected" event. we use selection event handler:
        // onItemSelectedListener(listener) it take listener as input
        genderSpinner.onItemSelectedListener=object:AdapterView.OnItemSelectedListener{         // here we are creating creates an anonymous object that implements the AdapterView.OnItemSelectedListener interface.
            // watch its docs
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                gender=when (parent?.getItemAtPosition(position) as? String){
                    "Male"->1
                    "Female"->2
                    else ->0
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                gender=0
            }

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater:MenuInflater=menuInflater
        inflater.inflate(R.menu.editor_activity_menu,menu)
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.save_action->{
                true
            }
            R.id.delete_action-> {
                true
            }
            /*

            * NavUtils: This is a utility class provided by the Android Support Library (now part of AndroidX) for navigation-related operations.

            * navigateUpFromSameTask(this): This method navigates up to the parent activity within the same task stack as the current activity.
                    It is used within an activity to navigate up to the parent activity within the same task stack.
            * */
            android.R.id.home ->{
                NavUtils.navigateUpFromSameTask(this)
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }

    }
}