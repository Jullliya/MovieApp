package dev.jullls.movieapp.presentation.ui.home_fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.jullls.movieapp.R
import dev.jullls.movieapp.databinding.FragmentHomeBinding
import dev.jullls.movieapp.presentation.model.Film

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private val filmListNowShowing = listOf(
        Film(
            R.drawable.film_1,
            "Spiderman: No Way Home",
            "9.1/10 IMDb",
            listOf(""),
            ""
        ),
        Film(
            R.drawable.film_2,
            "Eternals",
            "9.5/10 IMDb",
            listOf(""),
            ""
        ),
        Film(
            R.drawable.film_3,
            "Shang-Chi",
            "8,1/10 IMDb",
            listOf(""),
            ""
        )
    )
    private val filmListPopular = listOf(
        Film(
            R.drawable.film_4,
            "Venom Let There Be Carnage",
            "6.4/10 IMDb",
            listOf(""),
            "1h 47m"
        ),
        Film(
            R.drawable.film_5,
            "The King’s Man",
            "8.4/10 IMDb",
            listOf(""),
            "1h 47m"
        )
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupListeners()
    }

    private fun setupListeners() {
        with(binding) {
            btnHomeHowShowingSeeMore.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_detailFragment)
            }
        }
    }

    private fun setupUI(){
        setupRecyclerNowShowing()
        setupRecyclerPopular()
    }

    private fun setupRecyclerPopular() {
        with(binding) {
            rvHomePopular.setHasFixedSize(true)
            rvHomePopular.layoutManager =
                LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            rvHomePopular.adapter = PopularFilmAdapter(filmListPopular)
        }
    }

    private fun setupRecyclerNowShowing(){
        with(binding) {
            rvHomeNowShowing.setHasFixedSize(true)
            rvHomeNowShowing.layoutManager =
                LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            rvHomeNowShowing.adapter = NowShowingFilmAdapter(filmListNowShowing)
        }
    }
}