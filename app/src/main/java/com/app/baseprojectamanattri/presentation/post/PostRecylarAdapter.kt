package com.app.baseprojectamanattri.presentation.post

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.baseprojectamanattri.databinding.ItemPostBinding
import com.app.baseprojectamanattri.domain.post.models.PostModel

class PostRecylarAdapter : RecyclerView.Adapter<PostRecylarAdapter.PostViewHolder>() {

    private var posts= ArrayList<PostModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        var binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(posts.get(position))
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    fun setData(posts: ArrayList<PostModel>) {
        this.posts.clear()
        this.posts.addAll(posts)
        notifyDataSetChanged()
    }

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding: ItemPostBinding = ItemPostBinding.bind(itemView)
        fun bind(post: PostModel) {
            binding.textView.setText( post.title)
        }

    }
}