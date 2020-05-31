package com.pgsoft.myofficetest.moformatpanel.formatcommandprocessor.commandsprocessor

import com.pgsoft.myofficetest.common.model.MOTextAttributes
import com.pgsoft.myofficetest.common.model.MOTextTypeface
import com.pgsoft.myofficetest.moformatpanel.formatcommandprocessor.OneCommandProcessor
import com.pgsoft.myofficetest.moformatpanel.model.MOFormatCommand
import com.pgsoft.myofficetest.moformatpanel.model.MOFormatCommandSetItalic

/** Command for changing the Italic attribute */
class ChangeItalicCommandProcessor: OneCommandProcessor {
    override fun <T> process(textAttrs: MOTextAttributes, command: MOFormatCommand<T>): MOTextAttributes? {
        return if (command is MOFormatCommandSetItalic) {
            val newTypeface = MOTextTypeface(textAttrs.typeFace.bold, command.isItalic)
            textAttrs.copy(
                size = textAttrs.size,
                color = textAttrs.color,
                align = textAttrs.align,
                typeFace = newTypeface
            )
        }
        else {
            null
        }
    }
}