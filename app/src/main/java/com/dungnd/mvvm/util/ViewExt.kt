package com.dungnd.mvvm.util

import android.view.View
import com.dungnd.mvvm.listener.OnSingleClickListener

fun View.setOnSingClickListener(onClick: (View) -> Unit) {
    setOnClickListener(object : OnSingleClickListener() {
        override fun onSingleClick(view: View) {
            onClick.invoke(view)
        }
    })
}