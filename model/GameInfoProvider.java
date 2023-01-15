/*
  CMPT 270 Course Material
  Copyright (c) 2003-2021
  J.P. Tremblay and Grant Cheston
  All rights reserved.

  This document contains resources for homework assigned to students of
  CMPT 270 and shall not be distributed without permission.  Posting this
  file to a public or private website, or providing this file to any person
  not registered in CMPT 270 constitutes Academic Misconduct according to
  the University of Saskatchewan Policy on Academic Misconduct.
 */

package model;

import java.util.List;

/**
 * The information provided by the GameModel for outside access.
 */
public interface GameInfoProvider {
    public void addObserver(GameObserver observer);

    public List<GameObject> getGameObjects();

    public boolean isOver();

    public boolean isPaused();

    public int getLevel();

    public int getPlayerScore();

    public int getPlayerLives();

    public int getTick();

    public void setInvaderSynchronizationObject(Object reference);

    public int getInvaders();

    public int getHeat();
}
