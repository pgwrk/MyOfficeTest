package com.pgsoft.myofficetest.motextrenderer.converter

import android.graphics.Typeface
import com.pgsoft.myofficetest.common.model.MOTextTypeface

class TypefaceConverter {
    fun convert(fontName: String, typeface: MOTextTypeface): Typeface {
        val typeFace = when  {
            typeface.isBoldOnly -> Typeface.BOLD
            typeface.isItalicOnly -> Typeface.ITALIC
            typeface.isBoldAndItalic -> Typeface.BOLD_ITALIC
            else -> Typeface.NORMAL
        }

        return Typeface.create(fontName, typeFace)
    }
}