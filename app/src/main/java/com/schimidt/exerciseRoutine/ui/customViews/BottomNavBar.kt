package com.schimidt.exerciseRoutine.ui.customViews

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.badge.BadgeUtils
import com.google.android.material.bottomappbar.BottomAppBar
import com.schimidt.exerciseRoutine.R
import com.schimidt.exerciseRoutine.databinding.AppBottomBarBinding

class BottomNavBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : BottomAppBar(context, attrs) {

    val binding: AppBottomBarBinding =
        AppBottomBarBinding.inflate(LayoutInflater.from(context), this, true)
    private val badge = BadgeDrawable.create(context)

    fun setFabAction(action: () -> Unit) {
        binding.buttonAdd.setOnClickListener {
            action()
        }
    }

    fun setFabIcon(drawable: Drawable?) {
        binding.buttonAdd.setImageDrawable(drawable)
    }

    fun setEndIcon(drawable: Drawable?) {
        val menu = binding.bottomNav.menu.getItem(0)
        menu.icon = drawable
    }


    @SuppressLint("UnsafeOptInUsageError")
    fun setBadgeOnEndIcon() {
        BadgeUtils.attachBadgeDrawable(badge, binding.bottomNav, R.id.workout_list_fragment)
        badge.isVisible = false
    }

    fun updateBadgeNumber(newValue: Int) {
        if (newValue == 0) {
            badge.isVisible = false
        } else {
            badge.number = newValue
            badge.isVisible = true
        }
    }
}