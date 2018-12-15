package com.example.productslist.products

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.productslist.R
import kotlinx.android.synthetic.main.item_product.view.*

class ProductAdapter(context: Context, val listner: ItemClickListner) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private var layoutInflater: LayoutInflater? = LayoutInflater.from(context)

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        //holder.name.text = ""
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(layoutInflater?.inflate(R.layout.item_product, parent, false)!!)
    }

    fun setData() {
        notifyDataSetChanged()
    }

    inner class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val container: LinearLayout = view.item_container!!
        val image = view.image!!
        val name = view.name!!
        val price = view.price!!

        init {
            container.setOnClickListener {
                listner.OnItemClicked()
            }
        }

    }
}