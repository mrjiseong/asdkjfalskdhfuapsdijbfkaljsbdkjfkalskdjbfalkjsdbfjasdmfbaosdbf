package com.example.kotlindictionary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.kotlindictionary.coustomtheme.CustomJetpackComposeTheme
import com.example.kotlindictionary.coustomtheme.CustomTheme
import com.example.kotlindictionary.coustomtheme.CustomThemeManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomJetpackComposeTheme {
                ScaffoldCompose()
            }
        }
    }
}

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

@Composable
fun DrawerSetting(navController: NavController) {

    Surface(color = CustomThemeManager.colors.backgroundColor) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .align(Alignment.Center)
            ) {
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

sealed class Screen(val route: String, val label: String, val icon: ImageVector) {
    object DestinationA : Screen("destinationA", "저장", Icons.Default.Person)
    object DestinationB : Screen("destinationB", "메뉴", Icons.Default.Menu)
}

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

@Composable
fun BottomNavigationBar(navController: NavController) {

    val destinations = listOf(Screen.DestinationA, Screen.DestinationB)

    BottomNavigation(backgroundColor = CustomThemeManager.colors.navigation) {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        destinations.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(item.icon, contentDescription = null) },
                label = { Text(text = item.label) },
                selectedContentColor = CustomThemeManager.colors.navigationItem,
                unselectedContentColor = CustomThemeManager.colors.navigationItem,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}


@Composable
fun DrawerMenu(scope: CoroutineScope, scaffoldState: ScaffoldState, navController: NavController) {

    val items = listOf(
        NavigationItem.Kotlin,
        NavigationItem.Compose
    )

    Column(
        modifier = Modifier
            .background(color = Color.White)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(color = Color.Gray),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "",
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .padding(10.dp)
            )
        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(5.dp)
        )

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { items ->
            DrawerItem(item = items, selected = currentRoute == items.route, onItemClick = {

                navController.navigate(items.route) {
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route) {
                            saveState = true
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                }

                scope.launch {
                    scaffoldState.drawerState.close()
                }

            })
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "Togi Kotlin",
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}


@Composable
fun DrawerItem(item: NavigationItem, selected: Boolean, onItemClick: (NavigationItem) -> Unit) {
    val background = if (selected) R.color.gray else android.R.color.transparent
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
        .fillMaxWidth()
        .clickable { onItemClick(item) }
        .height(45.dp)
        .background(
            colorResource(id = background)
        )
        .padding(start = 10.dp)
    ) {
        Image(
            painter = painterResource(id = item.icon),
            contentDescription = item.title,
            colorFilter = ColorFilter.tint(Color.Black),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(24.dp)
                .width(24.dp)
        )
        Spacer(modifier = Modifier.width(7.dp))
        Text(
            text = item.title,
            fontSize = 16.sp,
            color = Color.Black
        )
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "destinationB") {
        // 상단바 메뉴
        composable(NavigationItem.Compose.route) {
            JetpackCompose()
        }
        composable(NavigationItem.Kotlin.route) {
            DestinationB(navController = navController)
        }
        // 상단바 세팅
        composable("setting") { DrawerSetting(navController = navController) }
        // 북마크
        composable("destinationA") { DestinationA(navController = navController) }
        // 기본 스타트 메뉴
        composable("destinationB") { DestinationB(navController = navController) }
        // 챕터 1. 객체
        composable("destinationObject") { MyObject(navController = navController) }
        // 챕터 2. 문장 제어처리
        composable("destinationControl") { MyControl(navController = navController) }
        // 챕터 3. 함수
        composable("destinationFunction") { MyFunction(navController = navController) }
        // 챕터 4. 클래스
        composable("destinationClass") { MyClass(navController = navController) }
        // 챕터 5. 내장 자료형
        composable("destinationInType") { MyInType(navController = navController) }
        // 챕터 6. 클래스 관계 등 추가사항
        composable("destinationClassAdd") { MyClassAdd(navController = navController) }
        // 챕터 7. 컬렉션
        composable("destinationCollection") { MyCollection(navController = navController) }
        // 챕터 8. 추상 클레스, 인터페이스
        composable("destinationAbstractInterface") { MyAbstractInterface(navController = navController) }
        // 챕터 9. 함수 추가사항
        composable("destinationFunctionAdd") { MyFunctionAdd(navController = navController) }
        // 챕터 10. 위임, 확장
        composable("destinationMandateExpansion") { MyMandateExpansion(navController = navController) }
        // 챕터 11. 제네릭
        composable("destinationGeneric") { MyGeneric(navController = navController) }
        // 챕터 12. 파일 입출력과 스레드
        composable("destinationThread") { MyThread(navController = navController) }
        // 챕터 13. 코루틴
        composable("destinationCoroutine") { MyCoroutine(navController = navController) }
    }
}

