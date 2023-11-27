@file:Suppress("DEPRECATION")

package com.example.netclanexplorer

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet.Layout
import androidx.fragment.app.Fragment
import androidx.fragment.app.*
import androidx.viewpager.widget.ViewPager

const val selected_color = Color.WHITE
const val unselected_color = Color.GRAY
private var isImage1 = true  //toggle plus and cross

lateinit var personalTextview: TextView
lateinit var businessTextview: TextView
lateinit var merchantTextview: TextView

lateinit var underlinePersonal: Button
lateinit var underlineBusiness: Button
lateinit var underlineMerchant: Button

lateinit var floatingActionButton: ImageButton


class ExploreActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explore)
        supportActionBar?.title = "Howdy User !!"

        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        val pagerAdapter = ScreenSlidePagerAdapter(supportFragmentManager)
        viewPager.adapter = pagerAdapter

         personalTextview = findViewById(R.id.personal_textview_explore)
         businessTextview = findViewById(R.id.business_textview_explore)
         merchantTextview = findViewById(R.id.merchant_textview_explore)

         underlinePersonal = findViewById(R.id.personal_underline)
         underlineBusiness = findViewById(R.id.business_underline)
         underlineMerchant = findViewById(R.id.merchant_underline)


         floatingActionButton = findViewById(R.id.plus_options_explore)



        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                // Not needed 
            }

            override fun onPageSelected(position: Int) {
                // Called when a new page becomes selected
                updateViewsBasedOnPage(position)
            }


            override fun onPageScrollStateChanged(state: Int) {
                // Not needed 
            }
        })

        personalTextview.setOnClickListener {
            personalTextview.setTextColor(selected_color)
            merchantTextview.setTextColor(unselected_color)
            businessTextview.setTextColor(unselected_color)

            underlinePersonal.alpha = 1F
            underlineBusiness.alpha = 0F
            underlineMerchant.alpha = 0F

            viewPager.currentItem = 0



            floatingActionButton.visibility = View.VISIBLE
        }


        businessTextview.setOnClickListener {
            personalTextview.setTextColor(unselected_color)
            merchantTextview.setTextColor(unselected_color)
            businessTextview.setTextColor(selected_color)

            underlinePersonal.alpha = 0F
            underlineBusiness.alpha = 1F
            underlineMerchant.alpha = 0F

            viewPager.currentItem = 1

            floatingActionButton.visibility = View.VISIBLE
        }

        merchantTextview.setOnClickListener {
            personalTextview.setTextColor(unselected_color)
            businessTextview.setTextColor(unselected_color)
            merchantTextview.setTextColor(selected_color)

            underlinePersonal.alpha = 0F
            underlineBusiness.alpha = 0F
            underlineMerchant.alpha = 1F

            viewPager.currentItem = 2

            floatingActionButton.visibility = View.VISIBLE

        }



        floatingActionButton.setOnClickListener {
            if (isImage1) {
                floatingActionButton.setImageResource(R.drawable.ic_shortcut_close)
            } else {
                floatingActionButton.setImageResource(R.drawable.ic_shortcut_add)
            }
            isImage1 = !isImage1

        }


    }

    private fun updateViewsBasedOnPage(position: Int) {
        if (position == 0) {
            personalTextview.setTextColor(selected_color)
            businessTextview.setTextColor(unselected_color)
            merchantTextview.setTextColor(unselected_color)

            underlinePersonal.alpha = 1F
            underlineBusiness.alpha = 0F
            underlineMerchant.alpha = 0F
        } else if (position == 1) {
            personalTextview.setTextColor(unselected_color)
            businessTextview.setTextColor(selected_color)
            merchantTextview.setTextColor(unselected_color)

            underlinePersonal.alpha = 0F
            underlineBusiness.alpha = 1F
            underlineMerchant.alpha = 0F
        } else if (position == 2) {
            personalTextview.setTextColor(unselected_color)
            businessTextview.setTextColor(unselected_color)
            merchantTextview.setTextColor(selected_color)

            underlinePersonal.alpha = 0F
            underlineBusiness.alpha = 0F
            underlineMerchant.alpha = 1F
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_refine, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.refine_menu_item -> {
                val intent = Intent(this, RefineActivity::class.java)
                startActivity(intent)
            }

        }
        return super.onOptionsItemSelected(item)
    }

    private inner class ScreenSlidePagerAdapter(fm: androidx.fragment.app.FragmentManager) :
        FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        override fun getCount(): Int = 3

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> PersonalFragment()
                1 -> BusinessFragment()
                2 -> MerchantFragment()
                else -> throw IllegalArgumentException("Invalid position")
            }
        }
    }


}

class PersonalFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.personal_layout, container, false)


    }


}

class BusinessFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.business_layout, container, false)
    }

}

class MerchantFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.merchant_layout, container, false)
    }

}