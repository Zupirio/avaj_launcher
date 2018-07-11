package simulator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class WriteFile
{
	private static	WriteFile 		writeFile = null;
	private static	BufferedWriter 	bufferedWriter = null;
	private static	File			file = null;
	private static	FileWriter		fileWriter = null;

	private WriteFile()
	{}

	public static WriteFile getWriteFile()
	{
		if (writeFile == null)
		{
			try
			{
				writeFile = new WriteFile();
				file = new File("simulator.txt");
				fileWriter = new FileWriter(String.valueOf(file));
				bufferedWriter = new BufferedWriter(fileWriter);
			}
			catch (Exception e)
			{
				System.err.println("Cant't write to file" + e);
			}
		}
		return writeFile;
	}

	public void writeToFile(String string)
	{
		try
		{
			bufferedWriter.write(string);
			bufferedWriter.newLine();
		}
		catch (Exception e)
		{
			System.out.println("Can't close BufferedWriter\n" + e);
		}
	}
}