package cz.yogaboy.homeworkmasterclasscoroutine.feature.main.presentation

import app.cash.turbine.test
import cz.yogaboy.homeworkmasterclasscoroutine.domain.repository.JobsRepository
import cz.yogaboy.homeworkmasterclasscoroutine.domain.usecase.StartJobs
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


class MainViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    @BeforeEach
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `given repository returns X when run is called then emits X`() = runTest {
        val repo = object : JobsRepository {
            override suspend fun runJobs() = "X" to 123L
        }
        val vm = MainViewModel(StartJobs(repo))
        vm.result.test {
            vm.run()
            awaitItem()
            assertEquals("X" to 123L, awaitItem())
        }
    }
}