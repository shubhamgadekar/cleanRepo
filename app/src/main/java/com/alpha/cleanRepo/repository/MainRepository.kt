package com.alpha.cleanRepo.repository

import com.alpha.cleanRepo.api.MyService
import com.alpha.cleanRepo.db.local.EntityDao
import com.alpha.cleanRepo.db.local.MyEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val myService: MyService,
    private val entityDao: EntityDao
) {

    fun getMyEntityList(): Flow<List<String>?> = flow {
        try {
            val response = myService.getResponse()
            if (response.isSuccessful) {
                emit(response.body())
            } else {
                emit(emptyList())
            }
        } catch (e: Exception) {
            e.printStackTrace()
            emit(emptyList())
        }
    }.flowOn(Dispatchers.IO).catch { emit(emptyList()) }

}