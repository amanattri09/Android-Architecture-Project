package com.app.baseprojectamanattri.ui.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.app.baseprojectamanattri.R
import com.app.baseprojectamanattri.data.FactoryDataSource
import com.app.baseprojectamanattri.data.models.Status
import com.app.baseprojectamanattri.data.repo.Repositary
import com.app.baseprojectamanattri.ui.base.ViewModelFactory

class SampleActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var button: Button
    private lateinit var viewmodel: SampleActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_layout)
        button = findViewById(R.id.buttonLoadData)
        button.setOnClickListener(this)
        setUpViewModel()
        setUpObserver()
    }

    private fun setUpObserver() {
        viewmodel.posts.observe(this, Observer {
            when(it.status){
                Status.SUCCESS->{

                }
                Status.ERROR->{

                }
                Status.LOADING->{

                }
            }
        })
    }

    private fun setUpViewModel() {
        viewmodel=ViewModelProviders.of(this,ViewModelFactory(Repositary(FactoryDataSource()))).get(SampleActivityViewModel::class.java)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.buttonLoadData -> {
                viewmodel.fetchPost()
            }
        }
    }
}