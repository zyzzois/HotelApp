package com.example.reservation.util

import android.text.Editable
import android.text.TextWatcher

class NumberMaskValidator : TextWatcher {
    private var sb = StringBuilder()
    private var ignore = false
    private val numPlace = 'X'
    override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
    override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
    override fun afterTextChanged(editable: Editable) {
        if (!ignore) {
            removeFormat(editable.toString())
            applyFormat(sb.toString())
            ignore = true
            editable.replace(0, editable.length, sb.toString())
            ignore = false
        }
    }

    private fun removeFormat(text: String) {
        sb.setLength(0)
        for (element in text)
            if (isNumberChar(element))
                sb.append(element)

    }

    private fun applyFormat(text: String) {
        val template = getTemplate(text)
        sb.setLength(0)
        var i = 0
        var textIndex = 0
        while (i < template.length && textIndex < text.length) {
            if (template[i] == numPlace) {
                sb.append(text[textIndex])
                textIndex++
            } else sb.append(template[i])

            i++
        }
    }

    private fun isNumberChar(c: Char): Boolean {
        return c in '0'..'9'
    }

    private fun getTemplate(text: String): String {
        if (text.startsWith("380")) {
            return "+XXX (XXX) XX-XX-XX"
        }
        if (text.startsWith("7")) {
            return "+X (XXX) XXX-XX-XX"
        }
        return if (text.startsWith("49")) {
            "+XX-XX-XXX-XXXXX"
        } else "+XXX (XXX) XX-XX-XX"
    }
}