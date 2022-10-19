package com.example.kotlindictionary

import com.example.kotlindictionary.data.Chapter


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kotlindictionary.coustomtheme.CustomThemeManager


@Composable
fun ChapterBookMarkListItem(
    chapter: Chapter,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 50.dp, vertical = 5.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
        backgroundColor = CustomThemeManager.colors.buttonBackgroundColor,
        shape = RoundedCornerShape(corner = CornerSize(20.dp))
    ) {
        Row(
            Modifier.clickable { navController.navigate("${chapter.route}") }
        ) {
            Column(
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = "${chapter.title}", style = MaterialTheme.typography.h6)
                Text(text = "클릭하여 보기", style = MaterialTheme.typography.caption)
            }
        }
    }
}

@Preview
@Composable
fun ChapterBookMarkListItemPreview(){
    ChapterListItem(chapter = Chapter(1,"객체","경로",false), navController = rememberNavController())
}