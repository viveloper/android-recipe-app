package com.example.myrecipeapp

sealed class Screen(val route: String) {
    object Categories : Screen("categories")
    object CategoryDetail : Screen("categoryDetail")
}