package com.example.kotlindictionary.chapter

import android.annotation.SuppressLint
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
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
import com.example.kotlindictionary.data.ListRepository.Companion.data


// 객체
@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun MyObject(
    navController: NavController,
    chapter: Chapter
) {
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
            text = "객체",
            fontSize = 100.sp,
            fontWeight = FontWeight.ExtraBold
        )
        val checkedState = remember { mutableStateOf(chapter.bookMark) }
        IconToggleButton(
            checked = checkedState.value,
            onCheckedChange = {
//            chapter.bookMark = !chapter.bookMark
//            checkedState.value = !checkedState.value
//            data.add(Chapter("객체", "destinationObject", true))
//            println("북마크: " + ListRepository.data.size + "개")
//            data.removeAll(arrayOf(Chapter("객체","destinationObject",true)))

                if (
                    ((!chapter.bookMark).also {
                        chapter.bookMark = it
                    }).also { (!checkedState.value).also { checkedState.value = it } }
                ) {
                    //북마크 버튼이 체크가 됐을때
                    data.add(Chapter(1,"객체", "destinationObject", true))
                    println("북마크 수: " + data.size)
                } else {
                    //북마크 버튼이 체크가 해제 됐을때
                    data.removeAt(chapter.id)
                    println("북마크 수: " + data.size)
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