package cz.yogaboy.homeworkmasterclasscoroutine.domain.usecase

import cz.yogaboy.homeworkmasterclasscoroutine.domain.repository.JobsRepository

class StartJobs(private val repo: JobsRepository) {
    suspend operator fun invoke(): Pair<String, Long> = repo.runJobs()
}