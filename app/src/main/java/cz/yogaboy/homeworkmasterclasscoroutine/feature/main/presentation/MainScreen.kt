package cz.yogaboy.homeworkmasterclasscoroutine.feature.main.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainScreen(
    onRun: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Homework Master Class Coroutine", fontSize = 24.sp, textAlign = TextAlign.Center)
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onRun
        ) {
            Text("Start Coroutine Jobs")
        }
    }
}