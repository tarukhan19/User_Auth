package com.demo.userauth.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//  indices = [Index(value = ["emailId"], unique = true) , Index(value = ["phoneNumber"], unique = true) ])
@Entity(tableName = "user")
data class UserEntity(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true) val id: Int = 0,

    @ColumnInfo(name = "emailId")
    val emailId: String = "",

    @ColumnInfo(name = "phoneNumber")
    val phoneNumber: String = "",

    @ColumnInfo(name = "fullName")
    val fullName: String = "",

    @ColumnInfo(name = "password")
    val password: String = ""
)