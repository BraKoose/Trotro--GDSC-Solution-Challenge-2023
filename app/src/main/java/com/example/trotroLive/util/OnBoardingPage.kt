package com.example.trotroLive.util

import androidx.annotation.DrawableRes
import com.example.trotroLive.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
) {
    object First : OnBoardingPage(
        image = R.drawable.ghanafirst,
        title = "Know Your Trotro Fares",
        description = "You can search any place nearby or with-in the specified city. We will display specific or all related trotro Fares to match your bus stops."
    )

    object Second : OnBoardingPage(
        image = R.drawable.honestdriver,
        title = "Report On Missing Items?",
        description = "We provide almost all the numbers of all stations and landmarks registered with us. You can easily redeem found items as well."
    )

    object Third : OnBoardingPage(
        image = R.drawable.chosenone,
        title = "DigiLogic Smart Logistics Winner Eu Funded Project",
        description = "If you have a station or have fleet of Minivans a part of our growing industry with (EU, GPRTU, AMA, Google) then add your profile by following simple steps."
    )
}
