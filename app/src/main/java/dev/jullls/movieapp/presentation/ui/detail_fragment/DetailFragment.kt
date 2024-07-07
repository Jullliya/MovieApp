package dev.jullls.movieapp.presentation.ui.detail_fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.jullls.movieapp.R
import dev.jullls.movieapp.databinding.FragmentDetailMovieBinding
import dev.jullls.movieapp.presentation.model.Actor

class DetailFragment : Fragment(R.layout.fragment_detail_movie) {

    private lateinit var binding: FragmentDetailMovieBinding

    private val actorListDetailMovie = listOf(
        Actor(R.drawable.cast_1, "Tom Holland"),
        Actor(R.drawable.cast_2, "Zendaya"),
        Actor(R.drawable.cast_3, "Benedict Cumberbatch"),
        Actor(R.drawable.cast_4, "Jacon Batalon")
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupListeners()
    }

    private fun setupListeners() {
        with(binding) {
            btnDetailBack.setOnClickListener {
                findNavController().navigate(R.id.action_detailFragment_to_homeFragment)
            }
        }
    }

    private fun setupUI() {
        with(binding) {
            rvDetailActors.setHasFixedSize(true)
            rvDetailActors.layoutManager =
                LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            rvDetailActors.adapter = ActorAdapter(actorListDetailMovie)
        }
    }
}
