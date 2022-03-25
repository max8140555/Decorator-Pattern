package com.max.decoratorpattern.part1.component.componentimpl

import com.max.decoratorpattern.part1.component.Beverage

class MilkTea: Beverage {

    override fun getDescription(): String = "MilkTea"

    override fun cost(): Int = 50
}