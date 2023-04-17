package com.ltu.m7019e.moviebrowz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ltu.m7019e.moviebrowz.databinding.FragmentMovieReviewBinding
import com.ltu.m7019e.moviebrowz.model.Movie


/**
 * A simple [Fragment] subclass.
 */
class MovieReviewFragment : Fragment() {

    private var _binding: FragmentMovieReviewBinding? = null
    private val binding get() = _binding!!

    private lateinit var movie: Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMovieReviewBinding.inflate(inflater)
        movie = MovieDetailFragmentArgs.fromBundle(requireArguments()).movie

        binding.movie = movie

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        binding.backToMovieDetail.setOnClickListener {
            findNavController().navigate(MovieReviewFragmentDirections.actionMovieReviewFragmentToMovieDetailFragment(movie))
        }

    }

}
