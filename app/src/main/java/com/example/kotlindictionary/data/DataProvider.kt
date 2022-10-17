package com.example.kotlindictionary.data

object DataProvider {
    val chapter =
        Chapter(
            title = "",
            route = ""
        )


    val chapterList = listOf(
        Chapter(
            title = "객체",
            route = "destinationObject"
        ),
        Chapter(
            title = "문장 제어처리",
            route = "destinationControl"
        ),
        Chapter(
            title = "함수",
            route = "destinationFunction"
        ),
        Chapter(
            title = "클래스",
            route = "destinationClass"
        ),
        Chapter(
            title = "내장 자료형",
            route = "destinationInType"
        ),
        Chapter(
            title = "클래스 관계 등 추가사항",
            route = "destinationClassAdd"
        ),
        Chapter(
            title = "컬렉션",
            route = "destinationCollection"
        ),
        Chapter(
            title = "추상 클래스, 인터페이스",
            route = "destinationAbstractInterface"
        ),
        Chapter(
            title = "함수 추가사항",
            route = "destinationFunctionAdd"
        ),
        Chapter(
            title = "위임 확장",
            route = "destinationMandateExpansion"
        ),
        Chapter(
            title = "제네릭",
            route = "destinationGeneric"
        ),
        Chapter(
            title = "스레드",
            route = "destinationThread"
        ),
        Chapter(
            title = "코루틴",
            route = "destinationCoroutine"
        )
    )
}



