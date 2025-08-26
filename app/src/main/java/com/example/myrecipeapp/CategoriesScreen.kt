package com.example.myrecipeapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CategoriesScreen(modifier: Modifier = Modifier) {
    val categoriesViewModel: MainViewModel = viewModel()
    val categoriesState by categoriesViewModel.categoriesState

    Box(modifier = modifier.fillMaxSize()) {
        when {
            categoriesState.loading -> {
                CircularProgressIndicator(modifier = modifier.align(Alignment.Center))
            }

            categoriesState.error != null -> {
                Text(text = categoriesState.error!!)
            }

            else -> {
                CategoryList(categories = categoriesState.list)
            }
        }
    }
}

@Composable
fun CategoryList(categories: List<Category>) {
    Column {
        categories.forEach { category ->
            Text(text = category.strCategory)
        }
    }

}