package com.tiana.studioschedule.android.activity

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.View
import com.tiana.studioschedule.R
import com.tiana.studioschedule.android.activity.abstracts.CustomToolbarActivity
import com.tiana.studioschedule.android.activity.fragment.DayScheduleFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : CustomToolbarActivity() {

    private var drawerToggle: ActionBarDrawerToggle? = null
    private var drawerLayout: DrawerLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.page_frame, DayScheduleFragment.newInstance(), DayScheduleFragment.TAG)
                .commit()

        drawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout!!.setStatusBarBackgroundColor(
                ContextCompat.getColor(this, R.color.primary))

        createDrawerToggle()
    }

    private fun createDrawerToggle() {
        drawerToggle = object : ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.drawer_open, R.string.drawer_close) {

            override fun onDrawerOpened(drawerView: View) {
                invalidateOptionsMenu()
            }

            override fun onDrawerClosed(drawerView: View) {
                invalidateOptionsMenu()
            }

        }
        drawerLayout!!.addDrawerListener(drawerToggle!!)
        drawerToggle!!.syncState()
        drawerToggle!!.setToolbarNavigationClickListener {
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        if (!handleDrawerBackPress()) super.onBackPressed()
    }

    private fun handleDrawerBackPress(): Boolean =
            if (drawerLayout!!.isDrawerOpen(GravityCompat.START)) {
                drawerLayout!!.closeDrawer(GravityCompat.START)
                true
            } else {
                false
            }
}
