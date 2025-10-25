package FateTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CharacterHeaderPanel extends FTPanel
{
   public static final double SMALL_ELEMENT_WIDTH = .05;
   public static final double MEDIUM_ELEMENT_WIDTH = SMALL_ELEMENT_WIDTH * 2;
   public static final int MAX_CHECK_BOXES = 10;
   public static final Insets BUTTON_MARGINS = new Insets(1, 1, 1, 1);
   
   private JLabel nameF;
   private JLabel fatePointsUpperF;
   private JLabel fatePointsLowerF;
   private JLabel hasActedF;
   
   public CharacterHeaderPanel()
   {
      super();
      nameF = new JLabel("Characters", SwingConstants.CENTER);
      fatePointsUpperF = new JLabel("Fate", SwingConstants.CENTER);
      fatePointsLowerF = new JLabel("Points", SwingConstants.CENTER);
      hasActedF = new JLabel("Acted", SwingConstants.CENTER);
      
      setVisible(true);
      
      add(nameF);
      add(fatePointsUpperF);
      add(fatePointsLowerF);
      add(hasActedF);
      
      arrangeElements();
   }
   
   public void arrangeElements()
   {
      double COMBINED_ELEMENT_WIDTH = SMALL_ELEMENT_WIDTH + MEDIUM_ELEMENT_WIDTH;
      double nameFWidth = 1.0 - (COMBINED_ELEMENT_WIDTH * 2);
      arrangeElement(nameF,            SMALL_ELEMENT_WIDTH, 0.0, nameFWidth, 1.0);
      arrangeElement(fatePointsUpperF, SMALL_ELEMENT_WIDTH + nameFWidth, 0.0, COMBINED_ELEMENT_WIDTH, .5);
      arrangeElement(fatePointsLowerF, SMALL_ELEMENT_WIDTH + nameFWidth, .5, COMBINED_ELEMENT_WIDTH, .5);
      arrangeElement(hasActedF,    1.0 - MEDIUM_ELEMENT_WIDTH, 0.0, MEDIUM_ELEMENT_WIDTH, 1.0);
      int hasActedFFontSize = calcFontSize(hasActedF);
      hasActedFFontSize = hasActedFFontSize / 2;
      hasActedF.setFont(new Font("Serif", Font.PLAIN, hasActedFFontSize));
   }
}