package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.FruitHandler;
import core.basesyntax.strategy.FruitHandlerStrategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    @Override
    public void processAllTransations(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            FruitHandler fruitHandler = new FruitHandlerStrategy().get(transaction);
            if (fruitHandler != null) {
                fruitHandler.doAction(transaction);
            }
        }
    }
}