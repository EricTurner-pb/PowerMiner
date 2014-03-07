package org.parabot.jketelaar;

/**
 * @author: JKetelaar
 */
public class Variables {
    private static int mineID;
    private static boolean frameVisible;

    public static int getMineID() {
        return mineID;
    }

    public static void setMineID(int mineID) {
        Variables.mineID = mineID;
    }

    public static void setFrameVisible(boolean frameVisible) {
        Variables.frameVisible = frameVisible;
    }

    public static boolean isFrameVisible() {
        return frameVisible;
    }
}
