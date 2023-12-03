import com.my.swifttasktracker.Greeting
import kotlin.test.Test
import kotlin.test.assertEquals

class GreetingTest {
    private val testingObject = Greeting(getPlatform())

    @Test
    fun shouldGreetUser() {
        val result = testingObject.greet()

        assertEquals(result, "Hello, Test!")
    }
}