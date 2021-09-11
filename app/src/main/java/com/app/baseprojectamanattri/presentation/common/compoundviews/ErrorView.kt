package com.app.baseprojectamanattri.presentation.common.compoundviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.app.baseprojectamanattri.databinding.ErrorViewBinding

class ErrorView(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {

    var onRetry : (() -> Unit)? =null

    init {
        var binding = ErrorViewBinding.inflate(LayoutInflater.from(context), this, false)
        binding.imageViewRefresh.setOnClickListener{
            onRetry?.invoke()
        }
    }

}