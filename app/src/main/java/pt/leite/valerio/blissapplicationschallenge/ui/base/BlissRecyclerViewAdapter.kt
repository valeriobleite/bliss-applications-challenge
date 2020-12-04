package pt.leite.valerio.blissapplicationschallenge.ui.base

import androidx.recyclerview.widget.RecyclerView

abstract class BlissRecyclerViewAdapter<MODEL>(private val items: MutableList<MODEL> = mutableListOf()) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount() = items.size

    fun setItems(items: List<MODEL>) {
        clear(false)
        addItems(items)
    }

    fun getItems() = items

    fun getItem(index: Int): MODEL? {
        return if (items.isNotEmpty() && index >= 0 && index < items.size) this.items[index] else null
    }

    fun addItems(items: List<MODEL>, notify: Boolean = true) {
        if (items.isNotEmpty())
            this.items.addAll(items)
        if (notify) notifyDataSetChanged()
    }

    fun removeItem(item: MODEL) {
        val indexOfItem = this.items.indexOf(item)

        if (indexOfItem != -1) {
            removeItemAt(indexOfItem)
        }
    }

    private fun removeItemAt(position: Int) {
        if (position >= 0) {
            this.items.removeAt(position)
            this.notifyItemRemoved(position)
        }
    }

    private fun clear(notify: Boolean = true) {
        items.clear()
        if (notify) notifyDataSetChanged()
    }

}