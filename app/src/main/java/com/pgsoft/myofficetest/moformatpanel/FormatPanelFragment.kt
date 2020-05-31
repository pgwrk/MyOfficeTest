package com.pgsoft.myofficetest.moformatpanel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.pgsoft.myofficetest.R
import kotlinx.android.synthetic.main.fragment_format_panel.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class FormatPanelFragment : Fragment() {

    private val viewModel: FormatPanelViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel.activate()

        val view = inflater.inflate(R.layout.fragment_format_panel, container, false)
        view.increaseDecreaseControl.setLifecycleOwner(viewLifecycleOwner)

        view.startTest.setOnClickListener {
            viewModel.testCommands()
        }

        return view
    }

}
