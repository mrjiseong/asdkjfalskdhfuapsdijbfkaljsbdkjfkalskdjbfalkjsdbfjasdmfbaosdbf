package com.example.kotlindictionary.data

class ListRepository {
    companion object{
        var data:MutableList<Chapter> = mutableListOf(

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

    fun bookMark(a:Chapter){
        a.bookMark || true
    }
}