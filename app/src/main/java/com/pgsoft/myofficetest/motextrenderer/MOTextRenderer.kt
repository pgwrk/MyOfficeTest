package com.pgsoft.myofficetest.motextrenderer

import android.content.Context
import android.graphics.*
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.pgsoft.myofficetest.motextrenderer.converter.AlignConverter
import com.pgsoft.myofficetest.motextrenderer.converter.FontSizeConverter
import com.pgsoft.myofficetest.motextrenderer.converter.TypefaceConverter
import org.koin.java.KoinJavaComponent.inject
import java.lang.ref.WeakReference


/**
 * View which can render formatted text
 */
class MOTextRenderer : View {

    private var textPaint: TextPaint = TextPaint()

    private lateinit var textLayout: StaticLayout
    private val viewModel: TextRendererViewModel by inject(TextRendererViewModel::class.java)
    private lateinit var lifecycleOwner: WeakReference<LifecycleOwner>

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle)

    fun setLifecycleOwner(lifecycleOwner: LifecycleOwner) {
        this.lifecycleOwner = WeakReference(lifecycleOwner)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        Log.d("MOTT", "onMeasure. width=$width")
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        Log.d("MOTT", "onSizeChanged: w=$w, h=$h, oldw=$oldw, oldh=$oldh")
        changeStaticLayout()
        //viewModel.setDimensions(w, h, textLayout.width, textLayout.height)

        if (oldh == 0 || oldw == 0) {
            bindViewModel()
        }

        super.onSizeChanged(w, h, oldw, oldh)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)

        Log.d("MOTT", "onLayout. width=$width")
    }

    override fun onDraw(canvas: Canvas) {

        super.onDraw(canvas)

        Log.d("MOTT", "post super.onDraw")

        canvas.save()

        val point = viewModel.getTextPosition(width, height, textLayout.width, textLayout.height)
        canvas.translate(point.x, point.y)

        //draws static layout on canvas
        textLayout.draw(canvas)
        canvas.restore()
    }

    private fun bindViewModel() {
        viewModel.textChangedLiveData.observe(lifecycleOwner.get()!!, Observer {
            updateTextAttrsAndRedraw()
        })
    }

    private fun updateTextAttrsAndRedraw() {
        viewModel.textAttributes?.let {
            textAttrs ->

            textPaint.textSize = FontSizeConverter().convertToPixels(textAttrs.size, context)
            textPaint.color = Color.parseColor(textAttrs.color)
            textPaint.typeface = TypefaceConverter().convert(textAttrs.fontName, textAttrs.typeFace)

            changeStaticLayout()

            invalidate()
        }


    }

    private fun changeStaticLayout() {

        val align = AlignConverter().convert(viewModel.textAttributes?.align)
        textLayout = StaticLayout.Builder.obtain(viewModel.text, 0, viewModel.text.length, textPaint, width - paddingStart - paddingEnd)
            .setAlignment(align)
            .build()
    }

}
