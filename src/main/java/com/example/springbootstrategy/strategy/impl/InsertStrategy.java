package com.example.springbootstrategy.strategy.impl;

import com.example.springbootstrategy.strategy.MyStrategy;
import org.springframework.stereotype.Component;

@Component
public class InsertStrategy implements MyStrategy {
    @Override
    public String strategyType() {
        return "insert";
    }

    @Override
    public String doStrategy() {
        return "insert";
    }
}
