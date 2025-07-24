package com.example.testpluginv2.composables

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testpluginv2.screens.view.Loading
import fsn.nyk.screens.data.LoadingScreen
import fsn.nyk.screens.data.StubScreen
import fsn.nyk.screens.view.Stub

val Context.dataStore by preferencesDataStore(name = "enter_prefs")
val ENTER_MODE_KEY = stringPreferencesKey("enter_mode")

@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        modifier = modifier, navController = navController, startDestination = LoadingScreen
    ) {
        composable<LoadingScreen> {
            Loading(navController)
        }
        composable<StubScreen> {
            Stub()
        }
    }
}