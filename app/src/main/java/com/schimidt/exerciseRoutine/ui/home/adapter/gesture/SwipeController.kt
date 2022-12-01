package com.schimidt.exerciseRoutine.ui.home.adapter.gesture

import androidx.recyclerview.widget.ItemTouchHelper

class SwipeController(
    val callback: SwipeCallback
) :
    ItemTouchHelper(callback)