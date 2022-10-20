package com.example.kotlindictionary.data

class ListRepository {
    companion object {
        var data: MutableList<Chapter> = mutableListOf(

        )
    }

    fun getAllData(): MutableList<Chapter> {
        return data
    }
}