package com.pgsoft.myofficetest.di

import com.pgsoft.myofficetest.moformatpanel.control.IncreaseDecreaseControl.increaseDecreaseControlViewModelModule
import com.pgsoft.myofficetest.moformatpanel.control.TypefacePanel.typefacePanelViewModelModule
import com.pgsoft.myofficetest.moformatpanel.formatPanelViewModelModule
import com.pgsoft.myofficetest.moformatpanel.formatcommandprocessor.formatCommandProcessorModule
import com.pgsoft.myofficetest.motextrenderer.textRendererViewModelModule

val textRenderModules = listOf(textRendererViewModelModule)
val formatPanelModules = listOf(formatPanelViewModelModule,
    formatCommandProcessorModule,
    increaseDecreaseControlViewModelModule,
    typefacePanelViewModelModule
)

val koinModules = textRenderModules + formatPanelModules