package com.tiana.studioschedule.android.activity.abstracts

import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.tiana.studioschedule.R

abstract class CustomToolbarActivity : AppCompatActivity() {

    override fun setContentView(view: Int) {
        super.setContentView(view)

        initToolbar()
    }

    protected fun initToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        if (toolbar != null) {
            setSupportActionBar(toolbar)
            toolbar.setTitleTextColor(ContextCompat.getColor(applicationContext, android.R.color.white))
            toolbar.setSubtitleTextColor(ContextCompat.getColor(applicationContext, android.R.color.white))
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }
    }
}