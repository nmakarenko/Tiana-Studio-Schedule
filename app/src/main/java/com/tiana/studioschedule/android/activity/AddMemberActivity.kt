package com.tiana.studioschedule.android.activity

import android.os.Bundle
import android.view.MenuItem
import com.tiana.studioschedule.R
import com.tiana.studioschedule.android.activity.abstracts.CustomToolbarActivity
import com.tiana.studioschedule.android.activity.fragment.AddMemberFragment
import kotlinx.android.synthetic.main.activity_add_member.*

class AddMemberActivity : CustomToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_member)

        supportActionBar!!.setTitle(R.string.add_member_title)

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.page_frame, AddMemberFragment.newInstance(), AddMemberFragment.TAG)
                .commit()

        fab.setOnClickListener { finish() }
    }

    override fun onBackPressed() {
        finish()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}