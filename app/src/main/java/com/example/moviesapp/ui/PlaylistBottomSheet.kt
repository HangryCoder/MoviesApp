package com.example.moviesapp.ui

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.moviesapp.databinding.PlaylistBottomSheetBinding
import com.example.moviesapp.model.Playlist
import com.example.moviesapp.ui.adapter.PlaylistAdapter
import com.example.moviesapp.viewmodel.MovieViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import javax.inject.Inject

class PlaylistBottomSheet : BottomSheetDialogFragment() {

    private lateinit var binding: PlaylistBottomSheetBinding
    private var playlistAdapter = PlaylistAdapter()

//    @Inject
//    lateinit var viewModel: MovieViewModel

    var viewModel: MovieViewModel? = null

    /*  override fun onAttach(context: Context) {
          (activity as MainActivity).activityComponent.inject(this)
          super.onAttach(context)
      }*/

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
        binding.playlistRecyclerView.adapter = playlistAdapter
    }

    private fun fetchPlaylists() {
        //Temporarily using this hack to access viewModel
        viewModel = (activity as MainActivity).viewModel

        viewModel?.playlists?.observe(this) {
            playlistAdapter.playlists = it as ArrayList<Playlist>?
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