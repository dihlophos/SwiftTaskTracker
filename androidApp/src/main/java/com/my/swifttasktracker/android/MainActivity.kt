package com.my.swifttasktracker.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.my.swifttasktracker.domain.models.Task
import com.my.swifttasktracker.domain.models.TaskRepository
import com.my.swifttasktracker.domain.usecases.Greeting
import org.koin.android.ext.android.inject

class MainActivity() : ComponentActivity() {
    private val taskRepository: TaskRepository by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingView(Greeting(taskRepository).greet())
                }
            }
        }
    }
}

@Composable
fun GreetingView(tasks: List<Task>) {
    LazyColumn(
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(tasks) { task ->
            Text(task.name)
            Divider()
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView(listOf(Task("Default")))
    }
}
