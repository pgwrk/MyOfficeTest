package com.pgsoft.myofficetest.moformatpanel.control.TypefacePanel

import androidx.lifecycle.ViewModel
import com.pgsoft.myofficetest.moformatpanel.FormatCommandReceiver
import com.pgsoft.myofficetest.moformatpanel.model.MOFormatCommandSetBold
import com.pgsoft.myofficetest.moformatpanel.model.MOFormatCommandSetItalic
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val typefacePanelViewModelModule = module {
    viewModel { TypefacePanelViewModel(get()) }
}

class TypefacePanelViewModel(private val commandReceiver: FormatCommandReceiver): ViewModel() {
    fun onBoldClicked(toggle: Boolean) {
        commandReceiver.sendCommand(MOFormatCommandSetBold(toggle))
    }

    fun onItalicClicked(toggle: Boolean) {
        commandReceiver.sendCommand(MOFormatCommandSetItalic(toggle))
    }
}