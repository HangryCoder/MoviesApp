package com.example.moviesapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.moviesapp.databinding.PlaylistBottomSheetBinding
import com.example.moviesapp.model.Playlist
import com.example.moviesapp.ui.adapter.PlaylistAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PlaylistBottomSheet : BottomSheetDialogFragment() {

    private lateinit var binding: PlaylistBottomSheetBinding
    private var playlistAdapter = PlaylistAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = PlaylistBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        playlistAdapter.apply {
            playlists = arrayListOf(
                Playlist(1, "Playlist 1"),
                Playlist(2, "Playlist 2"),
                Playlist(3, "Playlist 3"),
                Playlist(4, "Playlist 4"),
                Playlist(5, "+ Add a playlist")
            )
            onClick = { position ->
                playlists?.let {
                    if (position == it.size - 1) println("Add a playlist")
                }
            }
        }


        binding.playlistRecyclerView.adapter = playlistAdapter
    }

    companion object {
        const val TAG: String = "PlayListBottomSheet"
    }
}