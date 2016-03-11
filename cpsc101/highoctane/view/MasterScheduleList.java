package cpsc101.highoctane.view;

import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import cpsc101.highoctane.model.CSVFileFilter;
import cpsc101.highoctane.model.Loadable;
import cpsc101.highoctane.model.MasterSchedule;

public class MasterScheduleList extends JList<String> implements Loadable
{
	private MasterSchedule myMasterSchedule;
	private DefaultListModel<String> model;
	
	public MasterScheduleList()
	{
		myMasterSchedule = new MasterSchedule();
		model = new DefaultListModel<>();
		
		this.setModel(model);
		
		for(int i=0;i<20;i++)
		{
			model.addElement("TEST101      10-1234           Casperson");
			model.addElement("TEST220      6-152                Bluskov");
			model.addElement("TEST141      7-144                Ried");
		}
	}

	@Override
	public void loadFromFile(File file)
	{
		System.out.println("Loading CSV:" + file);
		//LOAD THE CSV WITH A SCANNER OR SOMETHING
		//
		//
		//
	}

	@Override
	public boolean canLoad(File file)
	{
		CSVFileFilter filter = new CSVFileFilter();
		return file.exists() && file.isFile() && filter.accept(file);
	}
}
