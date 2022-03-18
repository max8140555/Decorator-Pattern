package com.max.decoratorpattern.part1.component.componentimpl

import com.max.decoratorpattern.part1.component.Beverage

class GreenTea: Beverage() {

    override fun getDescription(): String = "GreenTea"

    override fun cost(): Int = 20
}