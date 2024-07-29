package com.mramallo.randomusertt.ui.randomUser

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import com.mramallo.randomusertt.R
import com.mramallo.randomusertt.core.navigation.AppScreens
import com.mramallo.randomusertt.ui.randomUserDetail.domain.entity.RandomUserItem
import com.mramallo.randomusertt.ui.theme.Theme
import com.mramallo.randomusertt.ui.theme.secondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RandomUserScreen(
    navController: NavController,
    randomUserViewModel: RandomUserViewModel = hiltViewModel()
) {
    var randomUsers = randomUserViewModel.randomUsers.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        color = Color.White,
                        style = TextStyle(fontSize = 16.sp)
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = secondary
                )
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            when{
                // Initial load
                randomUsers.loadState.refresh is LoadState.Loading && randomUsers.itemCount == 0 -> {
                    DisplayProgressBar()
                }

                // Error - No loading and no data available
                randomUsers.loadState.refresh is LoadState.NotLoading && randomUsers.itemCount == 0 -> {
                    DisplayEmptyView()
                }

                // Error - Connection error or API failed
                randomUsers.loadState.hasError -> {
                    DisplayErrorView(
                        tryAgain = { randomUsers.refresh() }
                    )
                }

                else -> {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        verticalArrangement = Arrangement.spacedBy(Theme.spacings.size30),
                        horizontalArrangement = Arrangement.spacedBy(Theme.spacings.size30),
                        contentPadding = PaddingValues(Theme.spacings.size40),
                        modifier = Modifier.fillMaxWidth().weight(1f)
                    ) {
                        items(randomUsers.itemCount) {
                            randomUsers[it]?.let { randomUserItem ->
                                DisplayRandomUser(randomUserItem, navController)
                            }
                        }
                    }

                    if(randomUsers.loadState.append is LoadState.Loading){
                        DisplayProgressBar()
                    }
                }
            }

            Text(
                text = "Developed by Manuel Ramallo Díaz",
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth().padding(horizontal = Theme.spacings.size20, vertical = Theme.spacings.size10),
                style = TextStyle(fontSize = 12.sp),
                color = Color.Gray
            )
        }
    }


}

@Composable
private fun DisplayRandomUser(randomUserItem: RandomUserItem, navController: NavController) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .aspectRatio(3f / 4f)
            .clickable {
                navController.navigate(route = AppScreens.RandomUserDetailScreen.route + "/${randomUserItem.id}")
            },
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            DisplayImageUser(randomUserItem.avatar)
            DisplayBlur()
            DisplayInfoUser(randomUserItem)
        }
    }

}


@Composable
private fun DisplayImageUser(imageUrl: String) {
    AsyncImage(
        model = imageUrl,
        contentDescription = "Avatar user",
        placeholder = painterResource(id = R.drawable.placeholder_vertical),
        error = painterResource(id = R.drawable.placeholder_vertical),
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxSize()
            .aspectRatio(3f / 4f),
    )
}

@Composable
private fun DisplayBlur(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color.Black.copy(0.9f)
                    ),
                    startY = 200f
                )
            )
    )
}

@Composable
private fun DisplayInfoUser(randomUserItem: RandomUserItem){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = Theme.spacings.size20, horizontal = Theme.spacings.size40),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Bottom
    ){
        Text(
            text = "${randomUserItem.firstName} ${randomUserItem.lastName}",
            color = Color.White,
            style = TextStyle(fontSize = 16.sp),
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = randomUserItem.email,
            color = Color.LightGray,
            style = TextStyle(fontSize = 10.sp)
        )
    }
}

@Composable
fun DisplayProgressBar() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        CircularProgressIndicator(
            modifier = Modifier.size(64.dp),
            color = Color.Black
        )
    }
}

@Composable
private fun DisplayEmptyView() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.random_user_empty), 
            contentDescription = "empty random user",
            modifier = Modifier.size(180.dp)
        )
        Spacer(modifier = Modifier.padding(vertical = Theme.spacings.size10))
        Text(
            text = stringResource(id = R.string.empty_random_users),
            style = TextStyle(fontSize = 24.sp),
            color = Color.Black
        )
    }
}

@Composable
private fun DisplayErrorView(tryAgain: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(42.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.error),
            contentDescription = "error",
            modifier = Modifier.size(80.dp)
        )
        Spacer(modifier = Modifier.padding(vertical = Theme.spacings.size30))
        Text(
            text = stringResource(id = R.string.error_title_random_users),
            style = TextStyle(fontSize = 24.sp),
            color = Color.Black,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.padding(vertical = Theme.spacings.size10))
        Text(
            text = stringResource(id = R.string.error_subtitle_random_users),
            style = TextStyle(fontSize = 18.sp),
            color = Color.Black,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.padding(vertical = Theme.spacings.size30))
        Button(
            onClick = { tryAgain() },
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Try again")
        }
    }
}

@Preview
@Composable
fun RandomUserScreenPreview() {
    RandomUserScreen(rememberNavController())
}