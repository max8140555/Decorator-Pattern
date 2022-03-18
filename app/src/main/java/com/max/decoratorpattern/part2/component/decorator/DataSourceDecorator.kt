package com.max.decoratorpattern.part2.component.decorator

import com.max.decoratorpattern.part2.component.DataSource

abstract class DataSourceDecorator(private val source: DataSource): DataSource {
    override fun writeData(data: String) {
        source.writeData(data)
    }

    override fun readData(): String {
        return source.readData()
    }
}