/* File name: DrumPanel.java
 * Author: Fiona Ang, 041151067
 * Course: CST8284 – OOP
 * Assignment: Assignment 2
 * Due date: March 23, 2025 11:59 PM
 * Professor: Amal Ibrahim
 * Purpose: This class is for the graphical interface.
 * Class list: Drum, FlammableDrum, ToxicDrum, DrumPanel, Drum_Test.
 */

/**
 * DESCRIPTION: 
 * @version: openjdk 21.0.4 2024-07-16 LTS
 * @since: javac 21.0.4
 * @see java.lang.Object
 * @author Fiona Ang
 */

package graphicalInterface;

import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.List;

import domain.Drum;
import domain.ToxicDrum;
import domain.FlammableDrum;

/**
 * This class is the main panel/container object for the application GUI widgets.
 * This is a java Swing application.
 */
public class DrumPanel extends JPanel {

	/**
	 * a label for number of drums to create.
	 */
	private JLabel drumPrompt;
	
	/**
	 * a text field for user to enter the number of drums to create.
	 */
	private JTextField numberToCreate;
	
	/**
	 * a radio button to select flammable drum type.
	 */
	private JRadioButton flammableDrumType;
	
	/**
	 * a radio button to select toxic drum type.
	 */
	private JRadioButton toxicDrumType;
	
	/**
	 * a button to create drums.
	 */
	private JButton createDrums;
	
	/**
	 * a button to run tests.
	 */
	private JButton runTests;
	
	/**
	 * a text area to show the test results.
	 */
	private JTextArea testResults;
	
	/**
	 * a label to show the status.
	 */
	private JLabel statusField;

	/** List of drums creates.													*/
	List<Drum> listOfDrums = new ArrayList<Drum>();
	
	/** Serial version required. */
	private static final long serialVersionUID = 1L;

	/**
	 * Create and populate the main drum panel with appropriate GUI widgets.
	 */
	public DrumPanel() {
		initGUI();
	}

	/**
	 * Create and populate the panel with appropriate GUI components.
	 */
	private void initGUI() {
		setToolTipText("When finished with the application click the 'X' on the top bar, right side to close the application");
		setLayout(new FlowLayout());	
		
		JPanel p = new JPanel();

		p.add(createDrumTypePanel());
		p.add(createDrumNumberPanel());
		Box box = new Box(BoxLayout.Y_AXIS);
		box.add(p);
		
		box.add(createButtonPanel());

		add(box,TOP_ALIGNMENT);
		add(createResultsPanel(),CENTER_ALIGNMENT);
		statusField = new JLabel("Status field for errors etc.");
		add(statusField,BOTTOM_ALIGNMENT);
	}

	/**
	 * The method createResultsPanel which display the results panel.
	 * @return the panel of trp
	 */
	private JPanel createResultsPanel()	{
		JPanel trp = new JPanel();
		testResults = new JTextArea(25, 50);
		testResults.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Results"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		testResults.setBorder(BorderFactory.createRaisedBevelBorder());
		JScrollPane sp = new JScrollPane(testResults);
		trp.add(sp);
		return trp;
	}
	
	/**
	 * Create the drum number panel.
	 * 
	 * @return the panel of numberPanel
	 */
	private JPanel createDrumNumberPanel() {
		drumPrompt = new JLabel("Number of drums to create ");
		drumPrompt.setToolTipText("The number of drums to create");
		numberToCreate = new JTextField(10);
		numberToCreate.setToolTipText("Enter the number of drums to create");
		
		JPanel numberPanel = new JPanel();
		numberPanel.setLayout(new BoxLayout(numberPanel, BoxLayout.X_AXIS));
		numberPanel.add(drumPrompt);
		numberPanel.add(numberToCreate);
		numberPanel.setBorder(BorderFactory.createRaisedBevelBorder());

		return numberPanel;
	}

	/**
	 * Create the drum button panel.
	 * 
	 * @return The panel object containing the buttons.
	 */
	private JPanel createButtonPanel() {
		createDrums = new JButton("Create Drums");
		createDrums.setToolTipText("Click me to create the specified number and type of drums to create");
		createDrums.addActionListener( new ActionListener()	{
			public void actionPerformed(ActionEvent ae)	{
				int numberOfDrums = Integer.parseInt(numberToCreate.getText());
				
				/* Get type of drums to create*/
				if (flammableDrumType.isSelected())	{
					for (int i = 0; i < numberOfDrums; i++) {
						listOfDrums.add(new FlammableDrum(22.0f, 16.0f, "Flammable Liquid", 200));
					}
					
					testResults.append("\n\nCreating [" + numberOfDrums + "] Flammable Drums\n\n");
				}	
				
				else if(toxicDrumType.isSelected()) {
					for (int i = 0; i < numberOfDrums; i++) {
						ToxicDrum toxicDrum = new ToxicDrum();
						listOfDrums.add(new ToxicDrum(36.0f, 24.0f, "Radioactive Isotopes", toxicDrum.CLASS_IA));
					}
					testResults.append("\n\nCreating [" + numberOfDrums + "] Toxic Drums\n\n");
					
				}	else	{
					statusField.setText("NO Drum type has been selected");
				}
			}});

				
		runTests = new JButton("Run Tests");
		runTests.addActionListener( new ActionListener()	{
			public void actionPerformed(ActionEvent ae)	{
				statusField.setText("*** Testing Drum Value Display ***");

				int index = 1;
				for (Drum drum : listOfDrums) {
					String drumDetails = drum.toString();
					testResults.append("\n[" + index + "]: " + drumDetails);
					index++;
				}
				
			}});

		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

		buttonPanel.add(createDrums);
		buttonPanel.add(runTests);
		
		buttonPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Action"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		buttonPanel.setBorder(BorderFactory.createRaisedBevelBorder());

		return buttonPanel;
	}

	
	/**
	 * Create the drum creation panel.
	 * @return the panel of typePanel
	 */
	private JPanel createDrumTypePanel() {
		flammableDrumType = new JRadioButton("Flammable Drum");
		toxicDrumType = new JRadioButton("Toxic Drum");
		ButtonGroup group = new ButtonGroup();
		group.add(toxicDrumType);
		group.add(flammableDrumType);
		JPanel typePanel = new JPanel();
		typePanel.setLayout(new BoxLayout(typePanel, BoxLayout.Y_AXIS));
		typePanel.add(flammableDrumType);
		typePanel.add(toxicDrumType);
		typePanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Types of Drums"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		typePanel.setBorder(BorderFactory.createRaisedBevelBorder());

		return typePanel;
	}

}
