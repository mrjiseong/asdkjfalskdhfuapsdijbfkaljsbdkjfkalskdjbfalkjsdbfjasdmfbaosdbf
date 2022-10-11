package com.example.kotlindictionary.coustomtheme


import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

enum class CustomTheme {
    DARK, LIGHT
}

val Color2C2F33 = Color(0xFF2C2F33)
val Color7289DA = Color(0xFF7289DA)
val Color23272A = Color(0xFF23272A)
val ColorFFFFFF = Color(0xFFFFFFFF)

@Stable
class CustomColors(
    navigation: Color,
    navigationItem: Color,
    backgroundColor: Color,
    buttonBackgroundColor: Color,
    buttonTextColor: Color,
    textColor: Color
) {

    var navigation by mutableStateOf(navigation)
        private set

    var navigationItem by mutableStateOf(navigationItem)
        private set

    var backgroundColor by mutableStateOf(backgroundColor)
        private set

    var buttonBackgroundColor by mutableStateOf(buttonBackgroundColor)
        private set

    var buttonTextColor by mutableStateOf(buttonTextColor)
        private set

    var textColor by mutableStateOf(textColor)
        private set

    fun update(colors: CustomColors) {
        this.navigation = colors.navigation
        this.navigationItem = colors.navigationItem
        this.backgroundColor = colors.backgroundColor
        this.buttonBackgroundColor = colors.buttonBackgroundColor
        this.buttonTextColor = colors.buttonTextColor
        this.textColor = colors.textColor
    }

    fun copy() = CustomColors(
        navigation,
        navigationItem,
        backgroundColor,
        buttonBackgroundColor,
        buttonTextColor,
        textColor
    )
}