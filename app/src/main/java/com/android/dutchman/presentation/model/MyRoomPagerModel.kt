package com.android.dutchman.presentation.model

import android.graphics.drawable.Drawable

data class MyRoomPagerModel(
    var profileImg: Int,
    val profileName: String = "",
    val postingContext: String = "",
    val postingParticipateStatus: String = ""
)