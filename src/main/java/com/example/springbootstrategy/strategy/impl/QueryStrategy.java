package com.example.springbootstrategy.strategy.impl;

import com.example.springbootstrategy.strategy.MyStrategy;
import org.springframework.stereotype.Component;

@Component
public class QueryStrategy implements MyStrategy {
    @Override
    public String strategyType() {
        return "Query";
    }

    @Override
    public String doStrategy() {
        return "Query";
    }
}
