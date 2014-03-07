package org.parabot.jketelaar;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.api.methods.Inventory;
import org.rev317.api.methods.Players;
import org.rev317.api.methods.SceneObjects;
import org.rev317.api.wrappers.scene.SceneObject;

/**
 * @author: JKetelaar
 */
public class DefaultMiner implements Strategy {

    @Override
    public boolean activate() {
        return !Inventory.isFull()
                && Players.getLocal().getAnimation() == -1
                && !Players.getLocal().isInCombat() && !Players.getLocal().isWalking();
    }

    @Override
    public void execute() {
        if (org.rev317.api.methods.SceneObjects.getNearest(Variables.getMineID()) != null) {
            SceneObject[] mines = SceneObjects.getNearest(Variables.getMineID());
            for (SceneObject so : mines) {
                if (so != null) {
                    so.interact("Chop down");
                    Time.sleep(500);
                }
            }
        }
    }
}
