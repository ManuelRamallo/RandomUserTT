package com.mramallo.randomusertt.ui.randomUserDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
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
import coil.compose.AsyncImage
import com.mramallo.randomusertt.R
import com.mramallo.randomusertt.ui.randomUser.DisplayProgressBar
import com.mramallo.randomusertt.ui.randomUserDetail.domain.entity.RandomUser
import com.mramallo.randomusertt.ui.theme.Theme
import com.mramallo.randomusertt.ui.theme.secondary
import com.mramallo.randomusertt.ui.theme.tertiary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RandomUserDetailScreen(
    randomUserDetailViewModel: RandomUserDetailViewModel = hiltViewModel(),
    navController: NavController,
    idUser: String?
) {

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
                ),
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                }

            )
        }
    ) { innerPadding ->

        if (!idUser.isNullOrEmpty()) {
            LaunchedEffect(Unit) {
                randomUserDetailViewModel.getRandomById(idUser)
            }

            val randomUser = randomUserDetailViewModel.stateRandomItem

            if (randomUser.loading) {
                DisplayProgressBar()
            }

            randomUser.user?.let { user ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                ) {
                    DisplayRandomUser(user)
                }
            } ?: run {
                DisplayErrorView()
            }
        } else {
            DisplayErrorView()
        }
    }
}

@Composable
fun DisplayRandomUser(user: RandomUser) {
    val screenHeight = LocalConfiguration.current.screenWidthDp.dp

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        AsyncImage(
            model = user.data.avatar,
            placeholder = painterResource(id = R.drawable.placeholder_user),
            error = painterResource(id = R.drawable.placeholder_user),
            contentDescription = "user avatar",
            modifier = Modifier.fillMaxSize(),
            alignment = Alignment.TopCenter
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(screenHeight * 0.9f),
            shape = RoundedCornerShape(
                topEnd = 16.dp,
                topStart = 16.dp,
                bottomEnd = 0.dp,
                bottomStart = 0.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(tertiary)
                    .padding(top = Theme.spacings.size60),
            ) {
                Text(
                    text = "${user.data.firstName} ${user.data.lastName}",
                    style = TextStyle(fontSize = 24.sp),
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = Theme.spacings.size40),
                )

                Text(
                    text = user.data.email,
                    style = TextStyle(fontSize = 16.sp),
                    color = Color.Gray,
                    modifier = Modifier.padding(
                        top = Theme.spacings.size10,
                        start = Theme.spacings.size40,
                        end = Theme.spacings.size40
                    )
                )
                Spacer(modifier = Modifier.padding(Theme.spacings.size30))
                Divider(color = secondary)
                Spacer(modifier = Modifier.padding(Theme.spacings.size20))

                Text(
                    text = "Description",
                    style = TextStyle(fontSize = 16.sp),
                    color = Color.DarkGray,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(
                        top = Theme.spacings.size10,
                        start = Theme.spacings.size40,
                        end = Theme.spacings.size40
                    )
                )

                Spacer(modifier = Modifier.padding(Theme.spacings.size10))

                Text(
                    text = stringResource(id = R.string.description_user),
                    style = TextStyle(fontSize = 16.sp),
                    color = Color.Black,
                    modifier = Modifier
                        .padding(
                            top = Theme.spacings.size10,
                            start = Theme.spacings.size40,
                            end = Theme.spacings.size40
                        )
                        .verticalScroll(rememberScrollState())
                )

            }
        }
    }
}

@Composable
private fun DisplayErrorView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(42.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
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
    }
}

@Preview
@Composable
fun RandomUserDetailScreenPreview() {
    RandomUserDetailScreen(
        randomUserDetailViewModel = hiltViewModel(),
        rememberNavController(),
        "1234"
    )
}