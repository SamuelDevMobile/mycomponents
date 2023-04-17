package com.samuelribeiro.mycomponents

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout

class CustomDialog(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    private var txtTitle: AppCompatTextView = AppCompatTextView(context)
    private var editFirstField: AppCompatEditText = AppCompatEditText(context)
    private var editSecondField: AppCompatEditText = AppCompatEditText(context)
    private var btnNegativeButton: AppCompatButton = AppCompatButton(context)
    private var btnPositiveButton: AppCompatButton = AppCompatButton(context)

    init {
        inflate(context, R.layout.dialog_custom, this)

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.CustomDialog)

        txtTitle = findViewById(R.id.txt_title_dialog)
        editFirstField = findViewById(R.id.edit_first_field)
        editSecondField = findViewById(R.id.edit_second_field)
        btnNegativeButton = findViewById(R.id.btn_negative)
        btnPositiveButton = findViewById(R.id.btn_positive)

        setupNameButtons(attributes)
        setupHintFirstEdit(attributes)
        setupHintSecondEdit(attributes)

        attributes.recycle()
    }

    fun setTitleDialog(title: String) {
        txtTitle.text = title
    }

    fun setTextColorButtonNegative(color: Int) {
        btnNegativeButton.setTextColor(color)
    }

    fun setBackGroundButtonNegative(drawable: Drawable) {
        btnNegativeButton.background = drawable
    }

    fun setTextColorButtonPositive(color: Int) {
        btnPositiveButton.setTextColor(color)
    }

    fun setBackGroundButtonPositive(drawable: Drawable) {
        btnPositiveButton.background = drawable
    }

    fun setOnClickButtonPositive(onClick: () -> Unit) {
        btnPositiveButton.setOnClickListener { onClick() }
    }

    fun setOnClickButtonNegative(onClick: () -> Unit) {
        btnPositiveButton.setOnClickListener { onClick() }
    }

    private fun setupHintSecondEdit(attributes: TypedArray) {
        val hintEditSecondField = attributes.getString(R.styleable.CustomDialog_editTextHintSecondField)
        editSecondField.visibility = View.VISIBLE
        setHintSecondEdit(hintEditSecondField)
    }

    private fun setHintSecondEdit(hintEditSecondField: String?) {
        editSecondField.hint = hintEditSecondField.toString()
    }

    private fun setupHintFirstEdit(attributes: TypedArray) {
        val hintEditFirstField = attributes.getString(R.styleable.CustomDialog_editTextHintFirstField)
        editFirstField.visibility = View.VISIBLE
        setHintFirstEdit(hintEditFirstField)
    }

    private fun setHintFirstEdit(hintEditFirstField: String?) {
        editFirstField.hint = hintEditFirstField.toString()
    }

    private fun setupNameButtons(attributes: TypedArray) {
        val txtPositiveButton = attributes.getString(R.styleable.CustomDialog_namePositiveButton)
        val txtNegativeButton = attributes.getString(R.styleable.CustomDialog_nameNegativeButton)
        setTextButton(txtPositiveButton, txtNegativeButton)
    }

    private fun setTextButton(namePositiveButton: String?, nameNegativeButton: String?) {
        btnPositiveButton.text = namePositiveButton.toString()
        btnNegativeButton.text = nameNegativeButton.toString()
    }
}
