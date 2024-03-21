package com.example.practicasqlite_234963.presentation

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNoteScreen(
    state: NoteState,
    navController: NavController,
    onEvent: (NotesEvent) -> Unit
) {

    val titleError = remember { mutableStateOf(false) }
    val descriptionError = remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                if (state.title.value.isBlank() || state.title.value.trim().isEmpty()) {
                    titleError.value = true
                } else if (state.description.value.isBlank() || state.description.value.trim().isEmpty()) {
                    descriptionError.value = true
                } else {
                    onEvent(
                        NotesEvent.SaveNote(
                            title = state.title.value,
                            description = state.description.value
                        )
                    )
                    navController.popBackStack()
                }
            }) {
                Icon(
                    imageVector = Icons.Rounded.Check,
                    contentDescription = "Save Note"
                )
            }
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                value = state.title.value,
                onValueChange = {
                    state.title.value = it
                    titleError.value = false
                },
                isError = titleError.value,
                textStyle = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 17.sp
                ),
                placeholder = {
                    Text(text = "Title")
                }

            )

            if (titleError.value) {
                Text(
                    text = "Title cannot be empty",
                    color = Color.Red,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                value = state.description.value,
                onValueChange = {
                    state.description.value = it
                    descriptionError.value = false
                },
                isError = descriptionError.value,
                placeholder = {
                    Text(text = "Description")
                }

            )

            if (descriptionError.value) {
                Text(
                    text = "Description cannot be empty",
                    color = Color.Red,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }

        }

    }

}