package com.example.springbootstrategy.strategy.impl;

import com.example.springbootstrategy.strategy.MyStrategy;
import org.springframework.stereotype.Component;

@Component
public class UpdateStrategy implements MyStrategy {
    @Override
    public String strategyType() {
        return "update";
    }

    @Override
    public String doStrategy() {
        return "update";
    }
}
