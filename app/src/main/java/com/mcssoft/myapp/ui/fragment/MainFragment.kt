package com.mcssoft.myapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mcssoft.myapp.R
import kotlinx.android.synthetic.main.toolbar_base.*

class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity?.id_toolbar)?.title = ""

        // If bottom nav view was previously hidden, then show again.
        val bnv = activity?.findViewById(R.id.id_bottom_nav_view) as BottomNavigationView
        if(bnv.visibility == View.GONE) {
            bnv.visibility = View.VISIBLE
        }
    }
}