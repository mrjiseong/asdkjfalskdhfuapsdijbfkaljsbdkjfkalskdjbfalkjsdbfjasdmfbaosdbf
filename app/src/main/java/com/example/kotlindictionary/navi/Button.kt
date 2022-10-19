package com.example.kotlindictionary.navi


import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kotlindictionary.chapter.ChapterList

// 코틀린 사전 내용
@Composable
fun DestinationB(navController: NavController) {
    Column(
        modifier = Modifier
            .padding(bottom = 60.dp)
    ) {
        Scaffold(content = {
            ChapterList(navController = navController)
        })
    }
}