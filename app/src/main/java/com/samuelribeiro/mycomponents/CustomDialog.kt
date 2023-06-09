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
    private var editThirdField: AppCompatEditText = AppCompatEditText(context)
    private var btnNegativeButton: AppCompatButton = AppCompatButton(context)
    private var btnPositiveButton: AppCompatButton = AppCompatButton(context)

    init {
        inflate(context, R.layout.dialog_custom, this)

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.CustomDialog)

        txtTitle = findViewById(R.id.txt_title_dialog)
        editFirstField = findViewById(R.id.edit_first_field)
        editSecondField = findViewById(R.id.edit_second_field)
        editThirdField = findViewById(R.id.edit_third_field)
        btnNegativeButton = findViewById(R.id.btn_negative)
        btnPositiveButton = findViewById(R.id.btn_positive)

        setupNameButtons(attributes)
        setupHintFirstEdit(attributes)
        setupHintSecondEdit(attributes)
        setupHintThirdEdit(attributes)
        setupHowManyFields(attributes)

        attributes.recycle()
    }

    fun setTitleDialog(title: String) {
        txtTitle.text = title
    }

    fun setHintFirstField(textHint: String) {
        editFirstField.hint = textHint
    }

    fun setHintSecondField(textHint: String) {
        editSecondField.hint = textHint
    }

    fun setHintThirdField(textHint: String) {
        editThirdField.hint = textHint
    }

    fun setTextFirstField(txt: String) {
        editFirstField.setText(txt)
    }

    fun setTextSecondField(txt: String) {
        editSecondField.setText(txt)
    }

    fun setTextThirdField(txt: String){
        editThirdField.setText(txt)
    }

    fun getTextFirstField(): String = editFirstField.text.toString()

    fun getTextSecondField(): String = editSecondField.text.toString()

    fun getTextThirdField(): String = editThirdField.text.toString()

    fun setTextColorButtonNegative(color: Int) {
        btnNegativeButton.setTextColor(color)
    }

    fun setBackGroundButtonNegative(drawable: Drawable) {
        btnNegativeButton.background = drawable
    }

    fun setOnClickButtonNegative(onClick: () -> Unit) {
        btnNegativeButton.setOnClickListener { onClick() }
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

    private fun setupHowManyFields(attributes: TypedArray) {
        val fields = attributes.getInt(R.styleable.CustomDialog_howManyFieldsToDisplay, 0)
        when(fields) {
            1 -> {
                editFirstField.visibility = VISIBLE
                editSecondField.visibility = GONE
                editThirdField.visibility = GONE
            }
            2 -> {
                editFirstField.visibility = GONE
                editSecondField.visibility = VISIBLE
                editThirdField.visibility = GONE
            }
            3 -> {
                editFirstField.visibility = GONE
                editSecondField.visibility = GONE
                editThirdField.visibility = VISIBLE
            }
            else -> {
                editFirstField.visibility = VISIBLE
                editSecondField.visibility = VISIBLE
                editThirdField.visibility = VISIBLE
            }
        }
    }

    private fun setupHintFirstEdit(attributes: TypedArray) {
        val hintEditFirstField = attributes.getString(R.styleable.CustomDialog_editTextHintFirstField)
        editFirstField.hint = hintEditFirstField.toString()
    }

    private fun setupHintSecondEdit(attributes: TypedArray) {
        val hintEditSecondField = attributes.getString(R.styleable.CustomDialog_editTextHintSecondField)
        editSecondField.hint = hintEditSecondField.toString()
    }

    private fun setupHintThirdEdit(attributes: TypedArray){
        val hintEditThirdField = attributes.getString(R.styleable.CustomDialog_editTextHintThirdField)
        editThirdField.hint = hintEditThirdField.toString()
    }

    private fun setupNameButtons(attributes: TypedArray) {
        val txtPositiveButton = attributes.getString(R.styleable.CustomDialog_namePositiveButton)
        val txtNegativeButton = attributes.getString(R.styleable.CustomDialog_nameNegativeButton)
        btnPositiveButton.text = txtPositiveButton.toString()
        btnNegativeButton.text = txtNegativeButton.toString()
    }
}
