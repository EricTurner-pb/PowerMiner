package org.parabot.jketelaar;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.soulsplit.api.methods.Inventory;
import org.soulsplit.api.methods.Players;
import org.soulsplit.api.methods.SceneObjects;
import org.soulsplit.api.wrappers.SceneObject;

/**
 * @author: JKetelaar
 */
public class MinifiedMiner implements Strategy {

    @Override
    public boolean activate() {
        return !Inventory.isFull()
                && Players.getMyPlayer().getAnimation() == -1
                && !Players.getMyPlayer().isInCombat();
    }

    @Override
    public void execute() {
        Time.sleep(750);
        if (SceneObjects.getNearest(Variables.getMineID()) != null) {
            SceneObject[] mines = SceneObjects.getNearest(Variables.getMineID());
            for (SceneObject so : mines) {
                if (so != null) {
                    so.interact(0);
                    Time.sleep(2500);
                }
            }
        }
    }
}
