package com.app.taskteachminapplication.data.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.app.taskteachminapplication.data.local.database.AppDatabase
import com.app.taskteachminapplication.data.model.RepositoryItem
import com.app.taskteachminapplication.data.paging.GitHubPagingSource
import com.app.taskteachminapplication.data.remote.api.GithubApiService
import com.app.taskteachminapplication.utills.NetworkUtils
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GitHubRepositoryImpl @Inject constructor(
    private val apiService: GithubApiService,
    private val appDatabase: AppDatabase,
    private val networkUtils: NetworkUtils
) : GitHubRepository {

    override fun searchRepositories(query: String): Flow<PagingData<RepositoryItem>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = { GitHubPagingSource(apiService, appDatabase, query) }
        ).flow
    }

    override fun searchRepositoriesOffline(query: String): Flow<PagingData<RepositoryItem>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = { appDatabase.repositoryDao().searchRepositories(query) }
        ).flow
    }

    override fun searchRepositoriesCombined(query: String): Flow<PagingData<RepositoryItem>> {
        return if (networkUtils.isNetworkAvailable()) {
            searchRepositories(query)
        } else {
            searchRepositoriesOffline(query)
        }
    }
}