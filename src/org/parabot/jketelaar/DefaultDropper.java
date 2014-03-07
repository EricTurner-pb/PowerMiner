package org.parabot.jketelaar;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.api.methods.Inventory;
import org.rev317.api.wrappers.hud.Item;

/**
 * @author: JKetelaar
 */
public class DefaultDropper implements Strategy {

    @Override
    public boolean activate() {
        return Inventory.isFull();
    }

    public void execute() {
        for (Item i : Inventory.getItems()) {
            i.interact("Drop");
            Time.sleep(750);
        }
    }
}
