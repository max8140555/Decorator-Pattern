package com.max.decoratorpattern.part2.component.decorator.decoratorimpl

import android.util.Base64
import com.max.decoratorpattern.part2.component.DataSource
import com.max.decoratorpattern.part2.component.decorator.DataSourceDecorator
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
import java.util.zip.Deflater
import java.util.zip.DeflaterOutputStream
import java.util.zip.InflaterInputStream

class CompressionDecorator(source: DataSource): DataSourceDecorator(source) {
    var compressionLevel = 6

    override fun writeData(data: String) {
        val compressData = compress(data)!!
        super.writeData(compressData)
    }

    override fun readData(): String {
        val data = super.readData()
        return decompress(data)!!
    }

    private fun compress(stringData: String): String? {
        val data = stringData.toByteArray()
        return try {
            val bout = ByteArrayOutputStream(512)
            val dos = DeflaterOutputStream(bout, Deflater(compressionLevel))
            dos.write(data)
            dos.close()
            bout.close()
            Base64.encodeToString(bout.toByteArray(), Base64.DEFAULT)
        } catch (ex: IOException) {
            null
        }
    }

    private fun decompress(stringData: String): String? {
        val data: ByteArray = Base64.decode(stringData, Base64.DEFAULT)
        return try {
            val `in`: InputStream = ByteArrayInputStream(data)
            val iin = InflaterInputStream(`in`)
            val bout = ByteArrayOutputStream(512)
            var b: Int
            while (iin.read().also { b = it } != -1) {
                bout.write(b)
            }
            `in`.close()
            iin.close()
            bout.close()
            String(bout.toByteArray())
        } catch (ex: IOException) {
            null
        }
    }
}