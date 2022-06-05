package com.example.springcalculator.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DollarCalculator implements ICalculator {

    private int price = 1;

    private final MarketAPI marketapi;

    @Override
    public void init() {
        this.price = marketapi.connect();
    }

    public int sum(int x, int y) {
        x *= price;
        y *= price;
        return x + y;
    }

    public int minus(int x, int y) {
        x *= price;
        y *= price;
        return x - y;
    }
}
