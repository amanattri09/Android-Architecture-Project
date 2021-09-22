package com.app.baseprojectamanattri.presentation.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.app.baseprojectamanattri.R
import com.app.baseprojectamanattri.presentation.common.compoundviews.ErrorView
import com.app.baseprojectamanattri.presentation.common.hideKeyboard

open class BaseFragment<Binding:ViewBinding> : Fragment() {

    lateinit var binding:Binding
    open val onRetry: (() -> Unit)? = null
    val parentActivity: BaseActivity<*>?
        get()= activity as? BaseActivity<*>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<ErrorView>(R.id.errorView)?.onRetry = onRetry
    }

    override fun onPause() {
        super.onPause()
        activity?.hideKeyboard()
    }

    fun onLoading(show: Boolean) {
        var progressBar: View? = view?.findViewById(R.id.progress_bar)
        progressBar?.visibility = if (show) View.VISIBLE else View.GONE
        var errorView: ErrorView? = view?.findViewById(R.id.errorView)
        errorView?.visibility = if (show) View.GONE else View.VISIBLE
        errorView?.onRetry = onRetry
    }

    fun onError(error: Throwable, showErrorView: Boolean) {
        parentActivity?.onError(error,showErrorView)
    }

}