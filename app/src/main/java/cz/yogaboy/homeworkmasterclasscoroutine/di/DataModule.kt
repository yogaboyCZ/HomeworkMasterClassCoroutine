package cz.yogaboy.homeworkmasterclasscoroutine.di

import cz.yogaboy.homeworkmasterclasscoroutine.data.repository.JobsRepositoryImpl
import cz.yogaboy.homeworkmasterclasscoroutine.domain.repository.JobsRepository
import cz.yogaboy.homeworkmasterclasscoroutine.domain.usecase.StartJobs
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    singleOf(::JobsRepositoryImpl) bind JobsRepository::class
    factoryOf(::StartJobs)
}