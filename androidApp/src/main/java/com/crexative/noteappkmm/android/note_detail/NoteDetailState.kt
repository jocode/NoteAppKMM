package com.crexative.noteappkmm.android.note_detail

import androidx.compose.ui.graphics.Color

data class NoteDetailState(
    val noteTitle: String = "",
    val isNoteTitleTextFocus: Boolean = false,
    val noteContent: String = "",
    val isNoteContentTextFocused: Boolean = false,
    val noteColor: Color = Color.White
)