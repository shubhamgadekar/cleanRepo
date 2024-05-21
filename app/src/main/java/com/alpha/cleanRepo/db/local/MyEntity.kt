package com.alpha.cleanRepo.db.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "myEntity")
data class MyEntity(
    @PrimaryKey
    val id: Int,
    val name: String
) : Serializable