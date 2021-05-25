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

    @Test
    fun `one completed task AND no active tasks`() {
        //Given
        val tasks = listOf(
                Task("Job Application", "Send CV", isCompleted = true)
        )

        // When: Call your function
        val result = getActiveAndCompletedStats(tasks)

        //Then
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(100f))
    }

    @Test
    fun `two completed task AND three active tasks`() {
        //Given
        val tasks = listOf(
                Task("Job Application", "Send CV", isCompleted = true),
                Task("Job Application", "Send Letter", isCompleted = true),
                Task("Job Application", "Text recruiter", isCompleted = false),
                Task("Job Application", "Do coding challenge", isCompleted = false),
                Task("Job Application", "Update excel sheet", isCompleted = false)
        )

        // When: Call your function
        val result = getActiveAndCompletedStats(tasks)

        //Then
        assertThat(result.activeTasksPercent, `is`(60f))
        assertThat(result.completedTasksPercent, `is`(40f))
    }

    @Test
    fun `list of tasks is empty`() {
        //Given
        val tasks = emptyList<Task>()

        // When: Call your function
        val result = getActiveAndCompletedStats(tasks)

        //Then
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

    @Test
    fun `list of tasks is null`() {
        //Given
        val tasks = null

        // When: Call your function
        val result = getActiveAndCompletedStats(tasks)

        //Then
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }


}