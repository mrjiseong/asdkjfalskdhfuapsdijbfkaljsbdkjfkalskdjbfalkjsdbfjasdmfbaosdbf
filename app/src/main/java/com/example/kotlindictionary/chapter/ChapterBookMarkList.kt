package com.example.kotlindictionary.chapter

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kotlindictionary.ChapterBookMarkListItem
import com.example.kotlindictionary.data.Chapter
import com.example.kotlindictionary.data.ListRepository

@Composable
fun ChapterBookMarkList(navController: NavController) {
    val chapters = remember { ListRepository.data.toMutableStateList() }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(chapters) { chapters ->
            ChapterBookMarkListItem(chapter = chapters, navController = navController)
        }
    }
}

@Preview
@Composable
fun ChapterBookMarkListPreview() {
    ChapterBookMarkList(navController = rememberNavController())
}