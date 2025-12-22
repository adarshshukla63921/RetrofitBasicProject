package com.seenu.learningretrofit.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.SubcomposeAsyncImage
import com.seenu.learningretrofit.domain.model.User

@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = hiltViewModel()
){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SubcomposeAsyncImage(
            model = viewModel._state.value.user?.avatar,
            modifier = Modifier.clip(CircleShape).size(100.dp),
            contentDescription = "Avatar Image",
            alignment = Alignment.Center,
            loading = {
                CircularProgressIndicator(
                    modifier = Modifier.size(5.dp)
                )
            },
            error = {Text(text = "")}
        )
        val user : User? = viewModel._state.value.user
        Text(text = "Not so much made UI.")
        Text(text = "Name : ${user?.name}")
        Text(text = "Username : ${user?.username}")
        Text(text = "Location : ${user?.location?.city} , ${user?.location?.country}")
        Text(text = "Followers : ${user?.statistics?.followers}")
        Text(text = "Following : ${user?.statistics?.following}")
        Text(text = "Posts : ${user?.statistics?.activity?.shots}")

    }
}