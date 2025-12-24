package com.seenu.learningretrofit.presentation


import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.SubcomposeAsyncImage
import com.seenu.learningretrofit.R
import com.seenu.learningretrofit.domain.model.User

@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = hiltViewModel()
){
    val user : User? = viewModel._state.value.user
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NameCard(user = user)
        Spacer(modifier = Modifier.padding(8.dp))
        SocialCard(user = user)
    }
}



@Composable
fun NameCard(user : User?){
    Surface(
        modifier = Modifier.fillMaxWidth(0.99f).padding(5.dp),
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 10.dp
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(0.95f).padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.padding(3.dp)
            ) {
                Text(text = user?.name ?:"", modifier = Modifier.padding(horizontal = 8.dp))
                Text(text = user?.username ?:"", modifier = Modifier.padding(horizontal = 8.dp))
                Spacer(modifier = Modifier.padding(vertical = 4.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = "Location",
                        modifier = Modifier.padding(horizontal = 5.dp).size(30.dp)
                    )
                    Column {
                        Text(text = "Location", style = MaterialTheme.typography.bodyMedium)
                        Text(text = "${user?.location?.city} , ${user?.location?.country}")
                    }
                }
            }
            SubcomposeAsyncImage(
                model = user?.avatar,
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
        }
    }
}

@Composable
fun SocialCard(user : User?){
    Surface(
        modifier = Modifier.fillMaxWidth(0.99f).padding(5.dp),
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 10.dp
    ) {
        val context = LocalContext.current
        Column(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            //horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Social Media",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold
                )
            }
            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant
                ){

                    Text(text = "Followers : ${user?.statistics?.followers}" ,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(8.dp)
                    )
                    Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                }
                Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant
                ){

                    Text(text = "Following : ${user?.statistics?.following}" ,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(8.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant
                ){

                    Text(text = "Shots : ${user?.statistics?.activity?.shots}" ,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.padding(vertical = 5.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().clickable{
                    val url = user?.social?.website
                    if(!url.isNullOrEmpty()){
                        val intent = Intent(Intent.ACTION_VIEW, url.toUri())
                        context.startActivity(intent)
                    }
                }
            ){
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Website",
                    modifier = Modifier.padding(horizontal = 5.dp).size(30.dp)
                )
                Column {
                    Text(text = "Website",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold)
                    Text(text = "${user?.social?.website}")
                }
            }
            Spacer(modifier = Modifier.padding(vertical = 5.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().clickable{
                    val url = user?.social?.profiles[0]?.url
                    if(!url.isNullOrEmpty()){
                        val intent = Intent(Intent.ACTION_VIEW, url.toUri())
                        context.startActivity(intent)
                    }
                }
            ){
                Icon(
                    painter = painterResource(R.drawable.u_instagram),
                    contentDescription = "Instagram",
                    modifier = Modifier.padding(horizontal = 5.dp).size(30.dp)
                )
                Column {
                    Text(text = "Website",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold)
                    Text(text = "${user?.social?.website}")
                }
            }
            Spacer(modifier = Modifier.padding(vertical = 5.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().clickable{
                    val url = user?.social?.profiles[1]?.url
                    if(!url.isNullOrEmpty()){
                        val intent = Intent(Intent.ACTION_VIEW, url.toUri())
                        context.startActivity(intent)
                    }
                }
            ){
                Icon(
                    painter = painterResource(R.drawable.fb2000),
                    contentDescription = "Facebook",
                    modifier = Modifier.padding(horizontal = 5.dp).size(30.dp)
                )
                Column{
                    Text(text = "${user?.social?.profiles[1]?.platform}",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold)
                    Text(text = "${user?.social?.profiles[1]?.url}")
                }
            }
        }

    }
}