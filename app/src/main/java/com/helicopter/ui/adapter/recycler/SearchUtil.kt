package com.helicopter.ui.adapter.recycler

import android.annotation.SuppressLint

/*
* Проверяет подходит ли запрос поиска под один из параметров
* */
@SuppressLint("DefaultLocale")
fun containsSearchQuery(searchQuery: String, vararg params: String): Boolean {
    for (param in params){
        if(param.toLowerCase().startsWith(searchQuery.toLowerCase())){
            return true
        }
    }
    return false
}