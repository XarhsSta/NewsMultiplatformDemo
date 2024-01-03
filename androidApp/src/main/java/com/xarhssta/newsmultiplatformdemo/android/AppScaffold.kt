package com.xarhssta.newsmultiplatformdemo.android

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.xarhssta.newsmultiplatformdemo.android.screens.ArticlesScreen
import com.xarhssta.newsmultiplatformdemo.android.screens.DetailsScreen
import com.xarhssta.newsmultiplatformdemo.android.screens.Screen

@Composable
fun AppScaffold() {
    val navController = rememberNavController()

    Scaffold {
        AppNavHost(
            navController = navController,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        )
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.ARTICLES.route,
        modifier = modifier
    ) {
        composable(Screen.ARTICLES.route) {
            ArticlesScreen(
                onAboutButtonClick = { navController.navigate(Screen.DEVICE_DETAILS.route) })
        }
        composable(Screen.DEVICE_DETAILS.route) {
            DetailsScreen(onBackClick = { navController.popBackStack() })
        }
    }
}