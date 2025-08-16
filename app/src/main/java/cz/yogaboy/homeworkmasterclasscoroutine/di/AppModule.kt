package cz.yogaboy.homeworkmasterclasscoroutine.di

import cz.yogaboy.homeworkmasterclasscoroutine.feature.detail.presentation.DetailViewModel
import cz.yogaboy.homeworkmasterclasscoroutine.feature.main.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::MainViewModel)
    viewModel { (jobName: String, jobDuration: Long) ->
        DetailViewModel(jobName, jobDuration)
    }
}