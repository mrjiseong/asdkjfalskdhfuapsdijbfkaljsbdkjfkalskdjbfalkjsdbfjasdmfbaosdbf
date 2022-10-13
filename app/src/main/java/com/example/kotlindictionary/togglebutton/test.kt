package com.example.kotlindictionary.togglebutton

import android.annotation.SuppressLint
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// on below line we are creating a function
// to get current date and time.
@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun displayToggleButton() {

    // in below line we are setting
    // the state of our checkbox.
    val checkedState = remember { mutableStateOf(false) }

    // on below line we are creating a column on below sides.
    Column(
        // on below line we are adding padding
        // padding for our column and filling the max size.
        Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .fillMaxWidth(),
        // on below line we are adding
        // horizontal alignment for our column
        horizontalAlignment = Alignment.CenterHorizontally,
        // on below line we are adding
        // vertical arrangement for our column
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            // on below line we are specifying
            // text to display.
            text = "Toggle Button in Android",

            // on below line we are specifying
            // modifier to fill max width.
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),

            // on below line we are specifying
            // text alignment.
            textAlign = TextAlign.Center,

            // on below line we are specifying
            // color for our text.
            color = Color.Black,

            // on below line we are
            // specifying font weight
            fontWeight = FontWeight.Bold,

            // on below line we
            // are updating font size.
            fontSize = 25.sp,
        )

        // on below line we are creating a spacer.
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            // on below line we are specifying text to display.
            text = if (checkedState.value) "Like" else "Dis Like",

            // on below line we are specifying
            // modifier to fill max width.
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),

            // on below line we are
            // specifying text alignment.
            textAlign = TextAlign.Center,

            // on below line we are
            // specifying color for our text.
            color = Color.Black,

            // on below line we are
            // specifying font weight
            fontWeight = FontWeight.Bold,

            // on below line we
            // are updating font size.
            fontSize = 25.sp,
        )

        // on below line we are creating a spacer.
        Spacer(modifier = Modifier.height(20.dp))

        // on below line we are creating icon toggle button.
        IconToggleButton(
            // on below line we are
            // specifying default check state
            checked = checkedState.value,
            // on below line we are adding on check change
            onCheckedChange = {
                checkedState.value = !checkedState.value
            },
            // on below line we are adding a padding
            modifier = Modifier.padding(10.dp)
        ) {
            // on below line we are creating a
            // variable for our transition
            val transition = updateTransition(checkedState.value)

            // on below line we are creating a variable for
            // color of our icon
            val tint by transition.animateColor(label = "iconColor") { isChecked ->
                // if toggle button is checked we are setting color as red.
                // in else condition we are setting color as black
                if (isChecked) Color.Green else Color.Black
            }

            // om below line we are specifying transition
            val size by transition.animateDp(
                transitionSpec = {
                    // on below line we are specifying transition
                    if (false isTransitioningTo true) {
                        // on below line we are specifying key frames
                        keyframes {
                            // on below line we are specifying animation duration
                            durationMillis = 250
                            // on below line we are specifying animations.
                            30.dp at 0 with LinearOutSlowInEasing // for 0-15 ms
                            35.dp at 15 with FastOutLinearInEasing // for 15-75 ms
                            40.dp at 75 // ms
                            35.dp at 150 // ms
                        }
                    } else {
                        spring(stiffness = Spring.StiffnessVeryLow)
                    }
                },
                label = "Size"
            ) { 30.dp }

            // on below line we are creating icon for our toggle button.
            Icon(
                // on below line we are specifying icon for our image vector.
                imageVector = if (checkedState.value) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                contentDescription = "Icon",
                // on below line we are specifying
                // tint for our icon.
                tint = tint,
                // on below line we are specifying
                // size for our icon.
                modifier = Modifier.size(size)
            )
        }
    }
}