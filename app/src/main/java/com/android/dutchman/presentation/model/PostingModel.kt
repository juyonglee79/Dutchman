package com.android.dutchman.presentation.model

import android.widget.ImageView

data class PostingModel(
    val profileImg : ImageView,
    val profileName : String = "",
    val postingTime : String = "",
    val scrabStatus : ImageView,
    val postingContext: String = "",
    val postingContextImg: ImageView,
    val postingParticipateStatus: String = ""

)