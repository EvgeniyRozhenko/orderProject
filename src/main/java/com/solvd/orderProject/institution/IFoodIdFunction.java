package com.solvd.orderProject.institution;

import com.solvd.orderProject.order.MenuItem;

import java.util.function.Function;

@FunctionalInterface
public interface IFoodIdFunction<T, R extends MenuItem> extends Function<T, R> {
    R apply(T id);
}
