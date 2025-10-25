package FateTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CharacterControlPanel extends FTPanel implements ActionListener
{
   private JButton newRoundB;
   private JButton loadB;
   private CharacterColumn parent;
   
   public CharacterControlPanel(CharacterColumn p)
   {
      super();
      parent = p;
      newRoundB = new JButton("New Round");
      loadB = new JButton("Load");
      
      setVisible(true);
      
      newRoundB.setMargin(AspectPanel.BUTTON_MARGINS);
      loadB.setMargin(AspectPanel.BUTTON_MARGINS);
      
      add(newRoundB);
      newRoundB.addActionListener(this);
      add(loadB);
      loadB.addActionListener(this);
      
      arrangeElements();
   }
   
   public void actionPerformed(ActionEvent ae)
   {
      if(ae.getSource() == newRoundB)
      {
         parent.newRound();
      }
      if(ae.getSource() == loadB)
      {
         parent.load();
      }
   }
   
   public void arrangeElements()
   {
      arrangeElement(newRoundB, 0.7, 0.0, .3, 1.0);
      arrangeElement(loadB, 0.0, 0.0, .25, 1.0);
      int nrButtonFontSize = calcFontSize(newRoundB);
      nrButtonFontSize = (nrButtonFontSize * 2) / 3;
      newRoundB.setFont(new Font("Serif", Font.PLAIN, nrButtonFontSize));
      loadB.setFont(new Font("Serif", Font.PLAIN, nrButtonFontSize));
   }
}