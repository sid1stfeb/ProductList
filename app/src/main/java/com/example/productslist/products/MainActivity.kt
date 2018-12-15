package com.example.productslist.products

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.productslist.R
import com.example.productslist.common.BaseActivity
import com.example.productslist.payment.PaymentActivity
import kotlinx.android.synthetic.main.activity_mian.*

class MainActivity : BaseActivity(), ItemClickListner {

    var mAdapter: CategoryAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mian)
        title = getString(R.string.categories)
        recycle_view.layoutManager = LinearLayoutManager(this)
        mAdapter = CategoryAdapter(this, this)
        recycle_view.adapter = mAdapter
    }


    override fun OnItemClicked() {
        switchActivity(PaymentActivity::class.java)
    }

}