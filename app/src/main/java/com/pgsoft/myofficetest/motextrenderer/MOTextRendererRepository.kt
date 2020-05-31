package com.pgsoft.myofficetest.motextrenderer

import android.content.Context

import com.pgsoft.myofficetest.R


class MOTextRendererRepository(private val context: Context) {

    fun getText(): String {
        return context.getString(R.string.text_to_render)
    }

}