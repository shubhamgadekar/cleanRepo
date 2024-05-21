package com.alpha.cleanRepo.di

import android.content.Context
import androidx.room.Room
import com.alpha.cleanRepo.db.local.AppDatabase
import com.alpha.cleanRepo.db.local.EntityDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "my_db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideEntityDao(database: AppDatabase): EntityDao {
        return database.entityDao()
    }
}