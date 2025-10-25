package FateTracker;

import javax.swing.*;
import java.awt.*;

public class CharacterColumn extends JPanel
{
   public static final int ROWS = 14;
   
   private FTFrame parent;
   private CharacterPanel[] characterPanelArr;
   private CharacterHeaderPanel characterHeaderPanel;
   private CharacterControlPanel characterControlPanel;
   
   public CharacterColumn(FTFrame p)
   {
      super();
      parent = p;
      setBorder(BorderFactory.createLineBorder(Color.black));
      setLayout(new GridLayout(ROWS, 1));
      characterPanelArr = new CharacterPanel[ROWS - 2];
      characterHeaderPanel = new CharacterHeaderPanel();
      add(characterHeaderPanel);
      for(int i = 0; i < ROWS - 2; i++)
      {
         characterPanelArr[i] = new CharacterPanel();
         add(characterPanelArr[i]);
      }
      characterControlPanel = new CharacterControlPanel(this);
      add(characterControlPanel);
      setVisible(true);
   }
   
   public void newRound()
   {
      for(int i = 0; i < ROWS - 2; i++)
      {
         characterPanelArr[i].newRound();
      }
   }
   
   public String[] serialize()
   {
      String[] strArr = new String[ROWS - 2];
      for(int i = 0; i < ROWS - 2; i++)
      {
         strArr[i] = characterPanelArr[i].serialize();
      }
      return strArr;
   }
   
   public void deserialize(String[] strArr)
   {
      for(int i = 0; i < ROWS - 2; i++)
      {
         characterPanelArr[i].deserialize(strArr[i]);
      }
   }
   
   public void load()
   {
      parent.load();
   }
}