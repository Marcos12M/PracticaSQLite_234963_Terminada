package com.example.practicasqlite_234963.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.practicasqlite_234963.data.*

data class NoteState(
    val notes: List<Note> = emptyList(),
    val title: MutableState<String> = mutableStateOf(""),
    val description: MutableState<String> = mutableStateOf(""),
    val titleError: MutableState<Boolean> = mutableStateOf(false),
    val descriptionError: MutableState<Boolean> = mutableStateOf(false)
)