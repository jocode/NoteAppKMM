package com.crexative.noteappkmm.di

import com.crexative.noteappkmm.data.local.DatabaseDriverFactory
import com.crexative.noteappkmm.data.note.SqlDelightNoteDataSource
import com.crexative.noteappkmm.database.NoteDatabase
import com.crexative.noteappkmm.domain.note.NoteDataSource

class DatabaseModule {

    private val factory by lazy { DatabaseDriverFactory() }
    val noteDataSource : NoteDataSource by lazy {
        SqlDelightNoteDataSource(NoteDatabase(factory.createDriver()))
    }

}