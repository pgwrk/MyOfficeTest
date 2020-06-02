package com.pgsoft.myofficetest.moformatpanel.control.TypefacePanel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.pgsoft.myofficetest.R
import kotlinx.android.synthetic.main.fragment_typeface_panel.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class TypefacePanelFragment : Fragment() {

    private val viewModel: TypefacePanelViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_typeface_panel, container, false)

        view.bold.setOnClickListener {
            viewModel.onBoldClicked(view.bold.isChecked)
        }

        view.italic.setOnClickListener {
            viewModel.onItalicClicked(view.italic.isChecked)
        }

        return view
    }

}
