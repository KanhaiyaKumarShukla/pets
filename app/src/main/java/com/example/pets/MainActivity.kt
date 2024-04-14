package com.example.pets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fltActionBtn=findViewById<FloatingActionButton>(R.id.fab)
        fltActionBtn.setOnClickListener {
            val intent = Intent(this, EditorActivity::class.java)
            startActivity(intent)
        }
    }

    // Here we are using menu in this app. so we are implementing necessary methods. Must watch:
    // https://developer.android.com/develop/ui/views/components/menus#xml
    //In this method, you can inflate your menu resource, defined in XML, into the Menu provided in the callback.
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        // getMenuInflater() : MenuInflater :- return MenuInflater in this context.
        // In kotlin, we can directly use 'menuInflater' instead of getMenuInflater() to get MenuInflater
        // inflate(menuRes : Int, menu :Menu) :- inflate menu from specified xml resource. "menuRes" parameter is resource id for xml resource to load . "menu" is Menu to inflate into.
        val inflater:MenuInflater=menuInflater
        inflater.inflate(R.menu.main_acitivity_menu, menu)

        // You must return true for the menu to be displayed; if you return false it will not be shown.
        return true;
    }

    // When the user selects an item from the options menu, including action items in the app bar, the system calls your activity's onOptionsItemSelected() method.
    // This method passes the MenuItem selected. You can identify the item by calling getItemId(), which returns the unique ID for the menu item, defined by the android:id attribute in the menu resource.
    // You can match this ID against known menu items to perform the appropriate action.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // When you successfully handle a menu item, return true. If you don't handle the menu item, call the superclass implementation of onOptionsItemSelected(). The default implementation returns false.
        return when(item.itemId){
            R.id.insert_data -> {
                true
            } R.id.delete_data -> {
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}