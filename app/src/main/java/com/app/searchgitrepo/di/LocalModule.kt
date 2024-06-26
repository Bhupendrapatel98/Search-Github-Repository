package com.app.searchgitrepo.di

import android.app.Application
import androidx.room.Room
import com.app.searchgitrepo.data.local.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppDatabase =
        Room.databaseBuilder(app, AppDatabase::class.java, "search_database")
            .fallbackToDestructiveMigration()
            .build()
}