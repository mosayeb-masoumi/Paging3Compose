package com.example.paginationcompose.pagination_feature.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.paginationcompose.R
import com.example.paginationcompose.pagination_feature.presentation.components.UserCardItem


import androidx.paging.compose.items  // sooooooooooooo important to add it

@Composable
fun UserLitScreen(viewModel: UserViewModel) {

    val userList = viewModel.userPager.collectAsLazyPagingItems()


    LazyColumn(modifier = Modifier.fillMaxSize() , verticalArrangement = Arrangement.Center) {

        items(userList) { item ->
            item?.let {
                UserCardItem(user = it)
            }
        }

        when (userList.loadState.append) {
            is LoadState.NotLoading -> Unit
            is LoadState.Loading -> {
                item {
                    ShowLoading()
                }
            }

            is LoadState.Error -> {
                item {
                    ShowErrorBox("Some error occurred!!!")
                }
            }
        }

        // to show progress loading in center for first time
        when (userList.loadState.refresh) {
            is LoadState.NotLoading -> {}
            is LoadState.Loading -> {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),

                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(color = Color.Blue)
                    }

                }
            }

            is LoadState.Error -> {
                item {
                    ShowErrorBox("Some error occurred!!!")
                }
            }
        }
    }
}


@Composable
fun ShowLoading() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        contentAlignment = Alignment.Center
    ) {

        CircularProgressIndicator(
            modifier = Modifier
                .size(42.dp)
                .padding(8.dp),
            strokeWidth = 5.dp,
            color = Color.Red
        )
    }
}


@Composable
fun ShowErrorBox(message: String) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Red)
                .padding(8.dp)
        ) {

            Image(
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .width(42.dp)
                    .height(42.dp),
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "error",
                colorFilter = ColorFilter.tint(color = Color.White)
            )

            Text(
                text = message,
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(start = 12.dp)
                    .align(CenterVertically),
            )
        }
    }
}