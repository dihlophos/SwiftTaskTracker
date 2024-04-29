package com.my.swifttasktracker.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.my.swifttasktracker.R
import com.my.swifttasktracker.domain.models.ITaskRepository
import org.koin.android.ext.android.inject

class CreateTaskFromIntentActivity : ComponentActivity() {
    private val taskRepository : ITaskRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intentProcessText = intent
            .getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT)

        if (!intentProcessText.isNullOrBlank()) {
            createTask(intentProcessText.toString())
        }

        finish()
    }

    private fun createTask(description:String) {
        taskRepository.newTask(description)

        Toast
            .makeText(this, getString(R.string.task_created), Toast.LENGTH_SHORT)
            .show()
    }
}