package com.example.moviesapp.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.moviesapp.databinding.PlaylistBottomSheetBinding
import com.example.moviesapp.ui.adapter.PlaylistAdapter
import com.example.moviesapp.viewmodel.MovieViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class PlaylistBottomSheet : BottomSheetDialogFragment() {

    private lateinit var binding: PlaylistBottomSheetBinding

    @Inject
    lateinit var playlistAdapter: PlaylistAdapter

    @Inject
    lateinit var viewModel: MovieViewModel

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = PlaylistBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSetup()
    }

    private fun initSetup() {
        setupRecyclerView()
        fetchPlaylists()
        setClickListeners()
    }

    private fun setupRecyclerView() {
        playlistAdapter.onClick = {
            viewModel.addMovieToPlaylist(it)
            this.dismiss()
        }
        binding.playlistRecyclerView.adapter = playlistAdapter
    }

    private fun fetchPlaylists() {
        viewModel.getPlaylists()
        viewModel.playlists.observe(this) {
            playlistAdapter.playlists = it
            playlistAdapter.notifyDataSetChanged()
        }
    }

    private fun setClickListeners() {
        binding.addAPlaylistButton.setOnClickListener {
            AddPlaylistDialog().show(
                childFragmentManager, AddPlaylistDialog.TAG
            )
        }
    }

    companion object {
        const val TAG: String = "PlayListBottomSheet"
    }
}