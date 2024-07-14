package dev.jullls.movieapp.presentation.ui.detail_fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.jullls.movieapp.R
import dev.jullls.movieapp.databinding.FragmentDetailMovieBinding
import dev.jullls.movieapp.domain.filmApi.model.ActorModel

class DetailFragment : Fragment(R.layout.fragment_detail_movie) {

    private lateinit var binding: FragmentDetailMovieBinding

    private val actorModelListDetailMovies = listOf(
        ActorModel(R.drawable.cast_1, "Tom Holland"),
        ActorModel(R.drawable.cast_2, "Zendaya"),
        ActorModel(R.drawable.cast_3, "Benedict Cumberbatch"),
        ActorModel(R.drawable.cast_4, "Jacon Batalon")
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
        setupRecyclerActor()
    }

    private fun setupRecyclerActor(){
        with(binding) {
            rvDetailActors.setHasFixedSize(true)
            rvDetailActors.layoutManager =
                LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            rvDetailActors.adapter = ActorAdapter(actorModelListDetailMovies)
        }
    }
}
