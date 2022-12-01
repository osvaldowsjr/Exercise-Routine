package com.schimidt.exerciseRoutine.ui.home.adapter.gesture

import android.content.res.Resources
import android.content.res.Resources.Theme
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.util.DisplayMetrics
import android.util.TypedValue
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.schimidt.exerciseRoutine.R
import com.schimidt.exerciseRoutine.model.entity.Workout
import com.schimidt.exerciseRoutine.ui.home.adapter.WorkoutAdapter
import com.schimidt.exerciseRoutine.ui.home.adapter.WorkoutViewHolder
import kotlin.math.abs
import kotlin.math.roundToInt

class SwipeCallback(
    val adapter: WorkoutAdapter,
    val resources: Resources,
    val theme: Theme,
    val editAction: (Workout) -> Unit
) : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {

    private val list: MutableList<Workout> = mutableListOf()

    fun updateList(newList: MutableList<Workout>) {
        list.clear()
        list.addAll(newList)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ) = true

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        viewHolder as WorkoutViewHolder
        val pos = viewHolder.adapterPosition
        val fakeList = list
        if (direction == ItemTouchHelper.RIGHT) {
            fakeList.removeAt(pos)
            adapter.submitList(fakeList)
            adapter.notifyItemRemoved(pos)
        }
        if (direction == ItemTouchHelper.LEFT) {
            viewHolder.workout?.let { editAction(it) }
        }
    }

    override fun onChildDraw(
        canvas: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        val displayMetrics: DisplayMetrics = resources.displayMetrics
        val width = (displayMetrics.widthPixels / displayMetrics.density).toInt().dp

        val deleteIcon =
            ResourcesCompat.getDrawable(resources, R.drawable.icon_delete,theme)
        val editIcon = ResourcesCompat.getDrawable(resources, R.drawable.icon_edit, theme)

        val deleteColor = resources.getColor(android.R.color.holo_red_light, theme)
        val editColor = resources.getColor(android.R.color.holo_orange_light, theme)


        when {
            abs(dX) < width / 3 -> canvas.drawColor(Color.GRAY)
            dX > width / 3 -> canvas.drawColor(deleteColor)
            else -> canvas.drawColor(editColor)
        }

        //2. Printing the icons
        val textMargin = resources.getDimension(R.dimen.text_margin).roundToInt()
        deleteIcon?.bounds = Rect(
            textMargin,
            viewHolder.itemView.top + textMargin + 8.dp,
            textMargin + deleteIcon?.intrinsicWidth!!,
            viewHolder.itemView.top + deleteIcon.intrinsicHeight + textMargin + 8.dp
        )
        editIcon?.bounds = Rect(
            width - textMargin - editIcon?.intrinsicWidth!!,
            viewHolder.itemView.top + textMargin + 8.dp,
            width - textMargin,
            viewHolder.itemView.top + editIcon.intrinsicHeight + textMargin + 8.dp
        )

        //3. Drawing icon based upon direction swiped
        if (dX > 0) deleteIcon.draw(canvas) else editIcon.draw(canvas)


        super.onChildDraw(canvas, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
    }

    private val Int.dp
        get() = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, toFloat(), resources.displayMetrics
        ).roundToInt()
}