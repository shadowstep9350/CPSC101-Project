package cpsc101.highoctane.view;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Scanner;

import javax.swing.*;

import cpsc101.highoctane.model.*;

public class ScheduleFrame extends JFrame implements Savable, Loadable
{
	public static final int SPACING = 5;
	
	private static UNBCFileManager fileManager;
	SchedulePanel schedulePanel;
	ControlPanel controlPanel;
	
	public ScheduleFrame()
	{
		fileManager = new UNBCFileManager();
		final Savable configSaver = this;
		final Loadable configLoader = this;
		
		//setting up the frame
		setTitle("UNBC Schedule Viewer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		//setMinimumSize(new Dimension(400,300));
		//resizing things is terrible to deal with
		//setResizable(false);
		
		//setting up the general panels
		schedulePanel = new SchedulePanel();
		controlPanel = new ControlPanel();
		add(schedulePanel);
		add(controlPanel,BorderLayout.EAST);
		
		//setting up the menu
		JMenuBar menu = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu helpMenu = new JMenu("Help");
		JMenuItem tempItem;
		
		tempItem = new JMenuItem("Load Configuration...");
		tempItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				fileManager.LoadUNBCFile(configLoader);
			}});
		fileMenu.add(tempItem);
		
		fileMenu.addSeparator();
		
		tempItem = new JMenuItem("Save");
		tempItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				fileManager.SaveFile(configSaver, false);
			}});
		fileMenu.add(tempItem);
		
		tempItem = new JMenuItem("Save as...");
		tempItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				fileManager.SaveFile(configSaver, true);
			}});
		fileMenu.add(tempItem);
		
		fileMenu.addSeparator();
		
		tempItem = new JMenuItem("Import CSV...");
		tempItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Loadable loader = controlPanel.getCSVLoader();
				fileManager.LoadCSVFile(loader);
			}});
		fileMenu.add(tempItem);
		
		tempItem = new JMenuItem("(not yet implemented)");//"Help");
		tempItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//MAKE A HELP MENU POPUP OR SOMETHING
				//
				//
				//
			}});
		helpMenu.add(tempItem);
		
		menu.add(fileMenu);
		menu.add(helpMenu);
		setJMenuBar(menu);
		
		setVisible(true);
	}

	@Override
	public boolean canLoad(File file)
	{
		UNBCFileFilter filter = new UNBCFileFilter();
		return file.exists() && file.isFile() &&filter.accept(file);
	}

	@Override
	public void loadFromFile(File file)
	{
		System.out.println("Loading from: "+file);
		//ACTUALLY LOAD FROM THE FILE
		//
		//
		//
	}

	@Override
	public void saveToFile(File file)
	{
		System.out.println("Saving to: "+file);
		//ACTUALLY SAVE TO THE FILE
		//
		//
		//
	}
}
