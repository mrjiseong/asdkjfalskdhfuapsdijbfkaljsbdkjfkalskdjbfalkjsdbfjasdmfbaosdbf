package com.example.kotlindictionary

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kotlindictionary.coustomtheme.CustomThemeManager
import com.example.kotlindictionary.data.Chapter

@Composable
fun ChapterListItem(
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
                Text(text = "${chapter.title}", style = typography.h6)
                Text(text = "클릭하여 보기", style = typography.caption)
            }
        }
    }
}

@Preview
@Composable
fun ChapterListItemPreview(){
    ChapterListItem(chapter = Chapter("","",false), navController = rememberNavController())
}