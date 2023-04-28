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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.trotroLive.data.BusStop
import java.util.*

@Composable
fun HomeScreen(trotroViewModel: TrotroViewModel, trotros: List<Trotro>?) {
    val trotroList by trotroViewModel.trotros.observeAsState(listOf())

    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Open))

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
                backgroundColor = (MaterialTheme.colors.primary)
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
                    .padding(paddingValues = it)
                    .padding(start = 16.dp)
                    .fillMaxSize()
                ) {

                SearchBar()

                Text(
                    text = "Stations near you",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 16.dp, bottom = 20.dp),
                    fontWeight = FontWeight.Bold,
                )


                //Rccycle View Trotro Station Near You


                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    item{
                        TrotroListItem(Trotro(
                            "Kwame Nkrumah Circle",
                            BusStop("Kaneshie", "Odorkor", 10 to "GHS"),
                            "Circle",
                            "GPRTU",
                            Date(),
                            R.drawable.tudu_station
                        ),
                        )
                    }
                  items(trotroList) { trotro ->
                TrotroListItem(trotro)
            }
        }

                Spacer(modifier = Modifier.height(20.dp))



                Text(
                    text = "Popular routes",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 16.dp, bottom = 20.dp),
                    fontWeight = FontWeight.Bold,
                )

                // Recycle View Popular Routes make scrollable and clickable
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                ) {
                    items(trotroList) { trotro ->
                        PopularRouteListItem(trotro)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }


            }
        } ,
        backgroundColor = colorResource(id = R.color.white)

    )
}


@Composable
fun TrotroListItem(trotro: Trotro) {
    Box(
        modifier = Modifier
            .width(width = 190.dp)
            .padding(start = 16.dp)
            .drawBehind {
                drawRoundRect(
                    color = Color.Gray,
                    style = Stroke(
                        width = 2f,
                        pathEffect = PathEffect.dashPathEffect(
                            floatArrayOf(10f, 10f),
                            0f
                        )
                    ),
                    cornerRadius = CornerRadius(8.dp.toPx())
                )
            },
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = trotro.stationName,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Text(
                text = trotro.lastDestination,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}


@Composable
fun PopularRouteListItem(trotro: Trotro) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* TODO */ },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = trotro.image),
            contentDescription = "Trotro Station",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(10.dp))
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp)
        ) {
            Text(
                text = trotro.stationName,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = trotro.busStops.toString(),
                fontSize = 14.sp,
                color = Color.Gray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            trotro.agency?.let {
                Text(
                    text = it,
                    fontSize = 14.sp,
                    color = Color.Gray,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
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
            Text(text = "Try to find...", color = Color.Blue, fontSize = 16.sp)
        }

    )
}
@Composable
@Preview
fun searchPreview(){
    SearchBar()
}




@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    HomeScreen(
        trotroViewModel = TrotroViewModel(),
        trotros = TrotroViewModel().trotros.value
    )
}