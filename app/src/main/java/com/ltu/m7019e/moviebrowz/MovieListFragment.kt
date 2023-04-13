package com.ltu.m7019e.moviebrowz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.ltu.m7019e.moviebrowz.database.Movies
import com.ltu.m7019e.moviebrowz.databinding.FragmentMovieListBinding
import com.ltu.m7019e.moviebrowz.databinding.MovieListItemBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MovieListFragment : Fragment() {

    private var _binding: FragmentMovieListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_list, container, false)

        val movies = Movies()

        movies.list.forEach{movie ->
            val movieListItemBinding: MovieListItemBinding = DataBindingUtil.inflate(inflater, R.layout.movie_list_item, container, false)
            movieListItemBinding.movie = movie
            binding.movieListLl.addView(movieListItemBinding.root)
            movieListItemBinding.movieListItemCl.setOnClickListener {
                println(movie.title)
                val movieId = movie.posterPath
                val action = MovieListFragmentDirections.actionFirstFragmentToSecondFragment(movieId)
                findNavController().navigate(action)
                //findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            }
        }

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*binding.movieListLl.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}