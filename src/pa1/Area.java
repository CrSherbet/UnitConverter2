package pa1;

/**
 * This class is for area unit that contain the many unit : Square Meter, Square Kilometer, Square Centimeter, Square Mile, Square Foot, Square Wa, and Sen.
 * It has name and standard value of each unit by using enum for store each unit
 * 
 * @author Warisara
 *
 */
public enum Area implements Unit {

	// create object of each unit that contain name and value inside the object
	SQRMETER("Square Meter",1.0),
	SQRKILOMETER("Square Kilometer",1000000.0),
	SQRCENTIMETER("Square Centimeter",0.000001),
	SQRMILE("Square Mile",2589988.11),
	SQRFOOT("Square Foot",0.09290304),
	SQRWA("Square Wa",4.0),
	NGAN("Ngan",400.0);
	
	// attributes for each unit
	private final String name ;
	private final double value ;

	/**
	 * Constructor of area class
	 * @param name is name of unit 
	 * @param value is standard value in term of square meter unit
	 */
	private Area ( String name , double value ){
		this.name = name ;
		this.value = value ;
	}

	/**
	 * This method will return value of the unit
	 * @return standard value in term of square meter unit
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
	


