package com.tiana.studioschedule.database.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Member(var name: String, var phone: String) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}