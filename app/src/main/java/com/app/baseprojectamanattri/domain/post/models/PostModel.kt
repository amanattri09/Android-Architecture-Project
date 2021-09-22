package com.app.baseprojectamanattri.domain.post.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PostModel(val body: String,val id: Int,val title: String,val userId: Int) : Parcelable