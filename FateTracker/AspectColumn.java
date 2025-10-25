package FateTracker;

import javax.swing.*;
import java.awt.*;

public class AspectColumn extends JPanel
{
   public static final int ROWS = 14;
   
   private FTFrame parent;
   private AspectPanel[] aspectPanelArr;
   private AspectHeaderPanel aspectHeaderPanel;
   private AspectControlPanel aspectControlPanel;
   
   public AspectColumn(FTFrame p)
   {
      super();
      setLayout(new GridLayout(ROWS, 1));
      setBorder(BorderFactory.createLineBorder(Color.black));
      parent = p;
      
      aspectHeaderPanel = new AspectHeaderPanel();
      add(aspectHeaderPanel);
      
      aspectPanelArr = new AspectPanel[ROWS - 2];
      for(int i = 0; i < ROWS - 2; i++)
      {
         aspectPanelArr[i] = new AspectPanel();
         add(aspectPanelArr[i]);
      }
      
      aspectControlPanel = new AspectControlPanel(this);
      add(aspectControlPanel);
      
      setVisible(true);
   }
   
   public void clearAll()
   {
      for(int i = 0; i < ROWS - 2; i++)
      {
         aspectPanelArr[i].clear();
      }
   }
   
   public String[] serialize()
   {
      String[] strArr = new String[ROWS - 2];
      for(int i = 0; i < ROWS - 2; i++)
      {
         strArr[i] = aspectPanelArr[i].serialize();
      }
      return strArr;
   }
   
   public void deserialize(String[] strArr)
   {
      for(int i = 0; i < ROWS - 2; i++)
      {
         aspectPanelArr[i].deserialize(strArr[i]);
      }
   }
   
   public void save()
   {
      parent.save();
   }
}