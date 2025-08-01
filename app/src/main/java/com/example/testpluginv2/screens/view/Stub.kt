package fsn.nyk.screens.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun Stub() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green), contentAlignment = Alignment.Center
    ) {
        Text(text = "Stub", fontSize = 40.sp, color = Color.White)
    }
}