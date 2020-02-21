package com.example.stickyheaders

import android.content.Context
import android.content.res.Resources
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.util.AttributeSet
import android.widget.Button
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView

class CustomButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        addView(Button(context).apply {
            text = "Button"
            layoutParams = LayoutParams(dpToPx(100), LayoutParams.WRAP_CONTENT)
        })
    }

    private var isSmall = true

    fun setStyle(isSmall: Boolean) {
        if (this.isSmall == isSmall) {
            return
        }
        this.isSmall = isSmall
        setStyle()
    }

    private fun setStyle() {
        TransitionManager.beginDelayedTransition(this)
        if (isSmall) {
            (layoutParams as LayoutParams).width = dpToPx(100)
        } else {
            (layoutParams as LayoutParams).width = dpToPx(300)
        }
        requestLayout()
    }

    fun createFabScrollListener(): RecyclerView.OnScrollListener {
        return object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (Math.abs(dy) > 2) {
                    setStyle(dy < 0)
                }
            }
        }
    }

    private fun dpToPx(dp: Int) = (dp * Resources.getSystem().displayMetrics.density).toInt()
}