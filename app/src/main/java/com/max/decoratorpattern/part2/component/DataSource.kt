package com.max.decoratorpattern.part2.component

interface DataSource {

    fun writeData(data: String)

    fun readData(): String
}