package com.example.stickyheaders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.AbstractHeaderItem
import eu.davidea.flexibleadapter.items.IFlexible
import eu.davidea.viewholders.FlexibleViewHolder
import kotlinx.android.synthetic.main.header_item.view.*

class AdapterHeaderItem(private val title: String) : AbstractHeaderItem<AdapterHeaderItem.ViewHolder>() {

    override fun equals(other: Any?) = other is AdapterHeaderItem && other.title == this.title

    override fun hashCode() = title.hashCode()

    override fun createViewHolder(view: View, adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>) = ViewHolder(view, adapter)

    override fun bindViewHolder(adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>, holder: ViewHolder, position: Int, payloads: MutableList<Any>) {
        holder.itemView.headerText.text = title
    }

    override fun getLayoutRes() = R.layout.header_item

    class ViewHolder(rootView: View, adapter: FlexibleAdapter<*>) : FlexibleViewHolder(rootView, adapter, true)
}