package com.example.myreceipe.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.myreceipe.R

val SpoqaHanSansNeo = FontFamily(
    Font(R.font.spoqahansansneo_regular, FontWeight.Normal),
    Font(R.font.spoqahansansneo_bold, FontWeight.Bold),
    Font(R.font.spoqahansansneo_light, FontWeight.Light),
    Font(R.font.spoqahansansneo_medium, FontWeight.Medium),
    Font(R.font.spoqahansansneo_thin, FontWeight.Thin),
)


val SdSamlipHopang = FontFamily(
    Font(R.font.sdsamliphopangchettfbasic, FontWeight.Normal),
    Font(R.font.sdsamliphopangchettfoutline, FontWeight.ExtraBold)
)


val Typography = Typography(
    body1 = TextStyle(
        fontFamily = SpoqaHanSansNeo,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    button = TextStyle(
        fontFamily = SpoqaHanSansNeo,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = SpoqaHanSansNeo,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )

)