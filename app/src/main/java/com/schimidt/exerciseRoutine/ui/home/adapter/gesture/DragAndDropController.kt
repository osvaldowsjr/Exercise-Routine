package com.schimidt.exerciseRoutine.ui.home.adapter.gesture

import androidx.recyclerview.widget.ItemTouchHelper
import com.schimidt.exerciseRoutine.ui.home.adapter.WorkoutAdapter

class DragAndDropController(
    val callback: DragCallback,
) :
    ItemTouchHelper(callback)