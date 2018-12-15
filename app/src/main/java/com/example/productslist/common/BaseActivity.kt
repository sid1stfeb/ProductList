package com.example.productslist.common

import android.content.Intent
import android.support.v7.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {
    /**
     * Method to start activity
     *
     * @param destination activity to start
     */
    fun switchActivity(destination: Class<*>) {
        val intent = Intent(this, destination)
        startActivity(intent)
    }
}