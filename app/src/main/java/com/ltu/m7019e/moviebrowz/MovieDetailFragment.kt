package com.ltu.m7019e.moviebrowz

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ltu.m7019e.moviebrowz.databinding.FragmentMovieDetailBinding
import com.ltu.m7019e.moviebrowz.model.Movie


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class MovieDetailFragment : Fragment() {
    private var _binding: FragmentMovieDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var movie: Movie

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMovieDetailBinding.inflate(inflater)
        movie = MovieDetailFragmentArgs.fromBundle(requireArguments()).movie
        binding.movie = movie

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        binding.imdbLink.setOnClickListener{
            val url = movie.detail.getImdbLink()
            try{
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(browserIntent)
            }
            catch (e: android.content.ActivityNotFoundException){
                val alertDialog: AlertDialog? = activity?.let {
                    val builder = AlertDialog.Builder(it)
                    builder.apply {
                        setMessage(R.string.invalid_url)
                        setNegativeButton(R.string.ok
                        ) { _, _ ->
                            // User cancelled the dialog
                        }
                    }
                    // Create the AlertDialog
                    builder.create()
                }
                alertDialog?.show()
            }
        }

        binding.homepageLink.setOnClickListener{
            val url = movie.detail.homepage
            try{
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(browserIntent)
            }
            catch (e: android.content.ActivityNotFoundException){
                val alertDialog: AlertDialog? = activity?.let {
                    val builder = AlertDialog.Builder(it)
                    builder.apply {
                        setMessage(R.string.invalid_homepage)
                        setNegativeButton(R.string.ok
                        ) { _, _ ->
                            // User cancelled the dialog
                        }
                    }
                    // Create the AlertDialog
                    builder.create()
                }
                alertDialog?.show()
            }
        }

        binding.backToMovieList.setOnClickListener {
            findNavController().navigate(MovieDetailFragmentDirections.actionMovieDetailFragmentToMovieListFragment())
        }

        binding.movieReview.setOnClickListener {
            findNavController().navigate(MovieDetailFragmentDirections.actionMovieDetailFragmentToMovieReviewFragment(movie))
        }

    }
}