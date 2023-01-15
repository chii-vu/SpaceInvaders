/*
Chi Vu
cpv616
11299008
CMPT 270
 */

package newview;

import model.GameInfoProvider;

import javax.swing.*;

/**
 * The frame to view the invader
 */
public class InvaderFrame extends JFrame {
    /**
     * Create the frame for viewing the invader during the game
     */
    public InvaderFrame(GameInfoProvider gameInfo) {
        setTitle("Invader Count");
        setSize(300, 250);
        InvaderPanel panel = new InvaderPanel(gameInfo);
        add(panel);
    }
}
