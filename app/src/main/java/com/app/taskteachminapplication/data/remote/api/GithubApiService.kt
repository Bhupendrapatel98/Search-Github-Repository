package com.app.taskteachminapplication.data.remote.api

import com.app.taskteachminapplication.data.model.ApiResponse
import com.app.taskteachminapplication.data.model.RepositoryItem
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface GithubApiService {
    @Headers("Accept: application/vnd.github+json", "Authorization: <Api-KEy>")
    @GET("search/repositories")
    suspend fun searchRepositories(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): ApiResponse<List<RepositoryItem>>
}