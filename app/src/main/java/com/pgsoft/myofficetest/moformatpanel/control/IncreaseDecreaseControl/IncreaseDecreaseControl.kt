package com.pgsoft.myofficetest.moformatpanel.control.IncreaseDecreaseControl

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.pgsoft.myofficetest.R
import kotlinx.android.synthetic.main.increase_decrease_control.view.*
import org.koin.java.KoinJavaComponent.inject
import java.lang.ref.WeakReference

class IncreaseDecreaseControl(context: Context,
                              attrs: AttributeSet?,
                              defStyle:Int): LinearLayout(context, attrs, defStyle) {

    constructor(context: Context, attrs: AttributeSet?) :this(context, attrs, 0)
    constructor(context: Context) :this(context, null, 0)

    private val viewModel: IncreaseDecreaseControlViewModel by inject(IncreaseDecreaseControlViewModel::class.java)
    private lateinit var lifecycleOwner: WeakReference<LifecycleOwner>


    private val view: View = LinearLayout.inflate(context, R.layout.increase_decrease_control, this)

    init {
        view.decrease.setOnClickListener {
            viewModel.onDecrease()
        }

        view.increase.setOnClickListener {
            viewModel.onIncrease()
        }
    }

    fun setLifecycleOwner(lifecycleOwner: LifecycleOwner) {
        this.lifecycleOwner = WeakReference(lifecycleOwner)
        bindViewModel()
    }

    private fun bindViewModel() {
        viewModel.rxCurValue.observe(lifecycleOwner.get()!!, Observer {
            view.curSize.text = it.toString()
        })
    }
}