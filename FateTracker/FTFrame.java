package FateTracker;

import javax.swing.*;
import java.awt.*;

public class FTFrame extends JFrame
{
   private AspectColumn aspectColumn;
   private CharacterColumn characterColumn;
   
   public FTFrame()
   {
      super();
      setSize(1200, 800);
      setLayout(new GridLayout(1, 2));
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("FATE Tracker");
      aspectColumn = new AspectColumn(this);
      characterColumn = new CharacterColumn(this);
      add(aspectColumn);
      add(characterColumn);
      setVisible(true);
   }
   
   public void save()
   {
      FTFileManager.save(aspectColumn, characterColumn);
   }
   
   public void load()
   {
      FTFileManager.load(aspectColumn, characterColumn);
   }
   
   public static void main(String[] args)
   {
      FTFrame frame = new FTFrame();
   }
}