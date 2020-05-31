package com.pgsoft.myofficetest.motextrenderer.converter

import android.content.Context

class FontSizeConverter {
    /**  Конвертирует sp в пиксели*/
    fun convertToPixels(sp: Float, context: Context): Float = (sp * context.resources.displayMetrics.scaledDensity)

}