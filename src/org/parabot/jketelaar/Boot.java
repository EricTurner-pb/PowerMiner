package org.parabot.jketelaar;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import org.soulsplit.api.methods.Menu;

import java.util.ArrayList;

/**
 * @author: JKetelaar
 */
@ScriptManifest(author = "Paradox",
        category = Category.MINING,
        description = "A powerminer for every server",
        name = "JKPMiner",
        servers = {"Any 317"},
        version = 1.3)
public class Boot extends Script {

    private static ArrayList<Strategy> strategies = new ArrayList<>();

    @Override
    public boolean onExecute() {
        Variables.setFrameVisible(true);
        UI.startUp();
        while (Variables.isFrameVisible()) {
            Time.sleep(500);
        }
        try {
            Menu.sendAction(-1, -1, -1, -1);
            strategies.add(new MinifiedMiner());
            strategies.add(new MinifiedDropper());
        } catch (NoClassDefFoundError e) {
            strategies.add(new DefaultMiner());
            strategies.add(new DefaultDropper());
        }
        provide(strategies);
        return true;
    }
}
