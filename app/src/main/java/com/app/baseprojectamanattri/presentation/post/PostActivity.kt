package com.app.baseprojectamanattri.presentation.post

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.app.baseprojectamanattri.R
import com.app.baseprojectamanattri.data.entities.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var button: Button
    private val viewmodel: PostViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_layout)
        button = findViewById(R.id.buttonLoadData)
        button.setOnClickListener(this)
        setUpObserver()
    }

    private fun setUpObserver() {
        viewmodel.posts.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {

                }
                Status.ERROR -> {

                }
                Status.LOADING -> {

                }
            }
        })
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.buttonLoadData -> {
                viewmodel.fetchPost()
            }
        }
    }
}