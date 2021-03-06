package com.tiana.studioschedule.android.activity.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tiana.studioschedule.R

class MembersFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_members, container, false)
        return view
    }

    companion object {
        const val TAG = "members_fragment"

        @JvmStatic
        fun newInstance() : MembersFragment {
            return MembersFragment()
        }
    }
}