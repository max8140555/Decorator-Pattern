package com.max.decoratorpattern.part1.component.componentimpl

import com.max.decoratorpattern.part1.component.Beverage

class BlackTea: Beverage() {

    override fun getDescription(): String = "BlackTea"

    override fun cost(): Int = 10
}