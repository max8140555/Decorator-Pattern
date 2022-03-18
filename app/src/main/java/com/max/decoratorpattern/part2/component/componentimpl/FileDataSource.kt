package com.max.decoratorpattern.part2.component.componentimpl

import android.content.Context
import com.max.decoratorpattern.part2.component.DataSource
import java.io.*

class FileDataSource(private val context: Context, private val name: String): DataSource {

    override fun writeData(data: String) {
        var writer: BufferedWriter? = null
        try {
            val fos = context.openFileOutput(name, Context.MODE_PRIVATE)
            writer = BufferedWriter(OutputStreamWriter(fos))
            writer.write(data)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        writer?.close()
    }

    override fun readData(): String {
        var reader: BufferedReader? = null

        try {
            val fin = context.openFileInput(name)
            reader = BufferedReader(InputStreamReader(fin))
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return reader?.readText() ?: "無資料"
    }
}