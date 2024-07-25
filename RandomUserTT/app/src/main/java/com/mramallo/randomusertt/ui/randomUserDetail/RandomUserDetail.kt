package com.mramallo.randomusertt.ui.randomUserDetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mramallo.randomusertt.core.navigation.AppScreens
import com.mramallo.randomusertt.ui.theme.Theme

@Composable
fun RandomUserDetail(
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Random user detail")

        Spacer(modifier = Modifier.height(Theme.spacings.size20))

        Button(
            onClick = {
                navController.navigate(route = AppScreens.RandomUserScreen.route)
            }
        ) {
            Text(text = "Volver al inicio")
        }
    }
}

@Preview
@Composable
fun RandomUserDetailPreview() {
    RandomUserDetail(rememberNavController())
}