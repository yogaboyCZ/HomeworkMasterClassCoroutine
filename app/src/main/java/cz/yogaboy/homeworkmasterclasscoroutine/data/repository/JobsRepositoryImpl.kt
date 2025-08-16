package cz.yogaboy.homeworkmasterclasscoroutine.data.repository

import cz.yogaboy.homeworkmasterclasscoroutine.domain.repository.JobsRepository
import kotlinx.coroutines.delay


class JobsRepositoryImpl : JobsRepository {
    override suspend fun runJobs(): Pair<String, Long> {
        val start = System.currentTimeMillis()
        delay(2000)
        delay(1000)
        return "Job 1 & Job 2" to (System.currentTimeMillis() - start)
    }
}