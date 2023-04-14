package com.example.paging3_compse

import android.graphics.ColorFilter
import android.graphics.Paint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.paging3_compse.data.network.User

@Composable
fun UserList(viewModel: MainViewModel) {
    val userList = viewModel.usersPager.collectAsLazyPagingItems()

    LazyColumn {
        items(userList) { item ->
            item?.let { UserCard(user = item) }
        }

        when (userList.loadState.append) {
            is LoadState.NotLoading -> Unit
            LoadState.Loading -> {
                item {
                    LoadingItem()
                }
            }

            is LoadState.Error -> {
                item {
                  ErrorItem(message = "some error occurred!!!")
                }
            }
        }


        // to show progressbar in center when first 10 items are fetching
        when (userList.loadState.refresh) {
            is LoadState.NotLoading -> Unit
            LoadState.Loading -> {
                item {

                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Center) {
                        CircularProgressIndicator()
                    }
                }
            }

            is LoadState.Error -> Unit // do nothing
        }

    }


}

@Composable
fun UserCard(user: User) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(6.dp), elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {

            AsyncImage(
                modifier = Modifier
                    .width(42.dp)
                    .height(42.dp)
                    .clip(CircleShape),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(user.picture)
                    .crossfade(true)
                    .build(),
                contentDescription = stringResource(id = R.string.app_name),
                placeholder = painterResource(id = R.drawable.ic_launcher_background),
                contentScale = ContentScale.Crop,
            )

            Text(
                text = user.name, fontSize = 20.sp,
                modifier = Modifier
                    .align(CenterVertically)
                    .padding(10.dp)
            )
        }
    }

}

@Composable
fun LoadingItem() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        contentAlignment = Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .width(42.dp)
                .height(42.dp)
                .padding(8.dp),
            strokeWidth = 5.dp
        )
    }
}

@Composable
fun ErrorItem(message: String) {

    Card(
        elevation = 2.dp, modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Red)
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "",
                colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.White),
                modifier = Modifier
                    .width(42.dp)
                    .height(42.dp)
                    .clip(CircleShape)
            )
            
            Text(text = message, fontSize = 15.sp  , modifier = Modifier.padding(10.dp).align(CenterVertically))
        }
    }

}

@Preview
@Composable
fun UserPreview() {

    UserCard(user = User("Belal", "1", "Khan", "null", "Mr."))
}