package com.pgsoft.myofficetest.motextrenderer.converter

import android.text.Layout
import com.pgsoft.myofficetest.common.model.MOTextAlign

class AlignConverter {
    fun convert(textAlign: MOTextAlign?): Layout.Alignment {
        if (textAlign == null) return Layout.Alignment.ALIGN_CENTER

        return when (textAlign) {
            MOTextAlign.CENTER -> Layout.Alignment.ALIGN_CENTER
            MOTextAlign.LEFT -> Layout.Alignment.ALIGN_NORMAL
            MOTextAlign.RIGHT -> Layout.Alignment.ALIGN_OPPOSITE
        }
    }
}