package cz.yogaboy.homeworkmasterclasscoroutine

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cz.yogaboy.homeworkmasterclasscoroutine.navigation.RootNavHost
import cz.yogaboy.homeworkmasterclasscoroutine.ui.theme.HomeworkMasterClassCoroutineTheme

@Composable
fun AppRoot() {
    HomeworkMasterClassCoroutineTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            RootNavHost()
        }
    }
}