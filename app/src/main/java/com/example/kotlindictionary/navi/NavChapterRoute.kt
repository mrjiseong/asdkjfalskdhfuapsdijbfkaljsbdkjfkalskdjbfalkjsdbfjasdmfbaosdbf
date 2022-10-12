package com.example.kotlindictionary.navi

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kotlindictionary.chapter.*
import com.example.kotlindictionary.dictionaryclass.NavigationItem
import com.example.kotlindictionary.screen.DestinationA
import com.example.kotlindictionary.screen.JetpackCompose
import com.example.kotlindictionary.screen.Setting

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "destinationB") {
        // 상단바 메뉴
        composable(NavigationItem.Compose.route) {
            JetpackCompose()
        }
        composable(NavigationItem.Kotlin.route) {
       //     DestinationB(navigateProfile = )
        }
        // 상단바 세팅
        composable("setting") { Setting(navController = navController) }
        // 북마크
        composable("destinationA") { DestinationA(navController = navController) }
        // 기본 스타트 메뉴
   //     composable("destinationB") { DestinationB(navController = navController) }
    }
}
