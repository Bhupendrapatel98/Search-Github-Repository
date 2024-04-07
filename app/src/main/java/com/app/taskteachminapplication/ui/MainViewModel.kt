package com.app.taskteachminapplication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.app.taskteachminapplication.data.model.RepositoryItem
import com.app.taskteachminapplication.data.remote.repository.GitHubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.time.debounce
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val gitHubRepository: GitHubRepository) :
    ViewModel() {

    private val queryFlow = MutableStateFlow("")
    private val repositoryFlow = queryFlow
        .debounce(300)
        .distinctUntilChanged()
        .flatMapLatest { query ->
            if (query.isNotEmpty()) {
                gitHubRepository.searchRepositoriesCombined(query)
            } else {
                flowOf(PagingData.empty())
            }
        }

    fun searchRepositories(query: String) {
        queryFlow.value = query
    }

    fun getRepositories(): Flow<PagingData<RepositoryItem>> {
        return repositoryFlow
    }
}