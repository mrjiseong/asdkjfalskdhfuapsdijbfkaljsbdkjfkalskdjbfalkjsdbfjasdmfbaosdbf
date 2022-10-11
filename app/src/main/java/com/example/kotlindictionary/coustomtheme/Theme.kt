package com.example.kotlindictionary.coustomtheme


import androidx.compose.material.*
import androidx.compose.runtime.*
import com.example.kotlindictionary.ui.theme.Shapes
import com.example.kotlindictionary.ui.theme.Typography


// 다크 테마 색깔
 private val CustomDarkColors = CustomColors(
     navigation = Color23272A,
     navigationItem = ColorFFFFFF,
     backgroundColor = Color2C2F33,
     buttonBackgroundColor = Color7289DA,
     buttonTextColor = ColorFFFFFF,
     textColor = ColorFFFFFF
 )

// 라이트 테마 색깔
private val CustomLightColors = CustomColors(
    navigation = ColorFFFFFF,
    navigationItem = Color23272A,
    backgroundColor = ColorFFFFFF,
    buttonBackgroundColor = Color7289DA,
    buttonTextColor = ColorFFFFFF,
    textColor = Color23272A
)

private val LocalColorsProvider = staticCompositionLocalOf {
    CustomLightColors
}

@Composable
private fun CustomLocalProvider(
    colors: CustomColors,
    content: @Composable () -> Unit
) {
    val colorPalette = remember {
        colors.copy()
    }

    colorPalette.update(colors)
    CompositionLocalProvider(LocalColorsProvider provides colorPalette, content = content)
}

private val CustomTheme.color: Pair<Colors, CustomColors>
    get() = when(this) {
        CustomTheme.DARK -> darkColors() to CustomDarkColors
        CustomTheme.LIGHT -> lightColors() to CustomLightColors
    }

object CustomThemeManager {

    val colors: CustomColors
        @Composable
        get() = LocalColorsProvider.current

    var customTheme by mutableStateOf(CustomTheme.LIGHT)

    fun isSystemInDarkTheme(): Boolean {
        return customTheme == CustomTheme.DARK
    }
}

@Composable
fun CustomJetpackComposeTheme(
    customTheme: CustomTheme = CustomThemeManager.customTheme,
    content: @Composable () -> Unit
) {
    val (colorPalette, lcColor) = customTheme.color

    CustomLocalProvider(colors = lcColor) {
        MaterialTheme(
            colors = colorPalette,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}

//@Composable
//fun FoundationsOfComposeTheme(
//    darkTheme: Boolean = isSystemInDarkTheme(),
//    content: @Composable () -> Unit
//) {
//    val colors = if (darkTheme) {
//        DarkColorPalette
//    } else {
//        LightColorPalette
//    }
//
//    MaterialTheme(
//        colors = colors,
//        typography = Typography,
//        shapes = Shapes,
//        content = content
//    )
//}