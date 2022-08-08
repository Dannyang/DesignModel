package com.example.springbootstrategy.strategy;

import com.example.springbootstrategy.strategy.impl.StrategyFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private final StrategyFactory strategyFactory;

    public Controller(StrategyFactory strategyFactory) {
        this.strategyFactory = strategyFactory;
    }


    @GetMapping("/test")
    public String getStrategy(@RequestParam("strategy") String strategy) {
        return strategyFactory.doStrategy(strategy);
    }
}
