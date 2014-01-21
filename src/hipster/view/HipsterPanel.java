package hipster.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;

import hipster.controller.HipsterController;
import hipster.model.Hipster;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class HipsterPanel extends JPanel
{
	/**
	 * The reference to the HipsterController to maintain a MVC paradigm in the code.
	 */
	private HipsterController baseController;
	
	private SpringLayout baseLayout;
	private JButton SpecificButton;
	private JButton RandomButton;
	private JButton HipsterButton;
	private JButton SelfieButton;
	private JLabel booksLabel;
	private JLabel nameLabel;
	private JLabel phraseLabel;
	private JLabel typeLabel;
	private JTextField nameField;
	private JTextField typeField;
	private JTextField phraseField;
	private JTextArea booksArea;
	private JComboBox selectedHipsterComboBox;
	private URL imageURL;
	private String [] baseArray;
	private PicturePanel picturePanel;
	
	/**
	 * Constructor for the HipsterPanel object. Uses a HIpsterController to link to the MVC paradigm.
	 * @param baseController The reference to the Controller for the project.
	 */
	public HipsterPanel(HipsterController baseController)
	{
		this.baseController = baseController;
		
		baseLayout = new SpringLayout();
		
		RandomButton = new JButton("Show  a  random Hipster");
		HipsterButton = new JButton("Add a Hipster");
		SelfieButton = new JButton("Show the Original Hipster");
		SpecificButton = new JButton("Show a certain Hipster");
		booksLabel = new JLabel("Hipster's book: ");
		nameLabel = new JLabel("Hipster's name: ");
		phraseLabel = new JLabel("Hipster's phrase: ");
		typeLabel = new JLabel("Hipster's type ");
		nameField = new JTextField(25);
		typeField = new JTextField(25);
		phraseField = new JTextField(25);
		
		baseArray = new String[5];
		imageURL = getClass().getResource("/hipster/view/images/hipster.jpg");
		picturePanel = new PicturePanel(imageURL, 200, 200);
		booksArea = new JTextArea(5, 25);
		
		setupComboBox();
		setupLayout();
		setupPanel();
		setupListeners();
	}
	
	/**
	 * Helper method to add components to the panel as well as set secondary values for GUI components.
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.ORANGE);
		this.setSize(1000, 450);
		
		this.add(HipsterButton);
		this.add(RandomButton);
		this.add(SelfieButton);
		this.add(booksArea);
		this.add(booksLabel);
		this.add(nameField);
		this.add(typeField);
		this.add(phraseField);
		this.add(phraseLabel);
		this.add(typeLabel);
		this.add(nameLabel);
		this.add(picturePanel);
		this.add(selectedHipsterComboBox);
		
		booksArea.setLineWrap(true);
		booksArea.setWrapStyleWord(true);
	}
	
	/**
	 * helper method for creating all the needed listeners for the GUI.
	 */
	private void setupListeners()
	{
		/**
		 * Sets the action for when a user clicks the HipsterButton.
		 */
		HipsterButton.addActionListener( new ActionListener()
		{
				public void actionPerformed(ActionEvent click)
				{
					sendHipsterInfoToController();
					updateHipsterComboBox();
					blankFields(false);
				}
		});
			/**
			 * Sets the action for when the user clicks the SelfieButton.
			 */
		SelfieButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				Hipster selfieHipster = baseController.getSelfieHipster();
				populateFields(selfieHipster);
	
			}
			
		});
		/**
		 * Sets the action for when the user clicks the RandomButton.
		 */
		RandomButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
		Hipster randomHipster = baseController.getRandomHipster();
			if	(randomHipster != null)
			{
			populateFields(randomHipster);
			}
			else
			{
				blankFields(true);
			}
			}
			
		});

		/**
		 * Sets the action that is performed when a user clicks the SpecificButton.
		 */
		SpecificButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				Hipster selectedHipster = baseController.getSpecifiedHipster(0);
				if ( selectedHipster != null)
				{
					populateFields(selectedHipster);
				}
				else
				{
					blankFields(true);
				}
			}
			
		});
		
		/**
		 * Inherited combobox that has the hipster's information.
		 */
		selectedHipsterComboBox.addItemListener(new ItemListener()
		{
			@Override
			public void itemStateChanged(ItemEvent itemSelected)
			{
				int currentSelection = selectedHipsterComboBox.getSelectedIndex();
				if (currentSelection >= 0)
				{
					Hipster selectedHipster = baseController.getSpecifiedHipster(currentSelection);
					if (selectedHipster != null)
					{
						populateFields(selectedHipster);
					}
					else
					{
						blankFields(true);
					}
				}
			}
			
		});
	}
	
	/**
	 * Setting the default values in the array for the combo box.
	 */
	private void setupComboBox()
	{
		baseArray[0] = "Me";
		baseArray[1] = "Myself";
		baseArray[2] = "I";
		
		selectedHipsterComboBox = new JComboBox(baseArray);
	}
	
	/**
	 * Putting in new information that has been implemented to the hipster.
	 */
	private void populateFields(Hipster currentHipster)
	{
		//imageURL = getClass().getResource("/hipster/view/images/" + currentHipster.getName() + ".jpg");
		//picturePanel.setPictureSource(imageURL);
		
		nameField.setText(currentHipster.getName());
		typeField.setText(currentHipster.getHipsterType());
		phraseField.setText(currentHipster.getHipsterPhrase());
		booksArea.setText("");
		
		for (String temp : currentHipster.getHipsterBooks())
		{
			booksArea.append(temp + ",  ");
		}
		
		imageURL = getClass().getResource("/hipster/view/images" + currentHipster.getName() + ".jpg");
		
		if(imageURL != null)
		{
			picturePanel.setPictureSource(imageURL);
			picturePanel.repaint();
		}
		else
		{
			imageURL = getClass().getResource("/hipster/view/images/default.jpg");
			picturePanel.setPictureSource(imageURL);
			picturePanel.repaint();
			JOptionPane.showMessageDialog(this, "Sorry no picture for you :(");
		}
		
	}

	/**
	 * Setting the default information.
	 * @param poorInput
	 */
	private void blankFields(boolean poorInput)
	{
		nameField.setText("");
		typeField.setText("");
		phraseField.setText("");
		booksArea.setText("");
		
		if(poorInput)
		{
			JOptionPane.showMessageDialog(this, "Please use valid options or else......");
		}
	}
	
	/**
	 * Sends information to the HipsterController.
	 */
	private void sendHipsterInfoToController()
	{
		String [] books = booksArea.getText().split(",  ");
		baseController.addHipster(books, nameField.getText(), typeField.getText(), phraseField.getText());
		JOptionPane.showMessageDialog(this, "Hipster added to the array.");
	}
	
	/**
	  AutoGenerated layout information for the Springlayout settings.
	 */
	private void setupLayout()
	{
		 baseLayout.putConstraint(SpringLayout.NORTH, SelfieButton, 65, SpringLayout.SOUTH, RandomButton);
	        baseLayout.putConstraint(SpringLayout.WEST, SpecificButton, 263, SpringLayout.WEST, this);
	        baseLayout.putConstraint(SpringLayout.SOUTH, SpecificButton, -83, SpringLayout.SOUTH, this);
	        baseLayout.putConstraint(SpringLayout.WEST, SelfieButton, 0, SpringLayout.WEST, nameLabel);
	        baseLayout.putConstraint(SpringLayout.WEST, RandomButton, 0, SpringLayout.WEST, nameLabel);
	        baseLayout.putConstraint(SpringLayout.NORTH, HipsterButton, 22, SpringLayout.SOUTH, booksArea);
	        baseLayout.putConstraint(SpringLayout.WEST, HipsterButton, 0, SpringLayout.WEST, nameLabel);
	        baseLayout.putConstraint(SpringLayout.NORTH, selectedHipsterComboBox, 18, SpringLayout.SOUTH, RandomButton);
	        baseLayout.putConstraint(SpringLayout.WEST, selectedHipsterComboBox, 0, SpringLayout.WEST, HipsterButton);
	        baseLayout.putConstraint(SpringLayout.NORTH, booksLabel, 0, SpringLayout.NORTH, booksArea);
	        baseLayout.putConstraint(SpringLayout.WEST, booksLabel, 0, SpringLayout.WEST, nameLabel);
	        baseLayout.putConstraint(SpringLayout.NORTH, nameField, 22, SpringLayout.NORTH, this);
	        baseLayout.putConstraint(SpringLayout.NORTH, nameLabel, 6, SpringLayout.NORTH, nameField);
	        baseLayout.putConstraint(SpringLayout.WEST, nameLabel, 0, SpringLayout.WEST, phraseLabel);
	        baseLayout.putConstraint(SpringLayout.NORTH, typeLabel, 6, SpringLayout.NORTH, typeField);
	        baseLayout.putConstraint(SpringLayout.WEST, typeLabel, 0, SpringLayout.WEST, phraseLabel);
	        baseLayout.putConstraint(SpringLayout.NORTH, phraseLabel, 6, SpringLayout.NORTH, phraseField);
	        baseLayout.putConstraint(SpringLayout.WEST, phraseLabel, 10, SpringLayout.WEST, this);
	        baseLayout.putConstraint(SpringLayout.NORTH, booksArea, 18, SpringLayout.SOUTH, phraseField);
	        baseLayout.putConstraint(SpringLayout.WEST, booksArea, 0, SpringLayout.WEST, nameField);
	        baseLayout.putConstraint(SpringLayout.NORTH, phraseField, 17, SpringLayout.SOUTH, typeField);
	        baseLayout.putConstraint(SpringLayout.NORTH, typeField, 11, SpringLayout.SOUTH, nameField);
	        baseLayout.putConstraint(SpringLayout.WEST, typeField, 0, SpringLayout.WEST, nameField);
	        baseLayout.putConstraint(SpringLayout.WEST, phraseField, 0, SpringLayout.WEST, nameField);
	        baseLayout.putConstraint(SpringLayout.WEST, nameField, 175, SpringLayout.WEST, this);
	        baseLayout.putConstraint(SpringLayout.NORTH, picturePanel, -220, SpringLayout.SOUTH, this);
	        baseLayout.putConstraint(SpringLayout.WEST, picturePanel, -200, SpringLayout.EAST, this);
	        baseLayout.putConstraint(SpringLayout.SOUTH, picturePanel, -20, SpringLayout.SOUTH, this);
	        baseLayout.putConstraint(SpringLayout.EAST, picturePanel, -20, SpringLayout.EAST, this);
	        baseLayout.putConstraint(SpringLayout.NORTH, RandomButton, 18, SpringLayout.SOUTH, HipsterButton);
	}
	
	/**
	 * Collecting names that will be stored in the combobox.
	 * @return
	 */
	private String [] getNamesForComboBox()
	{
		int realValues = 0;
		for (int count = 0; count < baseController.getClassHipster().length; count++)
		{
			if (baseController.getClassHipster()[count] != null)
			{
				realValues++;
			}
		}
		
		String [] tempNames = new String[realValues];
		
		for ( int realSize = 0; realSize < realValues; realSize++)
		{
			tempNames[realSize] = baseController.getClassHipster()[realSize].getName();
		}
		
		return tempNames ;
	}
	
	/**
	 * Putting new information inside the combobox and array.
	 */
	private void updateHipsterComboBox()
	{
		String [] comboValues = getNamesForComboBox();
		selectedHipsterComboBox.setModel(new DefaultComboBoxModel(comboValues));
	}
	

}
