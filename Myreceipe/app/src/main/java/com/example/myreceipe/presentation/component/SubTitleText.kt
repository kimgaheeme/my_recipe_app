package com.example.myreceipe.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myreceipe.ui.theme.Gray700
import com.example.myreceipe.ui.theme.SpoqaHanSansNeo

@Composable
fun SubTitleText(text: String, bottomPadding : Dp = 10.dp) {
    Text(
        text,
        fontFamily = SpoqaHanSansNeo,
        fontWeight = FontWeight.Medium,
        color = Gray700,
        fontSize = 16.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 35.dp, bottom = bottomPadding)
    )
}