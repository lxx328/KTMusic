package com.dexter.aktmusic.feature.player

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun PlayerScreen(
    viewModel: PlayerViewModel = hiltViewModel(),
    onNavigateToPlaylist: (String) -> Unit
) {
    val state = viewModel.collectAsState().value

    LaunchedEffect(Unit) {
        viewModel.collectSideEffect { effect ->
            when (effect) {
                is PlayerEffect.NavigateToPlaylist -> onNavigateToPlaylist(effect.playlistId)
                is PlayerEffect.ShowToast -> {
                    // Show toast
                }
                is PlayerEffect.ShowError -> {
                    // Show error
                }
                else -> {}
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Song Info
        state.currentSong?.let { song ->
            Text(
                text = song.title,
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = song.artist,
                style = MaterialTheme.typography.bodyLarge
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Progress
        Slider(
            value = state.progress,
            onValueChange = { viewModel.processIntent(PlayerIntent.SeekTo(it)) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Controls
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { viewModel.processIntent(PlayerIntent.PreviousSong) }) {
                Icon(
                    imageVector = androidx.compose.material.icons.Icons.Default.SkipPrevious,
                    contentDescription = "Previous"
                )
            }

            IconButton(
                onClick = {
                    if (state.isPlaying) {
                        viewModel.processIntent(PlayerIntent.PauseSong)
                    } else {
                        viewModel.processIntent(PlayerIntent.ResumeSong)
                    }
                }
            ) {
                Icon(
                    imageVector = if (state.isPlaying) {
                        androidx.compose.material.icons.Icons.Default.Pause
                    } else {
                        androidx.compose.material.icons.Icons.Default.PlayArrow
                    },
                    contentDescription = if (state.isPlaying) "Pause" else "Play"
                )
            }

            IconButton(onClick = { viewModel.processIntent(PlayerIntent.NextSong) }) {
                Icon(
                    imageVector = androidx.compose.material.icons.Icons.Default.SkipNext,
                    contentDescription = "Next"
                )
            }
        }

        if (state.isLoading) {
            CircularProgressIndicator()
        }

        state.error?.let { error ->
            Text(
                text = error,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
} 