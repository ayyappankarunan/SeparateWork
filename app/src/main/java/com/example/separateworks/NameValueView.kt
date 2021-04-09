package com.example.separateworks


import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView


class NameValueView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var nameTextView: TextView? = null
    private var valueTextView: TextView? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.name_value_view, this)
        nameTextView = findViewById(R.id.name)
        valueTextView = findViewById(R.id.value)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.NameValueView)
        var nameText = typedArray.getString(R.styleable.NameValueView_name)
        var valueText = typedArray.getString(R.styleable.NameValueView_value)

        nameText = nameText ?: ""
        valueText = valueText ?: ""

        nameTextView!!.text = nameText
        valueTextView!!.text = valueText

        typedArray.recycle()
    }


    fun setNameText(text: String?) {
        nameTextView!!.text = text
    }

    fun setValueText(text: String?) {
        valueTextView!!.text = text
    }

    fun getNameText(): String {
        return nameTextView!!.text.toString()
    }

    fun getValueText(): String {
        return valueTextView!!.text.toString()
    }
}
