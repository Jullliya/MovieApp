package dev.jullls.movieapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.jullls.movieapp.databinding.FragmentDetailMovieBinding

class DetailFragment : Fragment(R.layout.fragment_detail_movie){

    private lateinit var binding: FragmentDetailMovieBinding

    private lateinit var recyclerViewDetailMovieActor: RecyclerView
    private lateinit var actorListDetailMovie: ArrayList<Actor>
    private lateinit var actorAdapterDetailMovie: ActorAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupListeners()
    }

    private fun setupListeners() {
        with(binding) {
            val backBtn = buttonBack
            backBtn.setOnClickListener {
                view?.findNavController()?.navigate(R.id.action_detailFragment_to_homeFragment)
            }
        }
    }

    private fun setupUI(){
        with(binding) {

            recyclerViewDetailMovieActor = detailMovieCastRecyclerView
            recyclerViewDetailMovieActor.setHasFixedSize(true)
            recyclerViewDetailMovieActor.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            actorListDetailMovie = ArrayList()

            actorListDetailMovie.add(Actor(R.drawable.cast_1, "Tom Holland"))
            actorListDetailMovie.add(Actor(R.drawable.cast_2, "Zendaya"))
            actorListDetailMovie.add(Actor(R.drawable.cast_3, "Benedict Cumberbatch"))
            actorListDetailMovie.add(Actor(R.drawable.cast_4, "Jacon Batalon"))

            actorAdapterDetailMovie = ActorAdapter(actorListDetailMovie)
            recyclerViewDetailMovieActor.adapter = actorAdapterDetailMovie
        }
    }
}
