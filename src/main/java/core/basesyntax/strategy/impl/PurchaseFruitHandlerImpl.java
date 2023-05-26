package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitHandler;

public class PurchaseFruitHandlerImpl implements FruitHandler {
    @Override
    public void doAction(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        Integer oldQuantity = Storage.getFruitStorage().get(fruit);
        if (fruitTransaction.getQuantity() > oldQuantity) {
            throw new RuntimeException("It is impossible to buy more fruit "
                    + "than is available in the store");
        }
        int newQuantity = oldQuantity - fruitTransaction.getQuantity();
        if (newQuantity < 0) {
            throw new RuntimeException("Reserve of fruits shouldn't be less than 0");
        }
        Storage.getFruitStorage().put(fruit, newQuantity);
    }
}
