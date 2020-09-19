package com.cagudeloa.harrypotter.ui.character

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cagudeloa.harrypotter.R
import com.cagudeloa.harrypotter.base.BaseViewHolder
import com.cagudeloa.harrypotter.data.model.Student
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_row.view.*

class ChosenCategoryAdapter(
    private val context: Context,
    private val itemClickListener: OnItemClickListener,
    private val studentsList: List<Student>
): RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnItemClickListener{
        fun onItemClick(listStudent: Student)
    }

    inner class ChosenCategoryViewHolder(itemView: View): BaseViewHolder<Student>(itemView){
        override fun bind(item: Student, position: Int) {
            Picasso.get().load(item.image).into(itemView.itemImage)
            itemView.nameText.text = item.name
            itemView.anotherText.text = "House: ${item.house}"
            itemView.setOnClickListener { itemClickListener.onItemClick(item) }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return ChosenCategoryViewHolder(LayoutInflater.from(context).inflate(R.layout.item_row, parent, false))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is ChosenCategoryViewHolder -> holder.bind(studentsList[position], position)
        }
    }

    override fun getItemCount(): Int {
        return studentsList.size
    }


}