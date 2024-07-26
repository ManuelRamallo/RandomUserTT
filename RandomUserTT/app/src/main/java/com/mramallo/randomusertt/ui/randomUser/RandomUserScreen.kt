package com.mramallo.randomusertt.ui.randomUser

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mramallo.randomusertt.R
import com.mramallo.randomusertt.core.navigation.AppScreens
import com.mramallo.randomusertt.ui.randomUserDetail.domain.entity.RandomUserItem
import com.mramallo.randomusertt.ui.theme.Theme

@Composable
fun RandomUserScreen(
    navController: NavController,
    randomUserViewModel: RandomUserViewModel = hiltViewModel()
) {
    val randomUsers = randomUserViewModel.randomUsers.collectAsLazyPagingItems()

    Column {
        Text("Aquí va el buscador")
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(Theme.spacings.size30),
            horizontalArrangement = Arrangement.spacedBy(Theme.spacings.size30),
            contentPadding = PaddingValues(Theme.spacings.size40)
        ) {
            items(randomUsers.itemCount) {
                randomUsers[it]?.let { randomUserItem ->
                    DisplayRandomUser(randomUserItem)
                }
            }
        }
    }


    /*Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Random user list")

        Spacer(modifier = Modifier.height(Theme.spacings.size20))

        Button(
            onClick = {
                navController.navigate(route = AppScreens.RandomUserDetailScreen.route)
            }
        ) {
            Text(text = "Navegar al detalle")
        }
    }*/
}

@Composable
fun DisplayRandomUser(randomUserItem: RandomUserItem) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .aspectRatio(3f / 4f)
            .clickable { },
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            DisplayImageUser(randomUserItem.picture.large)
            DisplayBlur()
            DisplayInfoUser(randomUserItem)
        }
    }

}


@Composable
fun DisplayImageUser(imageUrl: String) {
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
fun DisplayBlur(){
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
fun DisplayInfoUser(randomUserItem: RandomUserItem){
    Column(
        modifier = Modifier.fillMaxSize().padding(vertical = Theme.spacings.size20, horizontal = Theme.spacings.size40),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Bottom
    ){
        Text(
            text = "${randomUserItem.name.first} ${randomUserItem.name.last}",
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

@Preview
@Composable
fun RandomUserScreenPreview() {
    RandomUserScreen(rememberNavController())
}