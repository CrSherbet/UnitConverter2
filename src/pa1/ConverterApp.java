package pa1;

public class ConverterApp {
	/**
	 * Main class for run unit-converter program
	 * @param args was not used
	 */
	public static void main(String[] args) {
		// create the object and GUI
		UnitConverter unit = new UnitConverter();
		ConverterUI converterUI = new ConverterUI(unit);
		converterUI.run();
	}

}
