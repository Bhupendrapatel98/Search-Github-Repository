package com.app.taskteachminapplication.data.remote.repository

import androidx.paging.PagingData
import com.app.taskteachminapplication.data.model.RepositoryItem
import kotlinx.coroutines.flow.Flow

interface GitHubRepository {
    fun searchRepositories(query: String): Flow<PagingData<RepositoryItem>>
    fun searchRepositoriesOffline(query: String): Flow<PagingData<RepositoryItem>>
    fun searchRepositoriesCombined(query: String): Flow<PagingData<RepositoryItem>>
}