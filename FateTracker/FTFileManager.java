package FateTracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;

public class FTFileManager
{
   public static final String FILE_NAME = "FateTracker.dat";
   public static final int CHARACTER_ROWS = FateTracker.CharacterColumn.ROWS - 2;
   public static final int ASPECT_ROWS = FateTracker.AspectColumn.ROWS - 2;
   public static final int TOTAL_LINES = CHARACTER_ROWS + ASPECT_ROWS;

   public static void save(AspectColumn ac, CharacterColumn cc)
   {
      String[] output = new String[TOTAL_LINES];
      String[] characterOutput = cc.serialize();
      String[] aspectOutput = ac.serialize();
      for(int i = 0; i < aspectOutput.length; i++)
         output[i] = aspectOutput[i];
      for(int i = 0; i < characterOutput.length; i++)
         output[i + aspectOutput.length] = characterOutput[i];
      write(output);
   }
   
   public static void load(AspectColumn ac, CharacterColumn cc)
   {
      String[] strArr = read();
      String acArr[] = new String[ASPECT_ROWS];
      String ccArr[] = new String[CHARACTER_ROWS];
      for(int i = 0; i < acArr.length; i++)
         acArr[i] = strArr[i].strip();
      for(int i = 0; i < ccArr.length; i++)
         ccArr[i] = strArr[i + acArr.length].strip();
      ac.deserialize(acArr);
      cc.deserialize(ccArr);
   }
   
	public static void write(String[] output)
	{
		PrintWriter outFile = null;
		try
		{
			outFile = new PrintWriter(FILE_NAME);
		}
		catch(Exception ex)
		{
			String errorMessage = "Error: Cannot write to " + FILE_NAME;
			JOptionPane.showMessageDialog(null, errorMessage, "Exception Occured", JOptionPane.ERROR_MESSAGE);
		}
		
		for(String line : output)
			outFile.println(line);
			
		outFile.close();
	}


	public static String[] read()
	{
			
		Scanner inFile = null;
      String[] output = new String[TOTAL_LINES];
		
		try
		{
			inFile = new Scanner(new FileReader(FILE_NAME));
		}
		catch(Exception ex)
		{
			String errorMessage = "Error: Cannot read from " + FILE_NAME;
			JOptionPane.showMessageDialog(null, errorMessage, "Exception Occured", JOptionPane.ERROR_MESSAGE);
         return output;
		}
		
		try
		{
		   int index = 0;
			while(inFile.hasNext() == true)
			{
				output[index] = inFile.nextLine();
				index++;
			}
		}
		catch(ArrayIndexOutOfBoundsException arrEx){}

		inFile.close();
		
		return output;
	}
}