package com.example.productslist

import android.app.Application
import android.graphics.Bitmap
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator
import com.nostra13.universalimageloader.core.DisplayImageOptions
import com.nostra13.universalimageloader.core.ImageLoader
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration
import com.nostra13.universalimageloader.core.assist.QueueProcessingType

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initImageLoader()
    }

    private fun initImageLoader() {

        val options = DisplayImageOptions.Builder()
            .cacheOnDisk(true)
            .cacheInMemory(true)
            .bitmapConfig(Bitmap.Config.RGB_565)
            .build()

        val config = ImageLoaderConfiguration.Builder(this)
            .threadPriority(Thread.NORM_PRIORITY - 2)
            .denyCacheImageMultipleSizesInMemory()
            .diskCacheFileNameGenerator(Md5FileNameGenerator())
            .diskCacheSize(50 * 1024 * 1024)
            .defaultDisplayImageOptions(options)
            .tasksProcessingOrder(QueueProcessingType.LIFO)
            .writeDebugLogs() // Remove for release app
            .build()
        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config)
    }

}