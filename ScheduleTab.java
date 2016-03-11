package cpsc101.highoctane.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ScheduleTab extends JPanel
{
	private final JTabbedPane myParent;
	
	public ScheduleTab(JTabbedPane parent,String name)
	{
		myParent = parent;
		JLabel label = new JLabel(name);
		JButton button = new JButton();
		//button.setFont(getFont().deriveFont(8f));
		//button.setText("x");
		button.setToolTipText("Close this tab");
		button.setPreferredSize(new Dimension(16,16));
		
		setOpaque(false);
		add(label);
		add(button);
		
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = myParent.indexOfTabComponent(ScheduleTab.this);
				//System.out.println(index);
				if(index != -1)
				{
					myParent.remove(index);
				}
			}});
	}
}
