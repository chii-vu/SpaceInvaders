package newview;

import model.GameInfoProvider;
import model.GameObserver;
import view.GraphicsPanel;
import view.ImageCache;

import java.awt.*;
import java.awt.image.BufferedImage;

public class InvaderPanel extends GraphicsPanel implements GameObserver {

    /**
     * The object that provides information about the game.
     */
    private GameInfoProvider gameInfo;

    /**
     * The list of the objects in the game for a specific painting of the panel.
     */
    private int invaders;

    /**
     * The two images to display invader with arms up or down.
     */
    private BufferedImage image1 = ImageCache.getInstance().getImage("invader1.png");
    private BufferedImage image2 = ImageCache.getInstance().getImage("invader2.png");

    /**
     * Current image of invader to be changed if no. of invaders changes
     */
    private BufferedImage currentImage;

    /**
     * Initialize the panel ready for painting.
     *
     * @param gameInfo the interface to the game used to obtain information from the
     *                 game
     */
    public InvaderPanel(GameInfoProvider gameInfo) {
        this.gameInfo = gameInfo;
        setDoubleBuffered(true);
        currentImage = image1;
        gameInfo.addObserver(this);
    }

    /**
     * When the game changes, repaint the panel to show
     * the latest heat level and state of invader.
     */
    public synchronized void gameChanged() {
        repaint();
    }

    /**
     * Paint the panel to show the invader and heat level
     *
     * @param g the graphics used for painting
     */
    @Override
    public synchronized void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D bufferedGraphics = (Graphics2D) g;

        setBackground(Color.BLACK);
        bufferedGraphics.setPaint(Color.GREEN);

        // switch image if number of invaders change
        if (invaders != gameInfo.getInvaders()) {
            if (currentImage.equals(image2)) {
                currentImage = image1;
            } else {
                currentImage = image2;
            }
            invaders = gameInfo.getInvaders(); // update no. of invaders
        }

        // draw current image
        bufferedGraphics.drawImage(currentImage, 90, 50,
                3 * currentImage.getWidth(), 3 * currentImage.getHeight(), null);

        // display current heat state of player
        if (gameInfo.getHeat() < 5) {
            drawString(90, 180, "Heat level: " + gameInfo.getHeat(),
                    GraphicsPanel.REG_FONT_SIZE, bufferedGraphics);
        } else {
            drawString(90, 180, "Overheated!",
                    GraphicsPanel.REG_FONT_SIZE, bufferedGraphics);
        }
    }
}
