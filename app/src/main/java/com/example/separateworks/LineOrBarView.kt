package com.example.separateworks

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View


@SuppressLint("Recycle")
class LineOrBarView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {


    private val decider: Int
    private var paint: Paint = Paint()

    init {
        context.obtainStyledAttributes(attrs, R.styleable.LineOrBarView).apply {
            decider = this.getInt(R.styleable.LineOrBarView_type, 1)
        }

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (decider == 1) {
            drawPrecipitationGraph(canvas)
        } else {
            drawTemperatureGraph(canvas)
        }

    }

    private fun drawTemperatureGraph(canvas: Canvas) {
        paint.reset()
        paint.isAntiAlias = true
        paint.strokeWidth = 15f
        paint.color = Color.parseColor("#b6b7b8")
        //to draw grey lines
        canvas.drawLine(10f, 120f, 50f, 70f, paint)
        canvas.drawLine(41f, 70f, 90f, 120f, paint)
        canvas.drawLine(81f, 120f, 150f, 40f, paint)
        //to draw black lines
        paint.color = Color.parseColor("#24282e")
        canvas.drawLine(10f, 120f, 50f, 70f, paint)
        canvas.drawLine(41f, 70f, 66f, 96f, paint)
        paint.textSize = 60f
        paint.color = Color.parseColor("#707174")
        canvas.drawText("TEMP", 5f, 200f, paint)
    }


    private fun drawPrecipitationGraph(canvas: Canvas) {
        paint.reset()
        paint.isAntiAlias = true
        paint.color = Color.parseColor("#acc3ec")
        canvas.drawRect(10f, 0f, 60f, 100f, paint)
        paint.reset()
        paint.isAntiAlias = true
        paint.color = Color.parseColor("#d0ddf4")
        canvas.drawRect(80f, 50f, 130f, 100f, paint)
        paint.reset()
        paint.isAntiAlias = true
        paint.textSize = 60f
        paint.color = Color.parseColor("#707174")
        canvas.drawText("PRECIP", 10f, 170f, paint)
    }

}