package com.learning.servicesexample.adapters

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter(value = ["visibleGone"])
fun visibility(view: View, visible: Boolean) {
    if (visible) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}
