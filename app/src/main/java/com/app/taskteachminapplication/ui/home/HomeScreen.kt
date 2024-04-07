package com.app.taskteachminapplication.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.app.taskteachminapplication.R
import com.app.taskteachminapplication.data.model.RepositoryItem
import com.app.taskteachminapplication.navigation.MainDestinations
import com.app.taskteachminapplication.ui.MainViewModel
import com.google.gson.Gson
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun HomeScreen(navHostController: NavHostController) {
    val viewModel: MainViewModel = hiltViewModel()
    var query by rememberSaveable { mutableStateOf("") }

    LaunchedEffect(query) {
        viewModel.searchRepositories(query)
    }

    val pagingData: LazyPagingItems<RepositoryItem> =
        viewModel.getRepositories().collectAsLazyPagingItems()

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        OutlinedTextField(
            value = query,
            onValueChange = { newQuery ->
                query = newQuery
            },
            label = { Text("Search Repositories", color = Color.White) },
            modifier = Modifier
                .fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.White,
                focusedBorderColor = Color.Blue,
                textColor = Color.White
            ),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = null,
                    tint = Color.White
                )
            }
        )
        Spacer(modifier = Modifier.height(16.dp))

        RepositoryList(pagingData, navHostController)
    }
}

@Composable
fun RepositoryList(
    pagingData: LazyPagingItems<RepositoryItem>,
    navController: NavHostController
) {
    LazyColumn {
        items(pagingData.itemCount) { index ->
            val repository = pagingData[index]
            if (repository != null) {
                RepositoryItem(repository, navController)
            }
        }
    }
}

@Composable
fun RepositoryItem(repository: RepositoryItem, navController: NavHostController) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                val jsonString = Gson().toJson(repository)
                var encode = URLEncoder.encode(jsonString, StandardCharsets.UTF_8.toString())
                val encodedUrl = encode.replace("+", "%20")
                navController.navigate("${MainDestinations.REPOSITORY_DETAILS_ROUTE}/$encodedUrl")
            }
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 3.dp),
            backgroundColor = Color.White,
            elevation = 8.dp,
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Repository : ${repository.name.toString()}",
                    color = Color.Black,
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = "Owner : ${repository.owner.login.toString()}",
                    color = Color.Black,
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}
