package com.dexter.aktmusic.domain.usecase.player

import com.dexter.aktmusic.data.model.home.DSong
import javax.inject.Inject

class GetPlaylistUseCase @Inject constructor() {
    suspend operator fun invoke(): List<DSong> {
        // TODO: Implement actual playlist fetching logic here
        // For now, return an empty list
        return emptyList()
    }
} 