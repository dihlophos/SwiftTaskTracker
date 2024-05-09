package com.my.swifttasktracker.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.my.swifttasktracker.R
import com.my.swifttasktracker.domain.IInboxRepository
import org.koin.android.ext.android.inject

class CreateInboxItemFromIntentActivity : ComponentActivity() {
    private val inboxRepository : IInboxRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intentProcessedText = intent
            .getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT)

        if (!intentProcessedText.isNullOrBlank()) {
            createInboxItem(intentProcessedText.toString())
        }

        finish()
    }

    private fun createInboxItem(description:String) {
        inboxRepository.createInboxItem(description)

        Toast
            .makeText(this, getString(R.string.inbox_item_created), Toast.LENGTH_SHORT)
            .show()
    }
}