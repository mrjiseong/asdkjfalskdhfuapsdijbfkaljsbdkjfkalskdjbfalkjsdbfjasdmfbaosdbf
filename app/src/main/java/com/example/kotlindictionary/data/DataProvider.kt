package com.example.kotlindictionary.data

object DataProvider {
    val chapter =
        Chapter(
            id = 1,
            title = "객체"
        )

    val chapterList = listOf(
        chapter,
        Chapter(
            id = 2,
            title = "문장 제어처리"
        ),
        Chapter(
            id = 3,
            title = "함수"
        ),
        Chapter(
            id = 4,
            title = "클래스"
        ),
        Chapter(
            id = 5,
            title = "내장 자료형"
        ),
        Chapter(
            id = 6,
            title = "클래스 관계 등 추가사항"
        ),
        Chapter(
            id = 7,
            title = "컬렉션"
        ),
        Chapter(
            id = 8,
            title = "추상 클래스, 인터페이스"
        ),
        Chapter(
            id = 9,
            title = "함수 추가사항"
        ),
        Chapter(
            id = 10,
            title = "위임 확장"
        ),
        Chapter(
            id = 11,
            title = "제네릭"
        ),
        Chapter(
            id = 12,
            title = "스레드"
        ),
        Chapter(
            id = 13,
            title = "코루틴"
        )
    )
}