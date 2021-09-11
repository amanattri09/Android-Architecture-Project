package com.app.baseprojectamanattri.presentation.common.compoundviews

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.app.baseprojectamanattri.R

class AppProgressBar @JvmOverloads constructor(context: Context, attrs: AttributeSet?) :
    FrameLayout(context, attrs) {
    init {
       View.inflate(context, R.layout.progress_bar,this)
    }
}