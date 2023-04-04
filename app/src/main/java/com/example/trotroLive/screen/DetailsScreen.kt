package com.example.trotroLive.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trotroLive.data.Trotro
import com.example.trotroLive.viewmodel.DetailsViewModel


@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel = viewModel()
) {
    val trotro by viewModel.selectedTrotro.collectAsState()

    // Collect the bus stops and fare prices state from the view model
    val busStops by viewModel.busStops.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = trotro.image),
                contentDescription = trotro.stationName,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Text(
                text = trotro.stationName,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.BottomStart)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Agency: ${trotro.agency ?: ""}",
            fontStyle = FontStyle.Italic,
            fontSize = 16.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = "Last Destination: ${trotro.lastDestination}",
            fontStyle = FontStyle.Italic,
            fontSize = 16.sp,
            modifier = Modifier.padding(16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Bus Stops and Fare Prices:",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(16.dp)
        )
        busStops?.forEach { (busStop, distance) ->
            val farePrice = farePrices?.get(busStop)
            BusStopRow(busStop = busStop, distance = distance, farePrice = farePrice)
        }
    }
}