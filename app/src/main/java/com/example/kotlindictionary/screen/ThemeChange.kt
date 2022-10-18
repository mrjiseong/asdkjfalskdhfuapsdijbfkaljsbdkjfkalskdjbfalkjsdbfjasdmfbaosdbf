package com.example.kotlindictionary.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kotlindictionary.CustomToggleButton
import com.example.kotlindictionary.coustomtheme.CustomTheme
import com.example.kotlindictionary.coustomtheme.CustomThemeManager

@Composable
fun Setting(navController: NavController) {


    Surface(color = CustomThemeManager.colors.backgroundColor) {

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



        Box(modifier = Modifier.fillMaxSize()) {


            Column(
                modifier = Modifier
                    .align(Alignment.Center)
            ) {
                CustomToggleButton()
                Button(
                    onClick = {
                        CustomThemeManager.customTheme =
                            if (CustomThemeManager.customTheme == CustomTheme.DARK) {
                                CustomTheme.LIGHT
                            } else {
                                CustomTheme.DARK
                            }
                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = CustomThemeManager.colors.buttonBackgroundColor,
                        contentColor = CustomThemeManager.colors.buttonTextColor
                    ),
                    shape = CircleShape,
                    elevation = ButtonDefaults.elevation(0.dp, 0.dp),
                    contentPadding = PaddingValues(20.dp, 12.dp),
                    modifier = Modifier
                        .width(300.dp)
                ) {
                    Text(text = "테마 변경")
                }

                Spacer(modifier = Modifier.padding(vertical = 10.dp))

                Text(
                    text = "현재 ${
                        if (CustomThemeManager.isSystemInDarkTheme()) {
                            "다크모드"

                        } else {
                            "라이트모드"
                        }
                    } 입니다.",
                    color = CustomThemeManager.colors.textColor
                )
            }
        }
    }
}
