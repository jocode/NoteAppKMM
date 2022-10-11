package com.crexative.noteappkmm.android.di

import android.app.Application
import com.crexative.noteappkmm.data.local.DatabaseDriverFactory
import com.crexative.noteappkmm.data.note.SqlDelightNoteDataSource
import com.crexative.noteappkmm.database.NoteDatabase
import com.crexative.noteappkmm.domain.note.NoteDataSource
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSqlDriver(app: Application) : SqlDriver {
        return  DatabaseDriverFactory(app).createDriver()
    }
    @Provides
    @Singleton
    fun provideNoteDataSource(driver: SqlDriver) : NoteDataSource {
        return  SqlDelightNoteDataSource(NoteDatabase(driver))
    }

}