package com.example.kotlindictionary.chapter

import android.annotation.SuppressLint
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
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
import com.example.kotlindictionary.data.Chapter
import com.example.kotlindictionary.data.DataProvider
import com.example.kotlindictionary.data.ListRepository
import kotlin.random.Random

// 객체
@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun MyObject(
    navController: NavController
) {
    val checkedState = remember { mutableStateOf(false) }

    val holder = remember {
        ListRepository().getAllData().toMutableStateList()
    }
    val key2 = remember {
        mutableStateOf(1)
    }

    IconToggleButton(
        checked = checkedState.value,
        onCheckedChange = {
            checkedState.value = !checkedState.value
            holder.add(Chapter("객체","경로"))
            key2.value++

            println(ListRepository().getAllData().size)
                          },
        modifier = Modifier.padding(10.dp)) {


        val transition = updateTransition(checkedState.value)
        val tint by transition.animateColor(label = "iconColor") { isChecked ->
            if (isChecked) Color.Red else Color.Black
        }
        val size by transition.animateDp(
            transitionSpec = {
                if (false isTransitioningTo true) {
                    keyframes {
                        durationMillis = 250
                        30.dp at 0 with LinearOutSlowInEasing // for 0-15 ms

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
    }
}