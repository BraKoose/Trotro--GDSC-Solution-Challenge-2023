package com.example.trotroLive.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trotroLive.R
import com.example.trotroLive.data.Trotro
import com.example.trotroLive.viewmodel.TrotroViewModel
import androidx.compose.runtime.livedata.observeAsState

@Composable
fun HomeScreen(trotroViewModel: TrotroViewModel, trotros: List<Trotro>?) {
    val trotroList by trotroViewModel.trotros.observeAsState(listOf())

    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Open))
    val contentState = remember{ ScrollState(0)}

    Scaffold(
        scaffoldState = scaffoldState,
        //TOPbAR of HOME Screen - With Profile Picture and Welcome TExt
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column {
                    Text(text = "Welcome back,", fontSize = 16.sp, color = Color.Blue)
                    Text(text = "Godfred Addai", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                }

                Box {
                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "This is a profile picture",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(55.dp)
                            .clip(RoundedCornerShape(50.dp))
                    )

                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .border(border = BorderStroke(3.dp, color = Color.Black))
                            .background(Color.Black)
                            .align(alignment = Alignment.BottomStart),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "2",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp,
                            modifier = Modifier
                                .padding(3.dp)
                        )

                    }
                }
            }
        },

        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 2.dp),
                backgroundColor = colorResource(id = R.color.primary)
            ) {
                BottomNavigationItem(
                    selected = true, onClick = { /*TODO*/ }, icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Home Icon"
                        )
                    }
                )

                BottomNavigationItem(
                    selected = false, onClick = { /*TODO*/ }, icon = {
                        Icon(
                            imageVector = Icons.Outlined.AccountBox,
                            contentDescription = "Home Icon"
                        )
                    }
                )

                BottomNavigationItem(
                    selected = false, onClick = { /*TODO*/ }, icon = {
                        Icon(
                            imageVector = Icons.Outlined.Settings,
                            contentDescription = "Home Icon"
                        )
                    }
                )
            }
        },
        content =  {

            Column(
                modifier = Modifier
                    .padding(16.dp)
                 //   .verticalScroll(contentState)
            ) {
                Text(
                    text = "Stations near you",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 16.dp, bottom = 20.dp),
                    fontWeight = FontWeight.Bold,
                )
                LazyColumn {
                  items(trotroList) { trotro ->
                TrotroCard(trotro)
            }
        }
                Text(
                    text = "Search for your trotro route",
                    fontSize = 15.sp,
                    modifier = Modifier.padding(start = 16.dp, bottom = 20.dp),
                    fontWeight = FontWeight.Bold
                )
                // Recycler View
                Column(modifier = Modifier.fillMaxHeight(1f), verticalArrangement = Arrangement.spacedBy(20.dp),
                ){
                    SearchBar()
                    TrotroIntroduction()


                }

            }
        } ,
        backgroundColor = colorResource(id = R.color.white)

    )
}


@Composable
fun TrotroCard(trotro: Trotro) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = trotro.stationName,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = trotro.lastDestination,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = trotro.agency ?: "",
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = trotro.lastUpdate.toString(),
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Image(
                painter = painterResource(id = trotro.image),
                contentDescription = "Trotro Image",
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun TrotroListItem(trotro: Trotro) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .clickable { /* navigate to trotro detail screen */ }
                .padding(16.dp)
        ) {
            Text(text = trotro.stationName, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text(text = trotro.lastDestination, fontWeight = FontWeight.Normal, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = trotro.image),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}


//@Composable
//fun HomeScreen() {
//
//    Column {
//        Text(
//            text = "Trotros",
//            fontSize = 20.sp,
//            fontWeight = FontWeight.Bold,
//            textAlign = TextAlign.Center,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 16.dp)
//        )
//        LazyColumn {
//            items(trotros) { trotro ->
//                TrotroCard(trotro)
//            }
//        }
//    }
//
//}



@Composable
fun SearchBar() {
    val textState = remember { mutableStateOf(TextFieldValue()) }
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clip(RoundedCornerShape(20.dp)),
        value = textState.value,
        onValueChange = { textState.value = it },
        leadingIcon = {
            Icon(imageVector = Icons.Filled.Search, contentDescription = "Search Icon")
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Blue,
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        placeholder = {
            Text(text = "Enter station or route name", color = Color.LightGray, fontSize = 16.sp)
        }

    )
}

@Composable
fun TrotroIntroduction() {
    Text(
        text = "Know Your Fare",
        style = MaterialTheme.typography.h6,
        color = Color.Black,
        modifier = Modifier.padding(vertical = 8.dp)

    )

    Text(
        text = "Using Trotro Live helps you avoid fights with your trotro mate. No more wahala! 🚍😎",
        style = MaterialTheme.typography.body2,
        color = Color.Blue,
        modifier = Modifier.padding(top = 16.dp)
    )
}

//@Composable
//@Preview(showBackground = true)
//fun HomeScreenPreview() {
//    HomeScreen()
//}