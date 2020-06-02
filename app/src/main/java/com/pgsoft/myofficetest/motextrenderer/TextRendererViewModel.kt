package com.pgsoft.myofficetest.motextrenderer

import android.util.Log
import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pgsoft.myofficetest.common.interfaces.AttributesTextReceiver
import com.pgsoft.myofficetest.common.model.MOTextAttributes
import com.pgsoft.myofficetest.motextrenderer.model.MOPoint
import com.pgsoft.myofficetest.motextrenderer.model.MOSize
import org.koin.dsl.bind
import org.koin.dsl.module

internal val textRendererViewModelModule = module {
    single { TextRendererViewModel(get()) } bind AttributesTextReceiver::class
    single { MOTextRendererRepository(get()) }

}

internal class TextRendererViewModel(private val repo: MOTextRendererRepository): AttributesTextReceiver {

    private val _textFormatChangedLiveData = MutableLiveData<Unit>()
    val textChangedLiveData: LiveData<Unit> = _textFormatChangedLiveData

    val text: String
    get() = if (_textAttributes != null) _text else ""

    private val _text: String = repo.getText()

    val textAttributes: MOTextAttributes?
    get() = _textAttributes
    private var _textAttributes: MOTextAttributes? = null

    private lateinit var viewSize: MOSize
    private lateinit var textSize: MOSize

    init {
        Log.d("MOTT", "MOTextRendererViewModel.init()")
    }


    fun getTextPosition(viewWidth: Int, viewHeight: Int, textWidth: Int, textHeight: Int):MOPoint {

//        if (viewSize.isNullOrZero() || textSize.isNullOrZero() ) {
//            throw IllegalArgumentException("Dimensions were not specified")
//        }

        val x = (viewWidth - textWidth) / 2f
        val y = (viewHeight - textHeight) / 2f

        return MOPoint(x, y)
    }

    override fun setTextAttributes(textAttributes: MOTextAttributes) {
        _textAttributes = textAttributes
        _textFormatChangedLiveData.value = Unit
    }


}