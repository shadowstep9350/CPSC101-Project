package cpsc101.highoctane.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class SchedulePanel extends JTabbedPane
{
	//the height of the tabs in a TabbedPane
	public static final int TAB_HEIGHT = 21;
	
	public SchedulePanel()
	{
		setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		addDebugPanels();
	}
	
	private void addDebugPanels()
	{
		for(int i=0;i<20;i++)
		{
			JPanel test = new JPanel();
			test.setBackground(new Color(255-i*5,10*i,100-5*i));
			add("Test "+i,test);
			setTabComponentAt(i,new ScheduleTab(this,"TEST "+i));
		}
	}
}
