package com.example.practicasqlite_234963.presentation

import com.example.practicasqlite_234963.data.*

sealed interface NotesEvent {
    object SortNotes: NotesEvent

    data class DeleteNote(val note: Note): NotesEvent

    data class SaveNote(
        val title: String,
        val description: String
    ): NotesEvent
}