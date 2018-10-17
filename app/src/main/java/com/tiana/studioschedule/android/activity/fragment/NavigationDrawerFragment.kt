package com.tiana.studioschedule.android.activity.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tiana.studioschedule.R
import com.tiana.studioschedule.android.activity.MainActivity

class NavigationDrawerFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_left_drawer, container, false)

        view.findViewById<View>(R.id.layout_day_schedule_item).setOnClickListener {
            (activity as MainActivity?)?.showDayScheduleFragment()
        }
        view.findViewById<View>(R.id.layout_members_item).setOnClickListener {
            (activity as MainActivity?)?.showMembersFragment()
        }

        return view
    }

    companion object {
        const val TAG = "navigation_drawer_fragment"

        @JvmStatic
        fun newInstance() : NavigationDrawerFragment {
            return NavigationDrawerFragment()
        }
    }
}