package com.example.springbootstrategy.strategy.impl;

import com.example.springbootstrategy.strategy.MyStrategy;
import org.springframework.stereotype.Component;

@Component
public class DeleteStrategy implements MyStrategy {
    @Override
    public String strategyType() {
        return "Delete";
    }

    @Override
    public String doStrategy() {
        return "Delete";
    }
}
