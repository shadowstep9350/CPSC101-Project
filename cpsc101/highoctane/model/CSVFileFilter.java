package cpsc101.highoctane.model;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class CSVFileFilter extends FileFilter
{
	public boolean accept(File f)
	{
		boolean accepts = false;
		String[] splitName;
		if (f.isDirectory())
		{
			accepts = true;
		}
		else
		{
			splitName = f.getName().split("\\.");
			if (splitName.length > 1)
				accepts = splitName[splitName.length - 1].equals("csv");
		}

		return accepts;
	}

	@Override
	public String getDescription()
	{
		// TODO Auto-generated method stub
		return "Comma Separated Value File (.csv)";
	}
}
