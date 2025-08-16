package cz.yogaboy.homeworkmasterclasscoroutine.domain.repository

interface JobsRepository {
    suspend fun runJobs(): Pair<String, Long>
}