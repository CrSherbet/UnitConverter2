package pa1;

/**
 * UnitFactory is the class that using singleton pattern for store the information
 * about the type of unit, and unit of the type unit that contain name and value of unit,
 * so we can provide the actual unit values by using this class.
 * 
 * @author Warisara
 *
 */
public class UnitFactory {
	
	//attribute of unit factory by using singleton pattern
	private static UnitFactory unitFactory = null ;
	
	/**
	 * Constructor of unit factory
	 */
	private UnitFactory(){
		
	}
	
	/**
	 * This is structure from singleton pattern that will return the instance
	 * @return unitFactory is this instance
	 */
	public static UnitFactory getInstance(){
		if ( unitFactory == null) 
			unitFactory = new UnitFactory();
		return unitFactory ;
	}
	
	/**
	 * This class for get all unit type that program provided
	 * @return array of known unit type
	 */
	public UnitType[] getUnitTypes(){
		return UnitType.values();
	}

	/**
	 * This class for get the unit of unit type that called this method
	 * @param unitType is the unit type that we want to know all unit
	 * @return the all unit of unit type; unitType
	 */
	public Unit[] getUnits( UnitType unitType ){
		return unitType.getUnit();
	}
}
