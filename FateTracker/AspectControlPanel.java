package FateTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AspectControlPanel extends FTPanel implements ActionListener
{
   private JButton clearAllB;
   private JButton saveB;
   private AspectColumn parent;
   
   public AspectControlPanel(AspectColumn p)
   {
      super();
      parent = p;
      clearAllB = new JButton("Clear All");
      saveB = new JButton("Save");
      
      setVisible(true);
      
      clearAllB.setMargin(AspectPanel.BUTTON_MARGINS);
      saveB.setMargin(AspectPanel.BUTTON_MARGINS);
      
      add(clearAllB);
      clearAllB.addActionListener(this);
      add(saveB);
      saveB.addActionListener(this);
      
      arrangeElements();
   }
   
   public void actionPerformed(ActionEvent ae)
   {
      if(ae.getSource() == clearAllB)
      {
         parent.clearAll();
      }
      if(ae.getSource() == saveB)
      {
         parent.save();
      }
   }
   
   public void arrangeElements()
   {
      arrangeElement(clearAllB, 0.0, 0.0, .2, 1.0);
      arrangeElement(saveB, .75, 0.0, .25, 1.0);
      int clearButtonFontSize = calcFontSize(clearAllB);
      clearButtonFontSize = (clearButtonFontSize * 2) / 3;
      clearAllB.setFont(new Font("Serif", Font.PLAIN, clearButtonFontSize));
      saveB.setFont(new Font("Serif", Font.PLAIN, clearButtonFontSize));
   }
}