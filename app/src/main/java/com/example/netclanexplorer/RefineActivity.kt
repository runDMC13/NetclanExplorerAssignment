package com.example.netclanexplorer

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupMenu
import android.widget.PopupWindow
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.roundToInt

lateinit var availMenuButton: Button
lateinit var coffeeButton: Button
lateinit var businessButton: Button
lateinit var hobbiesButton: Button
lateinit var friendshipButton: Button
lateinit var moviesButton: Button
lateinit var dinningButton: Button
lateinit var datingButton: Button
lateinit var matrimonyButton: Button
lateinit var saveButton: Button

 const val isSelected = Color.WHITE
 val isUnselected = Color.rgb(0x12, 0x12, 0x12)
private var pressed = true

class RefineActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_refine)

        supportActionBar?.title = "Refine"



        coffeeButton = findViewById(R.id.coffee_button)
        businessButton = findViewById(R.id.business_button)
        hobbiesButton = findViewById(R.id.hobbies_button)
        friendshipButton = findViewById(R.id.friendship_button)
        moviesButton = findViewById(R.id.movies_button)
        dinningButton = findViewById(R.id.dinning_button)
        datingButton = findViewById(R.id.dating_button)
        matrimonyButton = findViewById(R.id.matrimony_button)
        saveButton = findViewById(R.id.save_button)



        coffeeButton.setOnClickListener {
            if (pressed){
            coffeeButton.setTextColor(isSelected)
            coffeeButton.setBackgroundResource(R.drawable.curved_save_button)
        } else {
            coffeeButton.setTextColor(isUnselected)
            coffeeButton.setBackgroundResource(R.drawable.curved_button)
        }
            pressed = !pressed
        }
        businessButton.setOnClickListener {
            if (pressed){
                businessButton.setTextColor(isSelected)
                businessButton.setBackgroundResource(R.drawable.curved_save_button)
            } else {
                businessButton.setTextColor(isUnselected)
                businessButton.setBackgroundResource(R.drawable.curved_button)
            }
            pressed = !pressed
        }
        hobbiesButton.setOnClickListener {
            if (pressed){
                hobbiesButton.setTextColor(isSelected)
                hobbiesButton.setBackgroundResource(R.drawable.curved_save_button)
            } else {
                hobbiesButton.setTextColor(isUnselected)
                hobbiesButton.setBackgroundResource(R.drawable.curved_button)
            }
            pressed = !pressed
        }
        friendshipButton.setOnClickListener {
            if (pressed){
                friendshipButton.setTextColor(isSelected)
                friendshipButton.setBackgroundResource(R.drawable.curved_save_button)
        } else {
                friendshipButton.setTextColor(isUnselected)
                friendshipButton.setBackgroundResource(R.drawable.curved_button)
        }
            pressed = !pressed
        }
        moviesButton.setOnClickListener {
            if (pressed){
                moviesButton.setTextColor(isSelected)
                moviesButton.setBackgroundResource(R.drawable.curved_save_button)
        } else {
                moviesButton.setTextColor(isUnselected)
                moviesButton.setBackgroundResource(R.drawable.curved_button)
        }
            pressed = !pressed
        }
        dinningButton.setOnClickListener {
            if (pressed){
                dinningButton.setTextColor(isSelected)
                dinningButton.setBackgroundResource(R.drawable.curved_save_button)
        } else {
                dinningButton.setTextColor(isUnselected)
                dinningButton.setBackgroundResource(R.drawable.curved_button)
        }
            pressed = !pressed
        }
        datingButton.setOnClickListener {
            if (pressed){
                datingButton.setTextColor(isSelected)
                datingButton.setBackgroundResource(R.drawable.curved_save_button)
            } else {
                datingButton.setTextColor(isUnselected)
                datingButton.setBackgroundResource(R.drawable.curved_button)
            }
            pressed = !pressed
        }
        matrimonyButton.setOnClickListener {
            if (pressed){
                matrimonyButton.setTextColor(isSelected)
                matrimonyButton.setBackgroundResource(R.drawable.curved_save_button)
            } else {
                matrimonyButton.setTextColor(isUnselected)
                matrimonyButton.setBackgroundResource(R.drawable.curved_button)
            }
            pressed = !pressed
        }





         availMenuButton = findViewById(R.id.availability_button_refine)

        availMenuButton.setOnClickListener { showPopupMenu(availMenuButton) }
    }





    private fun showPopupMenu(view: View?) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.inflate(R.menu.dropdown_menu_refine)

        // Set a listener for menu item clicks
        popupMenu.setOnMenuItemClickListener { item: MenuItem ->
            when (item.itemId) {
                R.id.menu_item_1 -> {
                    availMenuButton.text = "Availability | Hey Let Us Connect"
                    true
                }
                R.id.menu_item_2 -> {
                    availMenuButton.text = "Away | Stay Discrete And Watch"
                    true
                }
                R.id.menu_item_3 ->
                {
                    availMenuButton.text = "Busy | Do Not Disturb | Will Catch Up Later"
                    true
                }
                R.id.menu_item_4 ->
                {
                   availMenuButton.text= "SOS | Emergency1 Need Assistance! Help"

                    true
                }
                else -> false
            }
        }

        // Show the popup menu
        popupMenu.show()
    }


}