package com.crexative.noteappkmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform