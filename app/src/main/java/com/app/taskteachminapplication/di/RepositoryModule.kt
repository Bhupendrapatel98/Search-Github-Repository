package com.app.taskteachminapplication.di

import com.app.taskteachminapplication.data.remote.repository.GitHubRepository
import com.app.taskteachminapplication.data.remote.repository.GitHubRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindGitHubRepository(impl: GitHubRepositoryImpl): GitHubRepository
}