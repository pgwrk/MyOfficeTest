package com.pgsoft.myofficetest.moformatpanel.formatcommandprocessor

import com.pgsoft.myofficetest.common.model.MOTextAttributes
import com.pgsoft.myofficetest.moformatpanel.formatcommandprocessor.commandsprocessor.*
import com.pgsoft.myofficetest.moformatpanel.model.MOFormatCommand
import org.koin.dsl.module

internal val formatCommandProcessorModule = module {
    single { FormatCommandProcessor() }
}

class FormatCommandProcessor {

    /** List of all possible format command processor */
    private val allCommandsToProcess = listOf(
        ChangeAlignCommandProcessor(),
        ChangeColorCommandProcessor(),
        ChangeBoldCommandProcessor(),
        ChangeItalicCommandProcessor(),
        ChangeSizeCommandProcessor()
    )

    /** Process command. Throws exception if there is no processor for the command specified
     * @param curTextAttrs current text attributes
     * @param formatCommand command to process
     * @return new text attributes  */
    fun<T> process(curTextAttrs: MOTextAttributes, formatCommand: MOFormatCommand<T>): MOTextAttributes {

        var newAttrs: MOTextAttributes? = null

        run loop@{
            allCommandsToProcess.forEach {
                newAttrs = it.process(curTextAttrs, formatCommand)
                if (newAttrs != null) return@loop
            }
        }

        if (newAttrs == null) {
            throw Exception("Command $formatCommand not found")
        }

        return newAttrs!!
    }
}