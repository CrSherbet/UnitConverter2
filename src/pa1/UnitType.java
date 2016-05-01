package pa1;
/**
 * This class is for unit type that contain the typer of unit : Length, Area, Weight, and Volume.
 * It has name and unit of each type unit, so you can use it for change the objective of the converter.
 * 
 * @author Warisara
 *
 */

public enum UnitType {
	
	// create object of each unit type that contain name and all unit of unit type
	LENGTH("Lenght", Length.values()),
	AREA("Area", Area.values()),
	WEIGHT("Weight", Weight.values()),
	VOLUME("Volume" , Volume.values());
	
	// attributes for each unit type
	private final String name ;
	private final Unit[] unit ;
	
	/**
	 * Constructor of UnitType class
	 * @param name is name of unit type 
	 * @param unit is all unit of unit type
	 */
	private UnitType ( String name , Unit[] unit){
		this.name = name ;
		this.unit = unit ;
	}
	
	/**
	 * This class for get the all unit of unit type
	 * @return unit of unit type
	 */
	public Unit[] getUnit(){
		return unit ;
	}
	
	/**
	 * This class for set the name of menu item in menu bar
	 * @return String of name of unit type
	 */
	public String toString(){
		return name ;
	}
}
