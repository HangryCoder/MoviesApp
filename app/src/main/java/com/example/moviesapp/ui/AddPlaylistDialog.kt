package com.example.moviesapp.ui

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.moviesapp.R
import com.example.moviesapp.databinding.DialogAddAPlaylistBinding
import com.example.moviesapp.viewmodel.MovieViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class AddPlaylistDialog : DialogFragment() {

    @Inject
    lateinit var viewModel: MovieViewModel
    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val binding = DialogAddAPlaylistBinding.inflate(LayoutInflater.from(requireContext()))
        val editText = binding.playlistEdittext

        return AlertDialog.Builder(requireContext()).setView(binding.root)
            .setPositiveButton(getString(R.string.ok)) { dialog, _ ->
                val playlistName = editText.text.toString()
                if (playlistName.isNotEmpty()) {
                    viewModel.addPlayList(playlistName)
                    dialog.dismiss()
                }
            }.setNegativeButton(getString(R.string.cancel)) { dialog, _ ->
                dialog.dismiss()
            }.create()
    }

    companion object {
        const val TAG = "AddPlaylistDialog"
    }
}