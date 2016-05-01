package pa1;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is GUI of converter that show two block for input the value and choose the unit by using combo box.
 * In this program, we provide many type of unit that you can choose it  for convert the value to another unit and 
 * it has clear button for clear any data
 * 
 * @author Warisara
 *
 */
public class ConverterUI extends JFrame {
	
	// attributes for graphical component
	private JButton convertButton;
	private JButton clearButton;
	private JTextField firstInputField;
	private JTextField secondInputField;
	private JComboBox<Unit> firstUnit;
	private JComboBox<Unit> secondUnit;
	private JLabel equalSign;
	private UnitConverter converter;
	private JMenuBar menuBar ;
	private JMenu unitTypeMenu ;
	
	/**
	 * Constructor of ConverterUI
	 * @param uc is unit converter
	 */
	public ConverterUI(UnitConverter uc) {
		// set initial value
		this.converter = uc;
		this.setTitle("Unit Converter");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponent();
	}
	
	/**
	 * This method will set JFrame to be visible and set size to cannot change
	 */
	public void run() {
		pack();
		setVisible(true);
	}
	
	/**
	 * create initial component of the window
	 */
	private void initComponent() {
		// create element components 
		firstInputField = new JTextField(10);
		secondInputField = new JTextField(10);
		convertButton = new JButton("Convert!");
		clearButton = new JButton("Clear");
		equalSign = new JLabel(" = ");	
		menuBar = new JMenuBar ();
		unitTypeMenu = makeMenu();
		firstUnit = new JComboBox<Unit> (Length.values());
		secondUnit = new JComboBox<Unit> (Length.values());
		
	
		// set bounds and layout of this window
		setLayout(new FlowLayout());
		
		// add component to the window
		setJMenuBar(menuBar);
		add(firstInputField);
		add(firstUnit);
		add(equalSign);
		add(secondInputField);
		add(secondUnit);
		add(convertButton);
		add(clearButton);
		
		// separate menu by using line and add exit menu into menu bar
		unitTypeMenu.addSeparator();
		unitTypeMenu.add( new ExitAction());
		menuBar.add( unitTypeMenu );
		
		// create action listener of each action
		ActionListener convertButtonAction = new ConvertButtonListener();
		ActionListener clearButtonAction = new ClearButtonListener();
		
		// add action listener into the button
		convertButton.addActionListener(convertButtonAction);
		firstInputField.addActionListener(convertButtonAction);
		secondInputField.addActionListener(convertButtonAction);
		clearButton.addActionListener(clearButtonAction);
		
	}
	
	/**
	 * This class for make the menu inside menu bar( type of unit that the program provided ) and action listener for each menu
	 * @return JMenu for add into menu bar
	 */
	private JMenu makeMenu() {
		// create a menu 
	    JMenu menu = new JMenu("Unit Type");
	    UnitType [] unittypes = UnitFactory.getInstance().getUnitTypes();
	    
	    // create menu items inside the menu and add action listener
	    for(UnitType utype : unittypes ) {
	        JMenuItem menuItem = new JMenuItem( utype.toString() );
	        menuItem.addActionListener( new UnitAction( utype ) );
	        menu.add( menuItem );
	    }
	    return menu;
	}
	
	/**
	 * 
	 * This class that add action listener of unit type menu items. When you choose a type unit, it will remove old combo box 
	 * and add new combo box of new unit type.
	 * 
	 * @author Warisara
	 *
	 */
	class UnitAction extends AbstractAction {
		// attribute of UnitAction class, it will keep the unit of the type of unit
		private Unit[] unitOfMenu ;
		
		/*
		 * Setting the name of menu item and keep the unit 
		 */
		public UnitAction( UnitType utype ){
			super(utype.toString());
			unitOfMenu = utype.getUnit();
		}
		
		/**
		 * Addition action listener for each menu item : remove and add new combo box
		 */
		public void actionPerformed( ActionEvent e){
			firstUnit.removeAllItems();
			secondUnit.removeAllItems();
			for (int i = 0 ; i < unitOfMenu.length ; i++ ){
				firstUnit.addItem( unitOfMenu[i] );
				secondUnit.addItem( unitOfMenu[i] );
			}
			pack();
		}
	}
	
	/**
	 * This class for action listener of exit menu
	 * @author Warisara
	 *
	 */
	class ExitAction extends AbstractAction {
		
		/**
		 * Setting name of menu item
		 */
		public ExitAction(){
			super("Exit");
		}
		
		/**
		 * Close the window and terminate the program
		 */
		public void actionPerformed( ActionEvent e){
			dispose();
		}
	}
	
	/**
	 * This class is action listener of clear button that will clear any data or set default
	 * @author Warisara
	 */
	class ClearButtonListener implements ActionListener {
		/**
		 * This method is action of clear button
		 * @param e was not used
		 */
		public void actionPerformed(ActionEvent e) {
			firstInputField.setText("");			
			secondInputField.setText("");
			firstUnit.setSelectedIndex(0);
			secondUnit.setSelectedIndex(0);
		}
	}
	
	/**
	 * This class is action listener of convert button that will convert from the unit that user choose and input value
	 * to another unit
	 * 
	 * @author Warisara
	 * 
	 */
	class ConvertButtonListener implements ActionListener {
		/**
		 * This method is action of convert button
		 * @param e was not used
		 */
		public void actionPerformed(ActionEvent e) {
			double result ;
			firstInputField.setForeground( Color.BLACK );
			String inputValue = firstInputField.getText().trim();
			
			if (inputValue.length() > 0) {
				//throw exception when input value isn't number or value is alphabet
				try {
					double value = Double.valueOf( inputValue );
					result = converter.convert(value, (Unit) firstUnit.getSelectedItem(),
								(Unit) secondUnit.getSelectedItem());
					secondInputField.setText(String.format("%.8g", result));
				} catch (NumberFormatException exception) {
					// show red text inside text field
					firstInputField.setForeground( Color.RED );
					exception.getMessage();
				}
			}
		}
	}
	
}
