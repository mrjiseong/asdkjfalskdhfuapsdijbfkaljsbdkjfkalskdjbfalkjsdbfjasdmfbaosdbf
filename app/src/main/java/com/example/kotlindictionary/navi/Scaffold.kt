package com.example.kotlindictionary.navi

import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kotlindictionary.DrawerMenu
import com.example.kotlindictionary.chapter.ChapterBookMarkList
import com.example.kotlindictionary.data.Chapter

//TopBar
@Composable
fun ScaffoldCompose() {

    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopAppBarCompose(scope = scope, scaffoldState = scaffoldState, navController) },
        bottomBar = { BottomNavigationBar(navController) },
        drawerContent = {
            DrawerMenu(scope = scope, scaffoldState = scaffoldState, navController = navController)
        }
    ) {
        Navigation(navController = navController)
    }
}

