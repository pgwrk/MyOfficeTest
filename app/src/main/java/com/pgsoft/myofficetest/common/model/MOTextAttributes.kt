package com.pgsoft.myofficetest.common.model

class MOTextTypeface(val bold: Boolean, val italic: Boolean) {

    val isNormal = !bold && !italic
    val isBoldOnly= bold && !italic
    val isItalicOnly = !bold && italic
    val isBoldAndItalic = bold && italic
}

enum class MOTextAlign {
    LEFT, CENTER, RIGHT
}

data class MOTextAttributes(var size: Float,
                            var color: String,
                            var align: MOTextAlign,
                            var typeFace: MOTextTypeface,
                            var fontName: String)