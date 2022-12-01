package com.schimidt.exerciseRoutine.ui.home.adapter.gesture

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.schimidt.exerciseRoutine.model.entity.Workout
import com.schimidt.exerciseRoutine.ui.home.adapter.WorkoutAdapter
import java.util.*

class DragCallback(private val adapter: WorkoutAdapter) :
    ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN, 0) {
    private val list: MutableList<Workout> = mutableListOf()

    fun updateList(newList: MutableList<Workout>) {
        list.clear()
        list.addAll(newList)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {

        viewHolder.itemView.elevation = 16F

        val from = viewHolder.adapterPosition
        val to = target.adapterPosition

        Collections.swap(list, from, to)
        adapter.notifyItemMoved(from, to)
        return true
    }

    override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
        super.onSelectedChanged(viewHolder, actionState)
        viewHolder?.itemView?.elevation = 0F
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) = Unit
}