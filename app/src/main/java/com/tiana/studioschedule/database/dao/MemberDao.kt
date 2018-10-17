package com.tiana.studioschedule.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.tiana.studioschedule.database.model.Member

@Dao
interface MemberDao {

    @Query("SELECT * from member")
    fun getAll() : List<Member>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(member: Member)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(members: List<Member>)

    @Query("DELETE from member")
    fun deleteAll()
}