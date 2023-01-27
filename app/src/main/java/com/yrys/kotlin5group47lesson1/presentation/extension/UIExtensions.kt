package com.yrys.kotlin5group47lesson1.presentation.extension

import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

fun Fragment.showToast(text: String) {
    Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
}

fun Fragment.showToast(@StringRes text: Int) {
    Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
}