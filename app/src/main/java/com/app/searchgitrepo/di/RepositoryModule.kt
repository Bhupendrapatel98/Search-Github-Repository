package com.app.searchgitrepo.di

import com.app.searchgitrepo.data.remote.repository.GitHubRepository
import com.app.searchgitrepo.data.remote.repository.GitHubRepositoryImpl
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