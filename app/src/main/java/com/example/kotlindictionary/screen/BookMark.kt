package com.example.kotlindictionary.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kotlindictionary.chapter.ChapterBookMarkList

// 코틀린 사전 북마크
@Composable
fun DestinationA(navController: NavController) {
    Column(
        modifier = Modifier
            .padding(bottom = 60.dp)
    ) {
        Scaffold(content = {
            ChapterBookMarkList(
                navController = navController
            )
        })
    }
}