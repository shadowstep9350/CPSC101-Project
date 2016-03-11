package cpsc101.highoctane.view;

import java.awt.Dimension;

import javax.swing.*;

public class LabeledTextField extends JPanel
{
	public static final int FIELD_WIDTH = 150;
	JTextField textField;
	
	public LabeledTextField(String labelText)
	{
		JLabel label = new JLabel(labelText);
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(FIELD_WIDTH,getPreferredSize().height));
		textField.setMaximumSize(new Dimension(FIELD_WIDTH,getMaximumSize().height));
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		add(Box.createHorizontalStrut(ControlPanel.BUFFER_WIDTH));
		add(label);
		add(Box.createHorizontalGlue());
		add(textField);
		add(Box.createHorizontalStrut(ControlPanel.BUFFER_WIDTH));
		
		setMaximumSize(new Dimension(Integer.MAX_VALUE,getPreferredSize().height));
		
		textField.setText("");
	}
	
	public String getText()
	{
		return textField.getText();
	}
}
