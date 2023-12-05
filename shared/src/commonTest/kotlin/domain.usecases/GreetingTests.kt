package domain.usecases

import com.my.swifttasktracker.domain.models.Task
import com.my.swifttasktracker.domain.models.TaskRepository
import com.my.swifttasktracker.domain.usecases.Greeting
import io.mockative.Mock
import io.mockative.classOf
import io.mockative.every
import io.mockative.mock
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertContentEquals

class GreetingTests {
    @Mock
    private val taskRepositoryMock = mock(classOf<TaskRepository>())
    private val greeting = Greeting(taskRepositoryMock)
    private val tasks = listOf(Task("Task1"), Task("Task2"))

    @BeforeTest
    fun before() {
        every { taskRepositoryMock.getAllTasks() }
            .returns(tasks)
    }

    @Test
    fun shouldGreetUser() {
        val result = greeting.greet()

        assertContentEquals(result, tasks)
    }
}