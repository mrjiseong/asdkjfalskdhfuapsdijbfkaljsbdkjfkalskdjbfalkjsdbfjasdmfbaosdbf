package com.example.kotlindictionary.data

class ListRepository {
    companion object {
        var data: MutableList<Chapter> = mutableListOf(

        )
    }

    fun getAllData(): MutableList<Chapter> {
        return data
    }

    fun bookMarkButton(a: Chapter) {
        a.id = 1
        a.bookMark = false
    }
}