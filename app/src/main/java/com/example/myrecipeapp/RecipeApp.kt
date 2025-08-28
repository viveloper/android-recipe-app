package com.example.myrecipeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun RecipeApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    val recipeViewModel: MainViewModel = viewModel()
    val categoriesState by recipeViewModel.categoriesState

    NavHost(navController = navController, startDestination = Screen.Categories.route) {
        composable(Screen.Categories.route) {
            CategoriesScreen(
                categoriesState = categoriesState,
                navigateToDetail = { category ->
                    navController.currentBackStackEntry?.savedStateHandle?.set("category", category)
                    navController.navigate(Screen.CategoryDetail.route)
                },
                modifier = modifier
            )
        }
        composable(Screen.CategoryDetail.route) {
            val category =
                navController.previousBackStackEntry?.savedStateHandle?.get<Category>("category")
                    ?: Category("", "", "", "")
            CategoryDetailScreen(
                category = category,
                modifier = modifier
            )
        }

    }
}