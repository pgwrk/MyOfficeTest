package com.pgsoft.myofficetest.moformatpanel.control.IncreaseDecreaseControl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pgsoft.myofficetest.moformatpanel.FormatCommandReceiver
import com.pgsoft.myofficetest.moformatpanel.model.MOFormatCommandSetSize
import org.koin.dsl.module

val increaseDecreaseControlViewModelModule = module {
    factory { IncreaseDecreaseControlViewModel(get())}
}

class IncreaseDecreaseControlViewModel(private val commandReceiver: FormatCommandReceiver) {

    private val _rxCurValue = MutableLiveData<Int>()
    val rxCurValue: LiveData<Int> = _rxCurValue

    private var curValue: Int = 18
    private val MAX_VALUE = 30
    private val MIN_VALUE = 8

    init {
        updateValue()
    }

    fun onIncrease() {
        if (curValue < MAX_VALUE ) {
            curValue++
            updateValue()
        }
    }

    fun onDecrease() {
        if (curValue > MIN_VALUE) {
            curValue--
            updateValue()
        }
    }

    private fun updateValue() {
        _rxCurValue.value = curValue
        commandReceiver.sendCommand(MOFormatCommandSetSize(curValue.toFloat()))
    }

}