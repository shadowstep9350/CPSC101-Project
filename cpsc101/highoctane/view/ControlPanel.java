package cpsc101.highoctane.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import cpsc101.highoctane.model.Loadable;
import cpsc101.highoctane.model.MasterSchedule;

public class ControlPanel extends JPanel
{
	public static final int CONTROL_PANEL_WIDTH = 300,
							BUFFER_WIDTH = 20;
	MasterScheduleList myMasterList;
	
	public ControlPanel()
	{
		BoxLayout layout = new BoxLayout(this,BoxLayout.Y_AXIS);
		
		setLayout(layout);
		
		LabeledTextField courseBox = new LabeledTextField("Course Code:");
		LabeledTextField roomBox = new LabeledTextField("Room Number:");
		LabeledTextField profBox = new LabeledTextField("Professor:");
		JButton filterButton = new JButton("Filter");
		JPanel filterPanel = new JPanel();
		myMasterList = new MasterScheduleList();
		JScrollPane scheduleScroller = new JScrollPane(myMasterList);
		JButton addButton = new JButton("Add");
		JPanel addPanel = new JPanel();
		
		filterPanel.setLayout(new BoxLayout(filterPanel,BoxLayout.X_AXIS));
		filterPanel.add(Box.createGlue());
		filterPanel.add(filterButton);
		filterPanel.add(Box.createGlue());
		filterPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE,filterButton.getPreferredSize().height));
		filterPanel.setPreferredSize(filterPanel.getMaximumSize());
		
		addPanel.setLayout(new BoxLayout(addPanel,BoxLayout.X_AXIS));
		addPanel.add(Box.createGlue());
		addPanel.add(addButton);
		addPanel.add(Box.createGlue());
		addPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE,addButton.getPreferredSize().height));
		addPanel.setPreferredSize(addPanel.getMaximumSize());
		
		add(Box.createVerticalStrut(SchedulePanel.TAB_HEIGHT));
		add(courseBox);
		add(Box.createVerticalStrut(10));
		add(roomBox);
		add(Box.createVerticalStrut(10));
		add(profBox);
		add(Box.createVerticalStrut(10));
		add(filterPanel);
		add(Box.createVerticalStrut(10));
		add(scheduleScroller);
		add(Box.createVerticalStrut(10));
		add(addPanel);
		add(Box.createVerticalStrut(10));
		
		addButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Adding a Course!");
			}});
		
		setPreferredSize(new Dimension(CONTROL_PANEL_WIDTH,Integer.MAX_VALUE));
	}
	
	public Loadable getCSVLoader()
	{
		return myMasterList;
	}
}
