package myTry;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Memorator { // extends JFrame {
	
	private JPanel windowContent;
	private JTextField displayField;
	private JButton[] buttons;
	private String[] buttonsName;
	
	private GridBagLayout gridBagLayout;
	private GridBagConstraints constraints;
	
	private JTabbedPane tabbedPane;
	
	public String getDisplayFieldText() {
		return displayField.getText();
	}
	
	public void setDisplayFieldText(String displayField) {
		this.displayField.setText(displayField);
	}
	
	JFrame frama = new JFrame(); 
	
	Memorator() {
		
		tabbedPane = new JTabbedPane();
		
		JPanel blContent = new JPanel();
		BorderLayout bl = new BorderLayout();
		blContent.setLayout(bl);
		
		windowContent = new JPanel();
		JPanel cards2 = new JPanel();
		JButton myButton = new JButton ("Click me");
		cards2.add(myButton);
		
		JButton previous = new JButton("Previous");
		JButton next = new JButton("Next");
		JButton memo = new JButton("Memo");
		
		//set layout manager for this panel
		gridBagLayout = new GridBagLayout();
		windowContent.setLayout(gridBagLayout);
		
		//create the instance of the GridBagConstraints
		constraints = new GridBagConstraints();
		
		//setting constraints for the displayField
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		constraints.anchor = GridBagConstraints.CENTER;
		
		//Settings buttons names
				String[] buttonNames = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
						".", "=", "+", "-", "*", "/"};
				
		//Settings buttons
		buttons = new JButton[buttonNames.length];
		
		//adding buttons and action listeners
		for(int i = 0; i < buttonNames.length; i++) {
			buttons[i] = new JButton(buttonNames[i]);
			//buttons[i].addActionListener(calculatorEngine);
		}
		
		//add the first button row
		addComponent(windowContent, buttons[1], 1, 0, 2, 1);
		addComponent(windowContent, buttons[2], 1, 2, 2, 1);		
		addComponent(windowContent, buttons[3], 1, 4, 2, 1);
		addComponent(windowContent, buttons[12], 1, 6, 1, 1);
		
		//add the second button row
		addComponent(windowContent, buttons[4], 2, 0, 2, 1);
		addComponent(windowContent, buttons[5], 2, 2, 2, 1);		
		addComponent(windowContent, buttons[6], 2, 4, 2, 1);
		addComponent(windowContent, buttons[13], 2, 6, 1, 1);
		
		//add the third button row
		addComponent(windowContent, buttons[7], 3, 0, 2, 1);
		addComponent(windowContent, buttons[8], 3, 2, 2, 1);		
		addComponent(windowContent, buttons[9], 3, 4, 2, 1);
		addComponent(windowContent, buttons[14], 3, 6, 1, 1);
		
		//add the fourth button row
		addComponent(windowContent, buttons[0], 4, 0, 2, 1);
		addComponent(windowContent, buttons[10], 4, 2, 2, 1);		
		addComponent(windowContent, buttons[11], 4, 4, 2, 1);
		addComponent(windowContent, buttons[15], 4, 6, 1, 1);
						
		
		//adding displayField
		displayField = new JTextField();
		displayField.setHorizontalAlignment(JTextField.RIGHT);
		//addComponent(windowContent, displayField, 0, 0, 7, 1);
		
		blContent.add(windowContent, BorderLayout.CENTER);
		blContent.add(previous, BorderLayout.LINE_START);
		blContent.add(next, BorderLayout.LINE_END);
		blContent.add(displayField, BorderLayout.PAGE_START);
		blContent.add(memo, BorderLayout.PAGE_END);
		
		//fill tabbedPane
		tabbedPane.addTab("My first tab!", blContent);
		tabbedPane.addTab("My second tab!", cards2);
		
				
		// set the frame content
		frama.setContentPane(tabbedPane);
		frama.setVisible(true);
		frama.pack();
	} //end of constructor Memorator
	
	private void addComponent(Container container, Component component, int row, 
			int column, int width, int height) {
		constraints.fill = GridBagConstraints.BOTH;
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		constraints.gridx = column;
		constraints.gridy = row;
		constraints.gridheight = height;
		constraints.gridwidth = width;
		gridBagLayout.setConstraints(component, constraints);
		container.add(component);
	} //end method addComponent

	public static void main(String[] args) {
		Memorator memorator = new Memorator();
	}

}
