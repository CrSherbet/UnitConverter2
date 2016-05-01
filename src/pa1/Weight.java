package pa1;
/**
 * This class is for weight unit that contain the many unit : Gram, Ton, Pound, Ounce, Grain, Chang, and Hap.
 * It has name and standard value of each unit by using enum for store each unit
 * 
 * @author Warisara
 *
 */
public enum Weight implements Unit {

	// create object of each unit that contain name and value inside the object
	GRAM("Gram",1.0),
	TON("Ton",907184.74),
	POUND("Pound",453.59237),
	OUNCE("Ounce",28.34952),
	GRAIN("Grain",0.06479891),
	CHANG("Chang",1200),
	HAP("Hap",60000);
	
	// attributes for each unit
	private final String name ;
	private final double value ;

	/**
	 * Constructor of weight class
	 * @param name is name of unit 
	 * @param value is standard value in term of gram unit
	 */
	private Weight ( String name , double value ){
		this.name = name ;
		this.value = value ;
	}

	/**
	 * This method will return value of the unit
	 * @return standard value in term of gram unit
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
