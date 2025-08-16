package cz.yogaboy.homeworkmasterclasscoroutine.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import cz.yogaboy.homeworkmasterclasscoroutine.feature.detail.presentation.DetailScreen
import cz.yogaboy.homeworkmasterclasscoroutine.feature.detail.presentation.DetailViewModel
import cz.yogaboy.homeworkmasterclasscoroutine.feature.main.presentation.MainScreen
import cz.yogaboy.homeworkmasterclasscoroutine.feature.main.presentation.MainViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun RootNavHost() {
    val nav = rememberNavController()
    NavHost(navController = nav, startDestination = MainScreen) {
        composable<MainScreen> {
            val vm: MainViewModel = koinViewModel()
            val result by vm.result.collectAsState()

            LaunchedEffect(result) {
                result?.let { (name, duration): Pair<String, Long> ->
                    nav.navigate(DetailScreen(jobName = name, jobDuration = duration))
                }
            }

            MainScreen(
                onRun = { vm.run() }
            )
        }
        composable<DetailScreen> { backStackEntry ->
            val args = backStackEntry.toRoute<DetailScreen>()
            val vm: DetailViewModel = koinViewModel(parameters = { parametersOf(args.jobName, args.jobDuration) })
            DetailScreen(
                jobName = vm.jobName,
                jobDuration = vm.jobDuration,
                onBack = { nav.popBackStack() }
            )
        }
    }
}