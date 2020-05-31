package com.pgsoft.myofficetest.moformatpanel.formatcommandprocessor

import com.pgsoft.myofficetest.common.model.MOTextAttributes
import com.pgsoft.myofficetest.moformatpanel.model.MOFormatCommand

/** Common interface for format command  */
interface OneCommandProcessor   {
    /** Process one format command
     * @param textAttrs - current text attributes
     * @param command - command to process
     * @return null if cannot process command or new text attributes */
    fun<T> process(textAttrs: MOTextAttributes, command: MOFormatCommand<T>): MOTextAttributes?
}