package com.example.stickyheaders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.AbstractSectionableItem
import eu.davidea.flexibleadapter.items.IFlexible
import eu.davidea.viewholders.FlexibleViewHolder
import kotlinx.android.synthetic.main.sectionable_item.view.*

class AdapterSectionItem(header: AdapterHeaderItem?, private val text: String) :
    AbstractSectionableItem<AdapterSectionItem.ViewHolder, AdapterHeaderItem>(header) {

    override fun equals(other: Any?) = other is AdapterSectionItem && other.text == this.text

    override fun hashCode() = text.hashCode()

    override fun createViewHolder(view: View, adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>) = ViewHolder(view, adapter)

    override fun bindViewHolder(adapter: FlexibleAdapter<IFlexible<RecyclerView.ViewHolder>>, holder: ViewHolder, position: Int, payloads: MutableList<Any>) {
        holder.itemView.sectionableText.text = text
    }

    override fun getLayoutRes() = R.layout.sectionable_item

    class ViewHolder(rootView: View, adapter: FlexibleAdapter<*>) : FlexibleViewHolder(rootView, adapter)
}