package com.example.moviesapp

import com.example.moviesapp.utils.isValid
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PlaylistValidationTest {

    @Test
    fun playlistValidator_CorrectPlaylistName_ReturnsTrue() {
        assertTrue("Playlist 1".isValid())
    }

    @Test
    fun playlistValidator_EmptyPlaylistName_ReturnsFalse() {
        assertFalse("".isValid())
    }
}