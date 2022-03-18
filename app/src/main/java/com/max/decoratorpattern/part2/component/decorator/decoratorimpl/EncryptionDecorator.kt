package com.max.decoratorpattern.part2.component.decorator.decoratorimpl

import android.util.Base64
import com.max.decoratorpattern.part2.component.DataSource
import com.max.decoratorpattern.part2.component.decorator.DataSourceDecorator

class EncryptionDecorator(source: DataSource): DataSourceDecorator(source) {

    override fun writeData(data: String) {
        super.writeData(encode(data))
    }

    override fun readData(): String {
        return decode(super.readData())
    }

    private fun encode(data: String): String {
        return Base64.encodeToString(data.toByteArray(), Base64.DEFAULT)
    }

    private fun decode(data: String): String {
        return String(Base64.decode(data.toByteArray(), Base64.DEFAULT))
    }
}