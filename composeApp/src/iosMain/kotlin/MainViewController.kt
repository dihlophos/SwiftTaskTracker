import androidx.compose.ui.window.ComposeUIViewController
import com.my.swifttasktracker.di.appModule
import com.my.swifttasktracker.di.ios.iosModule
import com.my.swifttasktracker.ui.App
import org.koin.core.context.startKoin

@Suppress("FunctionName", "unused")
fun MainViewController() = ComposeUIViewController {
    initKoin()
    App()
}

private fun initKoin() {
    startKoin {
        modules(
            appModule(),
            iosModule()
        )
    }
}