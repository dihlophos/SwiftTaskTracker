package com.my.swifttasktracker.android.createTaskActivity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.my.swifttasktracker.android.R
import com.my.swifttasktracker.android.ui.theme.SwiftTaskTrackerTheme
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

class CreateTaskActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intentProcessText = intent
            .getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT)?.toString() ?: ""

        setContent {
            SwiftTaskTrackerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreateTaskScreen(intentProcessText)
                }
            }
        }
    }
}

@Composable
fun NewTaskInput(viewModel: CreateTaskViewModel) {
    TextField(
        value = viewModel.taskDescription,
        onValueChange = { viewModel.taskDescription=it },
        label = { Text(stringResource(R.string.task_description)) }
    )

    Button(onClick = {
        viewModel.addTask()
    }) {
        Text(stringResource(R.string.new_task))
    }
}

@Composable
fun CreateTaskScreen(initialText: String) {
    val viewModel = koinViewModel<CreateTaskViewModel>(parameters = { parametersOf(initialText) })
    Column {
        NewTaskInput(viewModel)
    }
}