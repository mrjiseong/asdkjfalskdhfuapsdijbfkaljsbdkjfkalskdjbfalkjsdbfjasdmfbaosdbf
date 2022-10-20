package com.example.kotlindictionary.data

object DataProvider {

    val chapterList = mutableListOf(
        Chapter(
            id = 1,
            title = "객체",
            route = "destinationObject",
            bookMark = false,
            remove = 0
        ),
        Chapter(
            id = 2,
            title = "문장 제어처리",
            route = "destinationControl",
            bookMark = false,
            remove = 0
        ),
        Chapter(
            id = 3,
            title = "함수",
            route = "destinationFunction",
            bookMark = false,
            remove = 0
        ),
        Chapter(
            id = 4,
            title = "클래스",
            route = "destinationClass",
            bookMark = false,
            remove = 0
        ),
        Chapter(
            id = 5,
            title = "내장 자료형",
            route = "destinationInType",
            bookMark = false,
            remove = 0
        ),
        Chapter(
            id = 6,
            title = "클래스 관계 등 추가사항",
            route = "destinationClassAdd",
            bookMark = false,
            remove = 0
        ),
        Chapter(
            id = 7,
            title = "컬렉션",
            route = "destinationCollection",
            bookMark = false,
            remove = 0
        ),
        Chapter(
            id = 8,
            title = "추상 클래스, 인터페이스",
            route = "destinationAbstractInterface",
            bookMark = false,
            remove = 0
        ),
        Chapter(
            id = 9,
            title = "함수 추가사항",
            route = "destinationFunctionAdd",
            bookMark = false,
            remove = 0
        ),
        Chapter(
            id = 10,
            title = "위임 확장",
            route = "destinationMandateExpansion",
            bookMark = false,
            remove = 0
        ),
        Chapter(
            id = 11,
            title = "제네릭",
            route = "destinationGeneric",
            bookMark = false,
            remove = 0
        ),
        Chapter(
            id = 12,
            title = "스레드",
            route = "destinationThread",
            bookMark = false,
            remove = 0
        ),
        Chapter(
            id = 13,
            title = "코루틴",
            route = "destinationCoroutine",
            bookMark = false,
            remove = 0
        )
    )
}

fun chapterListItem() {
    val my1chapter = Chapter(1,"객체","destinationObject",false,0)
    val my2chapter = Chapter(2,"문장 제어처리","destinationControl",false,0)
    val my3chapter = Chapter(3,"함수","destinationFunction",false,0)
    val my4chapter = Chapter(4,"클래스","destinationClass",false,0)
    val my5chapter = Chapter(5,"내장 자료형","destinationInType",false,0)
    val my6chapter = Chapter(6,"","",false,0)
    val my7chapter = Chapter(7,"","",false,0)
    val my8chapter = Chapter(8,"","",false,0)
    val my9chapter = Chapter(9,"","",false,0)
    val my10chapter = Chapter(10,"","",false,0)
    val my11chapter = Chapter(11,"","",false,0)
    val my12chapter = Chapter(12,"","",false,0)
    val my13chapter = Chapter(13,"","",false,0)

    val myChapter = mutableListOf(
        my1chapter,
        my2chapter,
        my3chapter
    )
}


