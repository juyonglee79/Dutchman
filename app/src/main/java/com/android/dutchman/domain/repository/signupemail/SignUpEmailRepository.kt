package com.android.dutchman.domain.repository.signupemail

import android.content.Context

interface SignUpEmailRepository {
    fun getContext(context: Context): Context {
        return context
    }
}