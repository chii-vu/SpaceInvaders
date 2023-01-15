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

/**
 * An observer of the game. The observer is registered with the game. Whenever the game changes, the
 * game will invoke gameChanged on all its observers so that each can take appropriate action.
 */
public interface GameObserver {
    /**
     * The method to be invoked whenever the game changes.
     */
    public void gameChanged();
}
