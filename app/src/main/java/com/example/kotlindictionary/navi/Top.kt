package com.example.kotlindictionary.navi

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.kotlindictionary.coustomtheme.CustomThemeManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

// 상단 바
@Composable
fun TopAppBarCompose(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    navController: NavController
) {

    TopAppBar(
        title = {
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "코틀린 사전",
                    modifier = Modifier
                        .align(alignment = Alignment.Center)
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            }
            ) {
                Icon(Icons.Filled.Menu, "")
            }
        },
        actions = {
            IconButton(onClick = {
                navController.navigate("setting")
                scope.launch {

                }
            }) {
                Icon(Icons.Filled.Settings, "")
            }
        },
        backgroundColor = CustomThemeManager.colors.navigation,
        contentColor = CustomThemeManager.colors.navigationItem
    )
}
