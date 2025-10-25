package FateTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AspectHeaderPanel extends FTPanel
{
   private JLabel label;
   
   public AspectHeaderPanel()
   {
      super();
      label = new JLabel("Aspects", SwingConstants.CENTER);
      add(label);
      
      setVisible(true);
      
      arrangeElements();
   }
   
   public void arrangeElements()
   {
      arrangeElement(label, 0.0, 0.0, 1.0, 1.0);
   }
}