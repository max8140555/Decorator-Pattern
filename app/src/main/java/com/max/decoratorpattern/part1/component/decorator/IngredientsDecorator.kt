package com.max.decoratorpattern.part1.component.decorator

import com.max.decoratorpattern.part1.component.Beverage

abstract class IngredientsDecorator(private val beverage: Beverage): Beverage {
    override fun getDescription(): String {
        return beverage.getDescription()
    }

    override fun cost(): Int {
        return beverage.cost()
    }
}
