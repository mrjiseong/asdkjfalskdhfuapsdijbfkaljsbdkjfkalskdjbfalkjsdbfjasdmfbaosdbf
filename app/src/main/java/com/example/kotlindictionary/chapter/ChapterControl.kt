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

// 문장 제어처리
@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun MyControl(navController: NavController, chapterList: Chapter) {
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
            text = "문장 제어처리",
            fontSize = 100.sp,
            fontWeight = FontWeight.ExtraBold
        )
        val checkedState = remember { mutableStateOf(chapterList.bookMark) }
        IconToggleButton(
            checked = checkedState.value,
            onCheckedChange = {
                if (
                    ((!chapterList.bookMark).also {
                        chapterList.bookMark = it
                    }).also { (!checkedState.value).also { checkedState.value = it } }
                ) {
                    //북마크 버튼이 체크가 됐을때
                    ListRepository.data.add(Chapter(2, "문장 제어처리", "destinationControl", true, 0))
                    println("북마크 수: " + ListRepository.data.size)
                } else {
                    //북마크 버튼이 체크가 해제 됐을때
                    ListRepository.data.removeAt(chapterList.remove)
                    println("북마크 수: " + ListRepository.data.size)
                }

            },
            modifier = Modifier.padding(10.dp)
        ) {
            val transition = updateTransition(checkedState.value)
            val tint by transition.animateColor(label = "iconColor") { isChecked ->
                if (isChecked) Color.Red else CustomThemeManager.colors.textColor
            }
            val size by transition.animateDp(
                transitionSpec = {
                    if (false isTransitioningTo true) {
                        keyframes {
                            durationMillis = 250
                            30.dp at 0 with LinearOutSlowInEasing
                            durationMillis = 250
                            30.dp at 0 with LinearOutSlowInEasing
                            35.dp at 15 with FastOutLinearInEasing
                            40.dp at 75
                            35.dp at 150
                        }
                    } else {
                        spring(stiffness = Spring.StiffnessVeryLow)
                    }
                },
                label = "Size"
            ) { 30.dp }
            Icon(
                imageVector = if (checkedState.value) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                contentDescription = "Icon",
                tint = tint,
                modifier = Modifier.size(size)
            )
        }
    }
}