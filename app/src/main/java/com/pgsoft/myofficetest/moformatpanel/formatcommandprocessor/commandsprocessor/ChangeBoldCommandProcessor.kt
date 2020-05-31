package com.pgsoft.myofficetest.moformatpanel.formatcommandprocessor.commandsprocessor

import com.pgsoft.myofficetest.common.model.MOTextAttributes
import com.pgsoft.myofficetest.common.model.MOTextTypeface
import com.pgsoft.myofficetest.moformatpanel.formatcommandprocessor.OneCommandProcessor
import com.pgsoft.myofficetest.moformatpanel.model.MOFormatCommand
import com.pgsoft.myofficetest.moformatpanel.model.MOFormatCommandSetBold

class ChangeBoldCommandProcessor: OneCommandProcessor {
    override fun <T> process(textAttrs: MOTextAttributes, command: MOFormatCommand<T>): MOTextAttributes? {
        return if (command is MOFormatCommandSetBold) {
            val newTypeface = MOTextTypeface(command.isBold, textAttrs.typeFace.italic)
            textAttrs.copy(
                size = textAttrs.size,
                color = textAttrs.color,
                align = textAttrs.align,
                typeFace = newTypeface)
        }
        else {
            null
        }
    }
}