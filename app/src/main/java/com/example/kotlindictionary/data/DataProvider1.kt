package com.example.kotlindictionary.data

class ListRepository {
    companion object{
        var data = mutableListOf(
        Chapter("임시 값","경로")
        )
    }

    fun getAllData(): MutableList<Chapter> {
        return data
    }

    fun addData(a:Chapter){
        data.add(a)
    }

    fun removeData(a:Chapter){
        data.remove(a)
    }
}