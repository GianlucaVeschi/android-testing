package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsKtTest {

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {
        // Given: Create an active tasks (the false makes this active)
        val tasks = listOf<Task>(
                Task("title", "desc", isCompleted = false)
        )
        // When: Call your function
        val result = getActiveAndCompletedStats(tasks)

        // Then: Check the result
        assertThat(result.activeTasksPercent, `is`(100f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

}