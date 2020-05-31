package com.pgsoft.myofficetest.moformatpanel.model

import com.pgsoft.myofficetest.common.model.MOTextAlign

/* All format commands for setting text attributes
*
* To add new command you have to
*
* 1. Inherit new command class from MOFormatCommand
* 2. Add new command processor inherited from OneCommandProcessor
* 3. Add this processor to list of all command processors to FormatCommandProcessor.allCommandsToProcess
* 4. GET A PROFIT :)
*
* */

/** Super class for all format commands */
sealed class MOFormatCommand<out T> (val data: T)

/** Set/Unset bold  */
class MOFormatCommandSetBold(val isBold: Boolean): MOFormatCommand<Boolean>(isBold)

/** Set/Unset italic  */
class MOFormatCommandSetItalic(val isItalic: Boolean): MOFormatCommand<Boolean>(isItalic)

/** Set/Unset text size  */
class MOFormatCommandSetSize(val newSize: Float): MOFormatCommand<Float>(newSize)

/** Set align  */
class MOFormatCommandSetAlign(val newAlign: MOTextAlign): MOFormatCommand<MOTextAlign>(newAlign)

/** Set color  */
class MOFormatCommandSetColor(val newColor: String): MOFormatCommand<String>(newColor)