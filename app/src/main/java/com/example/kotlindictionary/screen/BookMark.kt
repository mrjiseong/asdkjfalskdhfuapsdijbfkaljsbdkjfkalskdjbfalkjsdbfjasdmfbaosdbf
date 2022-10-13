package com.example.kotlindictionary.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kotlindictionary.chapter.ChapterBookMarkList
import com.example.kotlindictionary.chapter.ChapterList
import com.example.kotlindictionary.data.Chapter

// 코틀린 사전 북마크
@Composable
fun DestinationA(navController: NavController) {
    Column(
        modifier = Modifier
            .padding(bottom = 60.dp)
    ) {
        Scaffold(content = {
            ChapterBookMarkList(navController = navController,)
        })
    }
}