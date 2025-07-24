package com.example.testpluginv2.screens.view

import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import com.example.testpluginv2.composables.ENTER_MODE_KEY
import com.example.testpluginv2.composables.dataStore
import com.example.testpluginv2.ui.theme.enterMode
import fsn.nyk.screens.data.StubScreen
import kotlinx.coroutines.flow.map

@Composable
fun Loading(navController: NavController) {
    val activity = LocalActivity.current as FragmentActivity
    val enterModeFlow = activity.dataStore.data.map { prefs -> prefs[ENTER_MODE_KEY] }
    val enterMode by enterModeFlow.collectAsState(initial = null)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Loading...", fontSize = 26.sp, color = Color.White)
        Spacer(Modifier.height(32.dp))
        CircularProgressIndicator()
    }

    LaunchedEffect(Unit) {
        enterMode(activity)
    }

    LaunchedEffect(enterMode) {
        if (enterMode == "stub") navController.navigate(StubScreen)
    }
}