package com.example.productslist.payment

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Patterns
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.productslist.R
import com.example.productslist.common.BaseActivity
import kotlinx.android.synthetic.main.activity_payment.*

class PaymentActivity : BaseActivity(), AdapterView.OnItemSelectedListener, View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
        title = getString(R.string.product)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        val arr = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        spinner.onItemSelectedListener = this

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, arr)
        spinner.adapter = adapter

        make_payment.setOnClickListener(this)

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        price.text="$"+(500*(position+1))
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.make_payment->{
                if(isEmailValid(email.text.toString()))
                    showPaymentAlertDialog()
                else
                    Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show()
            }
        }
    }

    /**
     * method used to check whether email address is valid or not
     *
     * @param email
     * @return
     */
    fun isEmailValid(email: String?): Boolean {

        return if (email == null) {
            false
        } else {
            Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }
    }

    /*This method shows logout dialog*/
    fun showPaymentAlertDialog() {
        val dialogBuilder = AlertDialog.Builder(this)

        dialogBuilder.setTitle("Payment Conformation")
        dialogBuilder.setMessage("payment done successfully!!")
        dialogBuilder.setPositiveButton("Ok") { dialog, _ ->
            dialog.dismiss()
            finish()
        }
        val b = dialogBuilder.create()
        b.show()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            android.R.id.home->{
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}