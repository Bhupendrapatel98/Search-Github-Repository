package com.app.taskteachminapplication.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.taskteachminapplication.data.model.RepositoryItem

@Dao
interface RepositoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRepositories(repositories: List<RepositoryItem>)

    @Query("SELECT * FROM repositories")
    fun getRepositories(): PagingSource<Int, RepositoryItem>

    @Query("SELECT * FROM repositories WHERE name LIKE '%' || :query || '%' OR description LIKE '%' || :query || '%'")
    fun searchRepositories(query: String): PagingSource<Int, RepositoryItem>

    @Query("DELETE FROM repositories")
    suspend fun deleteAllRepositories()
}