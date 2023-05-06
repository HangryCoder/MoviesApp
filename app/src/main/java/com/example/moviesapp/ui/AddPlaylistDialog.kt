package com.example.moviesapp.ui

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.moviesapp.R
import com.example.moviesapp.databinding.DialogAddAPlaylistBinding
import com.example.moviesapp.viewmodel.MovieViewModel

class AddPlaylistDialog : DialogFragment() {

    var viewModel: MovieViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Temporary hack!
        viewModel = (activity as MainActivity).viewModel
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val binding = DialogAddAPlaylistBinding.inflate(LayoutInflater.from(requireContext()))
        val editText = binding.playlistEdittext

        return AlertDialog.Builder(requireContext()).setView(binding.root)
            .setPositiveButton(getString(R.string.ok)) { dialog, _ ->
                val playlistName = editText.text.toString()
                if (playlistName.isNotEmpty()) {
                    viewModel?.addPlayList(playlistName)
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