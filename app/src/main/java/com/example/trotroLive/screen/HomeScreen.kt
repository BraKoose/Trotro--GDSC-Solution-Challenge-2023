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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trotroLive.R
import com.example.trotroLive.data.Trotro
import java.util.*

@Composable
fun HomeScreen() {
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
                    .verticalScroll(contentState)
            ) {
                Text(
                    text = "Stations near you",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 16.dp, bottom = 20.dp),
                    fontWeight = FontWeight.Bold,
                )
                StationGrid(
                    trotros = listOf(
                        Trotro(
                            stationName = "Kwame Nkrumah Circle",
                            busStops = null,
                            lastDestination = "Emena",
                            agency = "GPRTU",
                            lastUpdate = Date(),
                            image = R.drawable.station_kn_circle,
                        ),
                        Trotro(
                            stationName = "37 Station",
                            busStops = null,
                            lastDestination = "Achimota",
                            agency = "VIP",
                            lastUpdate = Date(),
                            image = R.drawable.tirtyseven
                        ),
                        Trotro(
                            stationName = "Tudu Station",
                            busStops = null,
                            lastDestination = "Mamobi",
                            agency = "UT",
                            lastUpdate = Date(),
                            image = R.drawable.tudu_station
                        ),
                    ),
                    onItemClick = { /*TODO*/ }
                )
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
fun StationGrid(trotros: List<Trotro>, onItemClick: (Trotro) -> Unit) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 16.dp),

    ) {
        items(trotros.size) { index ->
            StationCard(
                trotro = trotros[index],
                onClick = { onItemClick(trotros[index]) }
            )
        }
    }
}

@Composable
fun StationCard(trotro: Trotro, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = 8.dp,

    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = trotro.image),
                contentDescription = "Image of ${trotro.stationName}",
                modifier = Modifier
                    .size(130.dp)
            )
            Text(
                text = trotro.stationName,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text(
                text = "Last destination: ${trotro.lastDestination}",
                fontStyle = FontStyle.Italic,
                fontSize = 16.sp,
                color = Color.Blue,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Last updated: ${trotro.lastUpdate}",
                fontSize = 14.sp,
                color = Color.Blue,
                modifier = Modifier
                    .padding(bottom = 8.dp)

            )
        }
    }
}

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

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    HomeScreen()
}