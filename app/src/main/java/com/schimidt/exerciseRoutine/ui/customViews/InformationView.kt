package com.schimidt.exerciseRoutine.ui.customViews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.schimidt.exerciseRoutine.databinding.InformationLayoutBinding

class InformationView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    val binding = InformationLayoutBinding.inflate(LayoutInflater.from(context), this, true)


}