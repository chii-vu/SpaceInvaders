package model;

import javax.swing.*;
import java.awt.event.*;

/**
 * The player in the space invaders game.
 */
public class Player extends GameObject {
    public static final int WIDTH = 46;
    public static final int HEIGHT = 25;

    /** The distance to move when it is time to move. */
    public static final int MOVE_DISTANCE = 15;

    /** The decrease in the score every time hit. */
    public static final int HIT_DECREMENT = 20;

    /* The initial number of lives for the Player. */
    public static final int INITIAL_NUM_LIVES = 4;

    /* The number of lives remaining for the Player. */
    protected int lives;

    /* The current score for the Player. */
    protected int score;

    /* Player's laser's recharging state */
    protected boolean recharge;

    /* The timer for a laser to recharge after firing */
    protected Timer rechargeTimer;

    /* The heat unit of a laser */
    protected int heat;

    /* Whether laser exceeds heat unit limit */
    protected boolean overheated;

    /* The timer for a laser to cool down after overheating */
    protected Timer overheatTimer;

    /* The timer for a laser to cool down after not being fired */
    protected Timer coolTimer;

    /** How frequently (in terms of ticks) the player is to change image. */
    public static final int CHANGE_FREQ = 0;

    /**
     * Initialize the player.
     */
    public Player(int x, int y, Game game) {
        super(x, y, game, "player");
        width = WIDTH;
        height = HEIGHT;
        lives = INITIAL_NUM_LIVES;
        score = 0;
        heat = 0;

        recharge = false;
        rechargeTimer = new Timer(300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recharge = false;
            }
        });
        rechargeTimer.setRepeats(false);

        overheated = false;
        overheatTimer = new Timer(10000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // set heat back down to 0, and change overheat state
                heat = 0;
                overheated = false;
            }
        });
        overheatTimer.setRepeats(false);

        coolTimer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // every 500 ms passed without firing will decrease heat unit by 1
                if (heat > 0 && !overheated)
                    heat--;
            }
        });
        coolTimer.start();
    }

    /**
     * No actions for the player at clock ticks.
     */
    protected void update() {
    }

    /**
     * Move to the left.
     */
    public void moveLeft() {
        if (!overheated) {
            x = Math.max(x - MOVE_DISTANCE, 0);
        }
    }

    /**
     * Move to the right.
     */
    public void moveRight() {
        if (!overheated) {
            x = Math.min(x + MOVE_DISTANCE, game.getWidth() - width);
        }
    }

    /**
     * If canFire, fire a laser.
     */
    public void fire() {
        if (!overheated) {
            if (heat > 4) {
                // start timer for 10 sec if laser is overheated
                overheated = true;
                overheatTimer.start();
            } else {
                if (!recharge) {
                    // can only fire if not overheated and done recharging
                    recharge = true;
                    int laserX = x + (width - Laser.WIDTH) / 2;
                    int laserY = y - Laser.HEIGHT;
                    game.addLaser(new Laser(laserX, laserY, game));
                    rechargeTimer.start();
                    coolTimer.restart();
                    heat++; // every time laser fires, heat unit increases by 1
                }
            }
        }
    }

    /**
     * Handle the collision with another object.
     * 
     * @param other the object that collided with this instance
     */
    protected void collide(GameObject other) {
        lives = lives - 1;
        moveToLeftSide();
        if (lives == 0) {
            isDead = true;
        }
        score = score - HIT_DECREMENT;
    }

    /**
     * Move to the left side.
     */
    public void moveToLeftSide() {
        x = 0;
    }

    /**
     * @return the number of lives still remaining
     */
    public int getLives() {
        return lives;
    }

    /**
     * Set a new value for the number of lives.
     * 
     * @param lives the new value for the lives field
     */
    public void setLives(int lives) {
        this.lives = lives;
        if (lives == 0) {
            isDead = true;
        }
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param amount the amount by which the score is to be increased
     */
    public void increaseScore(int amount) {
        score = score + amount;
    }
}
