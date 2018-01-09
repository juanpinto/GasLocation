package com.perazzo.gaslocation.utils

import android.graphics.Color
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan

class SpannableUtils {

    companion object {

        fun buildSpannable(title: String, value: String): Spannable {
            val text = SpannableString(title + value)
            text.setSpan(ForegroundColorSpan(Color.BLACK), 0, title.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            return text
        }

    }
}