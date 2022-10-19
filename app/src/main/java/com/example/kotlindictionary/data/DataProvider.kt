package com.example.kotlindictionary.data

object DataProvider {
    val chapter =
        Chapter(
            id = 0,
            title = "",
            route = "",
            bookMark = false
        )


    val chapterList = mutableListOf(
        Chapter(
            id = 1,
            title = "객체",
            route = "destinationObject",
            bookMark = false
        ),
        Chapter(
            id = 2,
            title = "문장 제어처리",
            route = "destinationControl",
            bookMark = false
        ),
        Chapter(
            id = 3,
            title = "함수",
            route = "destinationFunction",
            bookMark = false
        ),
        Chapter(
            id = 4,
            title = "클래스",
            route = "destinationClass",
            bookMark = false
        ),
        Chapter(
            id = 5,
            title = "내장 자료형",
            route = "destinationInType",
            bookMark = false
        ),
        Chapter(
            id = 6,
            title = "클래스 관계 등 추가사항",
            route = "destinationClassAdd",
            bookMark = false
        ),
        Chapter(
            id = 7,
            title = "컬렉션",
            route = "destinationCollection",
            bookMark = false
        ),
        Chapter(
            id = 8,
            title = "추상 클래스, 인터페이스",
            route = "destinationAbstractInterface",
            bookMark = false
        ),
        Chapter(
            id = 9,
            title = "함수 추가사항",
            route = "destinationFunctionAdd",
            bookMark = false
        ),
        Chapter(
            id = 10,
            title = "위임 확장",
            route = "destinationMandateExpansion",
            bookMark = false
        ),
        Chapter(
            id = 11,
            title = "제네릭",
            route = "destinationGeneric",
            bookMark = false
        ),
        Chapter(
            id = 12,
            title = "스레드",
            route = "destinationThread",
            bookMark = false
        ),
        Chapter(
            id = 13,
            title = "코루틴",
            route = "destinationCoroutine",
            bookMark = false
        )
    )
}



