package com.app.baseprojectamanattri.ui.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.app.baseprojectamanattri.R

class SampleActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var button: Button
    private lateinit var viewmodel: SampleActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_layout)
        button = findViewById(R.id.buttonLoadData)
        button.setOnClickListener(this)
        setUpViewModel()
    }

    private fun setUpViewModel() {

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.buttonLoadData -> {

            }
        }
    }
}