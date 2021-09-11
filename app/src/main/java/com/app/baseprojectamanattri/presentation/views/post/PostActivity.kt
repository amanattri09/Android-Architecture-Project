package com.app.baseprojectamanattri.presentation.views.post

import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.baseprojectamanattri.databinding.ActivityPostLayoutBinding
import com.app.baseprojectamanattri.presentation.common.base.BaseActivity
import com.app.baseprojectamanattri.presentation.common.customObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostActivity : BaseActivity<ActivityPostLayoutBinding>() {

    private val viewmodel: PostViewModel by viewModels()
    private lateinit var postRecylarAdapter: PostRecylarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityPostLayoutBinding.inflate(layoutInflater))
        setViews()
        init()
        setUpObserver()
    }

    private fun init() {
        viewmodel.fetchPostByRx()
    }

    private fun setViews() {
        binding.rvPosts.layoutManager = LinearLayoutManager(this)
        binding.rvPosts.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        postRecylarAdapter = PostRecylarAdapter()
        binding.rvPosts.adapter = postRecylarAdapter
    }

    private fun setUpObserver() {
        viewmodel.getPosts().customObserver(
            this,
            onLoading = ::onLoading,
            onSuccess = {
                postRecylarAdapter.setData(it)
            },
            onError = ::onError
        )
    }

}






