package com.pgsoft.myofficetest.moformatpanel.formatcommandprocessor.commandsprocessor

import com.pgsoft.myofficetest.common.model.MOTextAttributes
import com.pgsoft.myofficetest.moformatpanel.formatcommandprocessor.OneCommandProcessor
import com.pgsoft.myofficetest.moformatpanel.model.MOFormatCommand
import com.pgsoft.myofficetest.moformatpanel.model.MOFormatCommandSetAlign

/** Command for changing the align attribute */
class ChangeAlignCommandProcessor: OneCommandProcessor {
    override fun <T> process(textAttrs: MOTextAttributes, command: MOFormatCommand<T>): MOTextAttributes? {
        return if (command is MOFormatCommandSetAlign) {
            textAttrs.copy(size = textAttrs.size, color = textAttrs.color, align = command.newAlign)
        }
        else {
            null
        }
    }
}