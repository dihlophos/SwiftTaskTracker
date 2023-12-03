import com.my.swifttasktracker.Platform

class TestPlatform : Platform {
    override val name: String = "Test"
}

fun getPlatform(): Platform = TestPlatform()