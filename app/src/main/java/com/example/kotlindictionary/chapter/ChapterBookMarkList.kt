package com.example.kotlindictionary.chapter

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kotlindictionary.ChapterListItem
import com.example.kotlindictionary.data.DataProvider

@Composable
fun ChapterBookMarkList(navController: NavController) {
    val chapters = remember { DataProvider.chapterList }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = chapters,
            itemContent = {
                ChapterListItem(chapter = it, navController)
            }
        )
    }
}