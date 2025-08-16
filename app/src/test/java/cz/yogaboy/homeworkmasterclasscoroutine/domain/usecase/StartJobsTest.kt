package cz.yogaboy.homeworkmasterclasscoroutine.domain.usecase

import cz.yogaboy.homeworkmasterclasscoroutine.domain.repository.JobsRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import kotlinx.coroutines.runBlocking


class StartJobsTest {
    @Test
    fun `given repository returns when StartJobs is invoked then result is X`() = runBlocking {
        val repo = object : JobsRepository {
            override suspend fun runJobs(): Pair<String, Long> = "X" to 123L
        }
        val useCase = StartJobs(repo)

        val result = useCase()

        assertEquals("X" to 123L, result)
    }
}