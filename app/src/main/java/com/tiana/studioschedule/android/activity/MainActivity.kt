package com.tiana.studioschedule.android.activity

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.View
import com.tiana.studioschedule.R
import com.tiana.studioschedule.android.activity.abstracts.CustomToolbarActivity
import com.tiana.studioschedule.android.activity.fragment.DayScheduleFragment
import com.tiana.studioschedule.android.activity.fragment.MembersFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : CustomToolbarActivity() {

    private var drawerToggle: ActionBarDrawerToggle? = null
    private var drawerLayout: DrawerLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout!!.setStatusBarBackgroundColor(
                ContextCompat.getColor(this, R.color.primary))

        showDayScheduleFragment()

        createDrawerToggle()

        fab.setOnClickListener {
            if (supportFragmentManager.findFragmentByTag(MembersFragment.TAG) != null) {
                val intent = Intent(this, AddMemberActivity::class.java)
                startActivity(intent)
            }
        }
    }

    fun showDayScheduleFragment() {
        drawerLayout?.closeDrawer(GravityCompat.START)
        if (supportFragmentManager.findFragmentByTag(DayScheduleFragment.TAG) != null) return
        supportActionBar!!.setTitle(R.string.day_schedule_title)
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.page_frame, DayScheduleFragment.newInstance(), DayScheduleFragment.TAG)
                .commit()
    }

    fun showMembersFragment() {
        drawerLayout?.closeDrawer(GravityCompat.START)
        if (supportFragmentManager.findFragmentByTag(MembersFragment.TAG) != null) return
        supportActionBar!!.setTitle(R.string.members_title)
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.page_frame, MembersFragment.newInstance(), MembersFragment.TAG)
                .commit()
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
