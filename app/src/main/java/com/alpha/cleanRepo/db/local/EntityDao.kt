package com.alpha.cleanRepo.db.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import retrofit2.Response


@Dao
interface EntityDao {

    @Query("SELECT * FROM myEntity")
    fun getAllEntities(): List<MyEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertEntities(entity: MyEntity)

}
