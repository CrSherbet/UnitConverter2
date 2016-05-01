package pa1;

/**
* This class is for volume unit that contain the many unit : Liter, Bushel, Pint, Quart, Gallon, Thanan, and Thang.
* It has name and standard value of each unit by using enum for store each unit
* 
* @author Warisara
*
*/
public enum Volume implements Unit {
	
	// create object of each unit that contain name and value inside the object
	LITER("Liter",1.0),
	BUSHEL("Bushel",35.23907),
	PINT("Pint",0.473175),
	QUART("Quart",0.94635),
	GALLON("Gallon",3.78541),
	THANAN("THANAN",1.0),
	THANG("Thang",20.0);

	// attributes for each unit
	private final String name ;
	private final double value ;
	
	
	/**
	 * Constructor of volume class
	 * @param name is name of unit 
	 * @param value is standard value in term of liter unit
	 */
	private Volume ( String name , double value ){
		this.name = name ;
		this.value = value ;
	}

	/**
	 * This method will return value of the unit
	 * @return standard value in term of liter unit
	 */
	public double getValue(){
		return value ;
	}
	
	/**
	 * This method will return name of the unit
	 * @return name is name of unit
	 */
	public String toString(){
		return name ;
	}
}
