package com.example.kotlindictionary.chapter

import android.annotation.SuppressLint
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.IconToggleButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kotlindictionary.coustomtheme.CustomThemeManager
import com.example.kotlindictionary.data.Chapter
import com.example.kotlindictionary.data.ListRepository

// 파일 입출력과 스레드
@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun MyThread(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        IconButton(
            modifier = Modifier
                .then(
                    Modifier
                        .size(50.dp)
                )
                .fillMaxWidth(),
            onClick = { navController.popBackStack() },
        ) {
            Icon(
                Icons.Filled.ArrowBack,
                "contentDescription",
                tint = CustomThemeManager.colors.textColor
            )
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "파일 입출력과 스레드",
            fontSize = 100.sp,
            fontWeight = FontWeight.ExtraBold
        )
    }
}