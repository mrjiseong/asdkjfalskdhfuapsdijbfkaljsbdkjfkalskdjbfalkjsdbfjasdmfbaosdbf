package com.example.kotlindictionary.data

object DataProvider {
    val chapter =
        Chapter(
            title = "",
            route = "",
            bookMark = false
        )


    val chapterList = listOf(
        Chapter(
            title = "객체",
            route = "destinationObject",
            bookMark = false
        ),
        Chapter(
            title = "문장 제어처리",
            route = "destinationControl",
            bookMark = false
        ),
        Chapter(
            title = "함수",
            route = "destinationFunction",
            bookMark = false
        ),
        Chapter(
            title = "클래스",
            route = "destinationClass",
            bookMark = false
        ),
        Chapter(
            title = "내장 자료형",
            route = "destinationInType",
            bookMark = false
        ),
        Chapter(
            title = "클래스 관계 등 추가사항",
            route = "destinationClassAdd",
            bookMark = false
        ),
        Chapter(
            title = "컬렉션",
            route = "destinationCollection",
            bookMark = false
        ),
        Chapter(
            title = "추상 클래스, 인터페이스",
            route = "destinationAbstractInterface",
            bookMark = false
        ),
        Chapter(
            title = "함수 추가사항",
            route = "destinationFunctionAdd",
            bookMark = false
        ),
        Chapter(
            title = "위임 확장",
            route = "destinationMandateExpansion",
            bookMark = false
        ),
        Chapter(
            title = "제네릭",
            route = "destinationGeneric",
            bookMark = false
        ),
        Chapter(
            title = "스레드",
            route = "destinationThread",
            bookMark = false
        ),
        Chapter(
            title = "코루틴",
            route = "destinationCoroutine",
            bookMark = false
        )
    )
}



