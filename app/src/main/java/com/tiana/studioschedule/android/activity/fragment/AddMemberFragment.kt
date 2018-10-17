package com.tiana.studioschedule.android.activity.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.tiana.studioschedule.R
import com.tiana.studioschedule.database.model.Member
import kotlinx.android.synthetic.main.fragment_add_member.*

class AddMemberFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_add_member, container, false)

        view.findViewById<EditText>(R.id.member_name).inputType = InputType.TYPE_TEXT_FLAG_CAP_WORDS

        return view
    }

    fun getNewMember() : Member? {
        val name = member_name.text.toString()
        val phone = member_phone.text.toString()
        val success = validate(phone)
        return if (success) Member(name, phone) else null
    }

    private fun validate(number: String) : Boolean {
        if (!android.util.Patterns.PHONE.matcher(number).matches()) {
            Toast.makeText(context, getString(R.string.error_phone_number), Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    companion object {
        const val TAG = "add_member_fragment"

        @JvmStatic
        fun newInstance() : AddMemberFragment {
            return AddMemberFragment()
        }
    }
}