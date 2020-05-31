package com.pgsoft.myofficetest.moformatpanel.formatcommandprocessor.commandsprocessor

import com.pgsoft.myofficetest.common.model.MOTextAttributes
import com.pgsoft.myofficetest.moformatpanel.formatcommandprocessor.OneCommandProcessor
import com.pgsoft.myofficetest.moformatpanel.model.MOFormatCommand
import com.pgsoft.myofficetest.moformatpanel.model.MOFormatCommandSetColor

/** Command for changing the color attribute */
class ChangeColorCommandProcessor: OneCommandProcessor {

    override fun <T> process(textAttrs: MOTextAttributes, command: MOFormatCommand<T>): MOTextAttributes? {

        return if (command is MOFormatCommandSetColor) {
            textAttrs.copy(size = textAttrs.size, color = command.newColor)
        }
        else {
            null
        }
    }
}