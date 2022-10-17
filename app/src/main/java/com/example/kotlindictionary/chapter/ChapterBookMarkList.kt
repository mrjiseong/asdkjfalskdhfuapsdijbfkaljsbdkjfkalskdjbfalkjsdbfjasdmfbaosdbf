package com.example.kotlindictionary.chapter

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kotlindictionary.ChapterListItem
import com.example.kotlindictionary.data.ListRepository

@Composable
fun ChapterBookMarkList(navController: NavController) {
    val chapters = remember { ListRepository().getAllData() }
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

@Preview
@Composable
fun ChapterBookMarkListPreview() {
    ChapterBookMarkList(navController = rememberNavController())
}