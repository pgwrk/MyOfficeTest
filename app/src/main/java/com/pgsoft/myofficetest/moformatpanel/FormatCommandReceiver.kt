package com.pgsoft.myofficetest.moformatpanel

import com.pgsoft.myofficetest.moformatpanel.model.MOFormatCommand

interface FormatCommandReceiver {
    fun<T> sendCommand(command: MOFormatCommand<T>)
}