package cz.yogaboy.homeworkmasterclasscoroutine.navigation

import kotlinx.serialization.Serializable

@Serializable
object MainScreen

@Serializable
data class DetailScreen(
    val jobName: String,
    val jobDuration: Long
)