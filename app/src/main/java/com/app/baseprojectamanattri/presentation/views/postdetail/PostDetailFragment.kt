package com.app.baseprojectamanattri.presentation.views.postdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.viewModels
import android.view.ViewGroup
import com.app.baseprojectamanattri.R
import com.app.baseprojectamanattri.databinding.PostDetailFragmentBinding
import com.app.baseprojectamanattri.domain.post.models.PostModel
import com.app.baseprojectamanattri.presentation.common.base.BaseFragment
import com.app.baseprojectamanattri.presentation.common.customObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostDetailFragment : BaseFragment<PostDetailFragmentBinding>() {

    companion object {
        private const val EXTRAS_POST_MODEL = "extras_post_model"
        fun newInstance(postModel: PostModel): PostDetailFragment {
            var fragment=PostDetailFragment()
            Bundle().apply {
                putParcelable(EXTRAS_POST_MODEL,postModel)
            }.run {
                fragment.arguments=this
            }
            return fragment
        }
    }

    private  val viewModel: PostDetailViewModel  by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding=PostDetailFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init(arguments?.getParcelable<PostModel>(EXTRAS_POST_MODEL))
        setObervers()
        setViews()
    }

    private fun setViews() {
        parentActivity?.getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        parentActivity?.getSupportActionBar()?.setDisplayShowHomeEnabled(true);
        parentActivity?.supportActionBar?.setTitle(getString(R.string.post_detail))
    }

    private fun init(postModel: PostModel?) {
        postModel?.id.let {
            viewModel.getPostDetail(it.toString())
        }
    }

    private fun setObervers() {
        viewModel.getPostModelLiveData().customObserver(this,onLoading=::onLoading,
        onSuccess={
            setPostDetail(it)
        },
        onError=::onError
        )
    }

    private fun setPostDetail(postModel: PostModel) {
        binding.tvPostDetail.text="Title : ${postModel.title}\n" +
                "\nBody :  ${postModel.body}"
    }

}