package com.my.swifttasktracker.shared.data

import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun Instant.toLocalDateTimeString() = this.toLocalDateTime(TimeZone.currentSystemDefault()).toString()