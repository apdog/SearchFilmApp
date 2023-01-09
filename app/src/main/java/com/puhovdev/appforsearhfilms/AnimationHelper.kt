package com.puhovdev.appforsearhfilms

import android.app.Activity
import android.view.View
import android.view.ViewAnimationUtils
import android.view.animation.AccelerateDecelerateInterpolator
import java.util.concurrent.Executors
import kotlin.math.hypot
import kotlin.math.roundToInt

object AnimationHelper {

    private const val MENU_ITEMS = 4
    private const val COUNT_1 = 1
    private const val COUNT_2 = 2

    fun performFragmentCircularRevealAnimation(rootView: View, activity: Activity, position: Int) {
        Executors.newSingleThreadExecutor().execute {
            while (true) {
                if (rootView.isAttachedToWindow) {
                    activity.runOnUiThread {
                        val itemCenter = rootView.width / (MENU_ITEMS * COUNT_2)
                        val step = (itemCenter * COUNT_2) * (position - COUNT_1) + itemCenter
                        val x: Int = step
                        val y: Int = rootView.y.roundToInt() + rootView.height
                        val startRadius = 0
                        val endRadius = hypot(rootView.width.toDouble(), rootView.height.toDouble())
                        ViewAnimationUtils.createCircularReveal(rootView, x, y, startRadius.toFloat(), endRadius.toFloat()).apply {
                            duration = 500
                            interpolator = AccelerateDecelerateInterpolator()
                            start()
                        }
                        rootView.visibility = View.VISIBLE
                    }
                    return@execute
                }
            }
        }
    }
}