package com.max.decoratorpattern.part1.component.decorator.decoratorimpl

import com.max.decoratorpattern.part1.component.Beverage
import com.max.decoratorpattern.part1.component.decorator.IngredientsDecorator

class BubbleDecorator(beverage: Beverage): IngredientsDecorator(beverage) {

    override fun getDescription(): String {
        return super.getDescription() + " + Bubble"
    }

    override fun cost(): Int {
        return super.cost() + 10
    }
}