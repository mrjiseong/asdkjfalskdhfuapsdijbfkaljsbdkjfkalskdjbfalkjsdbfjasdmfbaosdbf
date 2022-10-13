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
            DestinationB(navController = navController)
        }
        // 상단바 세팅
        composable("setting") { Setting(navController = navController) }
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
