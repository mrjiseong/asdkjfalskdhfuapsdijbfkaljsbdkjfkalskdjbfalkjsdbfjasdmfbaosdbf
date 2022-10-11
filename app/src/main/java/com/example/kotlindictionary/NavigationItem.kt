package com.example.kotlindictionary

sealed class NavigationItem(var route: String, var icon: Int, var title: String)
{
    object Kotlin : NavigationItem("kotlin",R.drawable.ic_launcher_foreground,"Kotlin")
    object Compose : NavigationItem("compose",R.drawable.ic_launcher_foreground,"Compose")
}