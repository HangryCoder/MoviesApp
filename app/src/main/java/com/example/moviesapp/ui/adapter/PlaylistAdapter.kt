package com.example.moviesapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.databinding.ItemPlaylistBinding
import com.example.moviesapp.model.Playlist

class PlaylistAdapter : RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder>() {

    var playlists: ArrayList<Playlist>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        val binding =
            ItemPlaylistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlaylistViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        val playlist = playlists?.get(position)
        playlist?.let {
            holder.bind(playlist, position)
        }
    }

    override fun getItemCount(): Int = playlists?.size ?: 0

    class PlaylistViewHolder(binding: ItemPlaylistBinding) : RecyclerView.ViewHolder(binding.root) {
        private val playlistTextView = binding.playlistTextView

        fun bind(playlist: Playlist, position: Int) {
            playlistTextView.text = playlist.playlistName ?: "Playlist ${position + 1}"
        }
    }
}