package com.app.taskteachminapplication.ui

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.app.taskteachminapplication.data.model.RepositoryItem
import com.app.taskteachminapplication.data.remote.repository.GitHubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val gitHubRepository: GitHubRepository) :
    ViewModel() {

    fun getRepositories(query: String): Flow<PagingData<RepositoryItem>> {
        return gitHubRepository.searchRepositoriesCombined(query)
    }
}