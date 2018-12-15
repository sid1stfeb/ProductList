package com.example.productslist.products

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.productslist.R
import kotlinx.android.synthetic.main.item_category.view.*


class CategoryAdapter(val mContext: Context, val listner: ItemClickListner) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private var layoutInflater: LayoutInflater? = LayoutInflater.from(mContext)

    override fun getItemCount(): Int {
        return 4
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(layoutInflater?.inflate(R.layout.item_category, parent, false)!!)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        //holder.adapter?.setData()
    }

    inner class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view), ItemClickListner {

        var adapter: ProductAdapter? = null

        init {
            view.recycle_view.layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
            adapter = ProductAdapter(mContext, this)
            view.recycle_view.adapter = adapter
        }

        override fun OnItemClicked() {
            listner.OnItemClicked()
        }
    }
}