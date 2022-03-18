package com.max.decoratorpattern.part1.component

abstract class Beverage {

    private var description: String = "Unknown Beverage"

    open fun getDescription(): String = description

    abstract fun cost(): Int

}

