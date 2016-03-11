package cpsc101.highoctane.view;

import java.io.File;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import cpsc101.highoctane.model.*;

public class UNBCFileManager
{
	private JFileChooser saveChooser, loadChooser, csvChooser;
	private UNBCFileFilter unbcFilter;
	private CSVFileFilter csvFilter;
	private File saveLocation;
	
	public UNBCFileManager()
	{
		unbcFilter = new UNBCFileFilter();
		csvFilter = new CSVFileFilter();
		
		saveChooser = new JFileChooser();
		saveChooser.addChoosableFileFilter(unbcFilter);
		saveChooser.setFileFilter(unbcFilter);
		
		loadChooser = new JFileChooser();
		loadChooser.addChoosableFileFilter(unbcFilter);
		loadChooser.setAcceptAllFileFilterUsed(false);
		
		csvChooser = new JFileChooser();
		csvChooser.addChoosableFileFilter(csvFilter);
		csvChooser.setAcceptAllFileFilterUsed(false);
		
		saveLocation = null;
	}
	
	public void SaveFile(Savable saver, boolean changeLocation)
	{
		File tempLocation;
		
		if(saveLocation == null || changeLocation)
		{
			if(saveChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
			{
				tempLocation = saveChooser.getSelectedFile();
				
				if(!unbcFilter.accept(tempLocation))
				{
					tempLocation = new File(tempLocation.getAbsolutePath()+".unbc");
				}
				
				if(tempLocation.exists())
				{
					int option = JOptionPane.showConfirmDialog(null,
							"A file with that name already exists!\nAre you sure you want to overwrite it?",
							"Overwriting a file", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					
					if (option == JOptionPane.YES_OPTION)
					{
						saver.saveToFile(tempLocation);
						saveLocation = tempLocation;
					}
				}
				else
				{
					saver.saveToFile(tempLocation);
					saveLocation = tempLocation;
				}
			}
		}
		else
		{
			saver.saveToFile(saveLocation);
		}
	}

	public void LoadUNBCFile(Loadable loader)
	{
		int option = JOptionPane.showConfirmDialog(null,
				"Loading a new configuration will lose any unsaved work.\nwould you still like to continue?",
				"Loading a configuration", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		
		if (option == JOptionPane.YES_OPTION)
		{
			int loadReturn = loadChooser.showOpenDialog(null);
			if (loadReturn == JFileChooser.APPROVE_OPTION &&
					loadChooser.getSelectedFile().exists() &&
					unbcFilter.accept(loadChooser.getSelectedFile()))
			{
				saveLocation = loadChooser.getSelectedFile();
				
				//return a loadable file
				loader.loadFromFile(saveLocation);
			}
		}
	}
	
	public void LoadCSVFile(Loadable loader)
	{
		int loadReturn = csvChooser.showOpenDialog(null);
		if (loadReturn == JFileChooser.APPROVE_OPTION && loader.canLoad(csvChooser.getSelectedFile()))
		{
			//return a loadable file
			loader.loadFromFile(csvChooser.getSelectedFile());
		}
	}
}
