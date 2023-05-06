package com.example.moviesapp.ui

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.example.moviesapp.R
import com.example.moviesapp.databinding.DialogAddAPlaylistBinding
import com.example.moviesapp.databinding.PlaylistBottomSheetBinding
import com.example.moviesapp.model.Playlist
import com.example.moviesapp.ui.adapter.PlaylistAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PlaylistBottomSheet : BottomSheetDialogFragment() {

    private lateinit var binding: PlaylistBottomSheetBinding
    private var playlistAdapter = PlaylistAdapter()
    private var alertDialog: AlertDialog? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = PlaylistBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        createAddAPlaylistDialog()

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
                    if (position == it.size - 1) {
                        alertDialog?.show()
                    }
                }
            }
        }


        binding.playlistRecyclerView.adapter = playlistAdapter
    }

    private fun createAddAPlaylistDialog() {
        alertDialog = activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater;
            val binding = DialogAddAPlaylistBinding.inflate(inflater)
            val editText = binding.playlistEdittext

            builder.setView(binding.root).setPositiveButton(
                R.string.ok
            ) { dialog, _ ->
                val playlistName = editText.text.toString()
                if (playlistName.isNotEmpty()) {
                    playlistAdapter.playlists?.add(Playlist(6, playlistName))
                    playlistAdapter.notifyDataSetChanged()
                    dialog.dismiss()
                }
            }.setNegativeButton(
                R.string.cancel
            ) { dialog, _ ->
                dialog.dismiss()
            }
            builder.create()
        }
    }

    companion object {
        const val TAG: String = "PlayListBottomSheet"
    }
}