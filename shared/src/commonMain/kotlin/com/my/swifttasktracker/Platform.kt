package com.my.swifttasktracker

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform