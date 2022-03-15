package com.learning.servicesexample

import android.content.Context
import java.io.IOException

object Utils {
    fun getServesDataFromAssets(context: Context, fileName: String): String? {
        var jsonString: String? = null
        try {
            val inputStream = context.assets.open(fileName)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            jsonString = String(buffer, Charsets.UTF_8)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return jsonString
    }
}