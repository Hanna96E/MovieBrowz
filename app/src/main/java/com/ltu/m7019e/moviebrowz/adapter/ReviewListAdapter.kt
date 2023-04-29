package com.ltu.m7019e.moviebrowz.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ltu.m7019e.moviebrowz.databinding.ReviewListItemBinding
import com.ltu.m7019e.moviebrowz.model.MovieReview

class ReviewListAdapter() :  ListAdapter<MovieReview, ReviewListAdapter.ViewHolder>(MovieReviewDiffCallback()){
    class ViewHolder(private var binding: ReviewListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movieReview: MovieReview) {
            binding.movieReview = movieReview
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup) : ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ReviewListItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class MovieReviewDiffCallback : DiffUtil.ItemCallback<MovieReview>() {
    override fun areItemsTheSame(oldItem: MovieReview, newItem: MovieReview): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MovieReview, newItem: MovieReview): Boolean {
        return oldItem == newItem
    }

}