package com.pgsoft.myofficetest.moformatpanel.formatcommandprocessor.commandsprocessor

import com.pgsoft.myofficetest.common.model.MOTextAttributes
import com.pgsoft.myofficetest.moformatpanel.formatcommandprocessor.OneCommandProcessor
import com.pgsoft.myofficetest.moformatpanel.model.MOFormatCommand
import com.pgsoft.myofficetest.moformatpanel.model.MOFormatCommandSetSize

/** Command for changing the size attribute */
class ChangeSizeCommandProcessor: OneCommandProcessor {
    override fun <T> process(textAttrs: MOTextAttributes, command: MOFormatCommand<T>): MOTextAttributes? {
        return if (command is MOFormatCommandSetSize) {
            textAttrs.copy(size = command.newSize)
        }
        else {
            null
        }
    }
}