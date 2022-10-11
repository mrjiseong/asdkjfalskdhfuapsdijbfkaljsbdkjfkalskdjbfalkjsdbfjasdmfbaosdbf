package com.example.kotlindictionary

import android.content.Context


    class Word(
        chapter: String,
        contents: String,
        bookmark: String,
        context: Context
    ){
        val chapter = "객체"
        val contents = context.resources.getString(R.string.object_content)
}