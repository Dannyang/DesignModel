package com.example.springbootstrategy.strategy.impl;

import com.example.springbootstrategy.strategy.MyStrategy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class StrategyFactory implements ApplicationContextAware {
    private final Map<String, MyStrategy> strategyMap = new HashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        Map<String, MyStrategy> beansOfType = applicationContext.getBeansOfType(MyStrategy.class);
        beansOfType.keySet().forEach(key -> strategyMap.put(beansOfType.get(key).strategyType(), beansOfType.get(key)));
    }

    public String doStrategy(String operateType) {
        return strategyMap.get(operateType).doStrategy();
    }
}