// 코틀린 사전 내용 저장
@Composable
fun DestinationA(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "A",
            fontSize = 100.sp,
            fontWeight = FontWeight.ExtraBold
        )
    }
}

// 코틀린 사전 내용
@Composable
fun DestinationB(
    navController: NavController
) {
    Surface(color = CustomThemeManager.colors.backgroundColor) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .align(Alignment.Center)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll((rememberScrollState())),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "")
                    Button(
                        onClick = {
                            navController.navigate("destinationObject")
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
                        Text(text = "객체")
                    }
                    Button(
                        onClick = {
                            navController.navigate("destinationControl")
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
                        Text(text = "문장 제어처리")
                    }
                    Button(
                        onClick = {
                            navController.navigate("destinationFunction")
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
                        Text(text = "함수")
                    }
                    Button(
                        onClick = {
                            navController.navigate("destinationClass")
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
                        Text(text = "클래스")
                    }
                    Button(
                        onClick = {
                            navController.navigate("destinationInType")
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
                        Text(text = "내장자료형")
                    }
                    Button(
                        onClick = {
                            navController.navigate("destinationClassAdd")
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
                        Text(text = "클래스 관계 등 추가사항")
                    }
                    Button(
                        onClick = {
                            navController.navigate("destinationCollection")
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
                        Text(text = "컬렉션")
                    }
                    Button(
                        onClick = {
                            navController.navigate("destinationAbstractInterface")
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
                        Text(text = "추상 클래스, 인터페이스")
                    }
                    Button(
                        onClick = {
                            navController.navigate("destinationFunctionAdd")
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
                        Text(text = "함수 추가사항")
                    }
                    Button(
                        onClick = {
                            navController.navigate("destinationMandateExpansion")
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
                        Text(text = "위임, 확장")
                    }
                    Button(
                        onClick = {
                            navController.navigate("destinationGeneric")
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
                        Text(text = "제네릭")
                    }
                    Button(
                        onClick = {
                            navController.navigate("destinationThread")
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
                        Text(text = "파일 입출력과 스레드")
                    }
                    Button(
                        onClick = {
                            navController.navigate("destinationCoroutine")
                        },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = CustomThemeManager.colors.buttonBackgroundColor,
                            contentColor = CustomThemeManager.colors.buttonTextColor
                        ),
                        shape = CircleShape,
                        elevation = ButtonDefaults.elevation(0.dp, 0.dp),
                        contentPadding = PaddingValues(20.dp, 12.dp),
                        modifier = Modifier
                            .width(300.dp),
                    ) {
                        Text(text = "코루틴")
                    }
                    Text(text = "")
                    Text(text = "")
                    Text(text = "")
                    Text(text = "")
                }

                Spacer(modifier = Modifier.padding(vertical = 10.dp))

            }
        }
    }
}

// 객체
@Composable
fun MyObject(navController: NavController) {

}

// 문장 제어처리
@Composable
fun MyControl(navController: NavController) {

}

// 함수
@Composable
fun MyFunction(navController: NavController) {

}

// 클래스
@Composable
fun MyClass(navController: NavController) {

}

// 내장자료형
@Composable
fun MyInType(navController: NavController) {

}

// 클래스 관계 등 추가사항
@Composable
fun MyClassAdd(navController: NavController) {

}

// 컬렉션
@Composable
fun MyCollection(navController: NavController) {

}

// 추상 클래스, 인터페이스
@Composable
fun MyAbstractInterface(navController: NavController) {

}

// 함수 추가사항
@Composable
fun MyFunctionAdd(navController: NavController) {

}

// 위임, 확장
@Composable
fun MyMandateExpansion(navController: NavController) {

}

//제네릭
@Composable
fun MyGeneric(navController: NavController) {

}

// 파일 입출력과 스레드
@Composable
fun MyThread(navController: NavController) {

}

// 코루틴
@Composable
fun MyCoroutine(navController: NavController) {

}

@Composable
fun JetpackCompose() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "jetpack compose"
        )
    }
}



