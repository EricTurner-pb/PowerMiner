package org.parabot.jketelaar;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.soulsplit.api.methods.Inventory;
import org.soulsplit.api.methods.Menu;
import org.soulsplit.api.wrappers.Item;

/**
 * @author: JKetelaar
 */
public class MinifiedDropper implements Strategy {

    @Override
    public boolean activate() {
        return Inventory.isFull();
    }

    @Override
    public void execute() {
        for (Item i : Inventory.getItems()) {
            Menu.drop(i);
            Time.sleep(350);
        }
    }
}
