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

package view;

import javax.swing.*;
import java.awt.*;

/**
 * A class for the panel to be placed in the frame of the main view. It has a function to return the
 * Component within it to obtain the focus when the containing frame is realized.
 */
public class ViewPanel extends JPanel {
    /** The Component to be in focus when the containing frame is realized. */
    protected Component focusComponent;

    /**
     * @return the Component of this panel that should have the focus when the frame is realized.
     */
    public Component getFocusComponent() {
        return focusComponent;
    }

    /**
     * Set the Component of this panel that should have the focus when the frame is realized.
     */
    public void setFocusComponent(Component focusComponent) {
        this.focusComponent = focusComponent;
    }

    public static final long serialVersionUID = 1;
}
