package com.pgsoft.myofficetest.moformatpanel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pgsoft.myofficetest.common.interfaces.AttributesTextReceiver
import com.pgsoft.myofficetest.common.model.MOTextAlign
import com.pgsoft.myofficetest.common.model.MOTextAttributes
import com.pgsoft.myofficetest.common.model.MOTextTypeface
import com.pgsoft.myofficetest.moformatpanel.formatcommandprocessor.FormatCommandProcessor
import com.pgsoft.myofficetest.moformatpanel.model.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

internal val formatPanelViewModelModule = module {
    single { FormatPanelViewModel(get(), get()) } bind FormatCommandReceiver::class
}

class FormatPanelViewModel(private val attributesReceiver: AttributesTextReceiver,
                           private val commandProcessor: FormatCommandProcessor): ViewModel(), FormatCommandReceiver {


    private var textAttrs = MOTextAttributes(18f,
        "#33b5e5",
        MOTextAlign.CENTER,
        MOTextTypeface(false, false),
        "Arial")

    fun activate() {

        attributesReceiver.setTextAttributes(textAttrs)
    }


    override fun <T> sendCommand(command: MOFormatCommand<T>) {
        textAttrs = commandProcessor.process(textAttrs, command)
        attributesReceiver.setTextAttributes(textAttrs)
    }

    /** For testing purposes */
    var testInProgress = false
    fun testCommands() = viewModelScope.launch(Dispatchers.Main) {

        if (testInProgress) {
            return@launch
        }

        testInProgress = true

        //var textAttrs: MOTextAttributes = defaultAttrs

        val testCommand = listOf(
            MOFormatCommandSetColor("#e03616"),
            MOFormatCommandSetSize(19f),
            MOFormatCommandSetSize(22f),
            MOFormatCommandSetItalic(true),
            MOFormatCommandSetBold(true),
            MOFormatCommandSetAlign(MOTextAlign.LEFT),
            MOFormatCommandSetAlign(MOTextAlign.RIGHT),
            MOFormatCommandSetAlign(MOTextAlign.CENTER)
        )

        testCommand.forEach {
            command ->

            textAttrs = commandProcessor.process(textAttrs, command)
            attributesReceiver.setTextAttributes(textAttrs)
            delay(1000)
        }

        testInProgress = false
    }


}