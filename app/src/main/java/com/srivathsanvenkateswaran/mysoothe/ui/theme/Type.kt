package com.srivathsanvenkateswaran.mysoothe.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.srivathsanvenkateswaran.mysoothe.R

private val KulimParkLight = FontFamily(Font(R.font.kulim_park_light))
private val KulimParkRegular = FontFamily(Font(R.font.kulim_park_regular))
private val LatoBold = FontFamily(Font(R.font.lato_bold))
private val LatoRegular = FontFamily(Font(R.font.lato_regular))

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = KulimParkLight,
        letterSpacing = 1.15.sp,
        fontSize = 28.sp
    ),
    h2 = TextStyle(
        fontFamily = KulimParkRegular,
        letterSpacing = 1.15.sp,
        fontSize = 15.sp,

    ),
    h3 = TextStyle(
        fontFamily = LatoBold,
        letterSpacing = 0.sp,
        fontSize = 14.sp
    ),
    body1 = TextStyle(
        fontFamily = LatoRegular,
        letterSpacing = 0.sp,
        fontSize = 14.sp
    ),
    button = TextStyle(
        fontFamily = LatoBold,
        letterSpacing = 1.15.sp,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = KulimParkRegular,
        letterSpacing = 1.15.sp,
        fontSize = 12.sp
    ),
)