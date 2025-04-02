import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Date;

@SuppressWarnings("serial")
public class Car {
	private String vin, locationBuilt, make, model, color, type;
	private int year;
	private Engine engine;
	private Transmission transmission;
	private Wheel wheel;
	
	private static final Map<Character, String> VIN_LOCATION_MANUFACTURER = Collections.unmodifiableMap(new HashMap<Character, String>() {{
        put('1', "United States");
        put('2', "Canada");
        put('3', "Mexico");
        put('4', "United States");
        put('5', "United States");
        put('J', "Japan");
        put('L', "China");
        put('K', "Korea");
    }});
	
	private static final Map<Character, String> VIN_MAKE = Collections.unmodifiableMap(new HashMap<Character, String>() {{
        put('H', "Honda");
        put('V', "Volkswagen");
        put('G', "General Motors/Chevrolet");
        put('T', "Toyota");
        put('F', "Ford");
        put('Y', "Tesla");
    }});
	
	private static final Map<Character, String> VIN_TYPE_HONDA = Collections.unmodifiableMap(new HashMap<Character, String>() {{
        put('L', "SUV");
        put('M', "Sedan");
        put('V', "Minivan");	
        put('1', "Truck");
    }});
	
	private static final Map<Character, String> VIN_TYPE_VW = Collections.unmodifiableMap(new HashMap<Character, String>() {{
        put('G', "SUV");
        put('W', "Sedan");
        put('2', "Minivan");	
        put('3', "Truck");
    }});
		
	private static final Map<Character, String> VIN_TYPE_GM = Collections.unmodifiableMap(new HashMap<Character, String>() {{
        put('K', "SUV");
        put('0', "Sedan");
        put('1', "Sedan");
        put('S', "Sports");
        put('V', "Minivan");
        put('T', "Truck");
    }});
	
	private static final Map<Character, String> VIN_TYPE_TOYOTA = Collections.unmodifiableMap(new HashMap<Character, String>() {{
        put('E', "SUV");
        put('L', "SUV");
        put('3', "SUV");
        put('D', "Sedan");
        put('G', "Sedan");
        put('K', "Sedan");
        put('1', "Sedan");
        put('X', "Sports");
        put('M', "Minivan");
        put('A', "Truck");
        put('B', "Truck");
        put('F', "Truck");
        put('4', "Truck");
        		
    }});
	
	private static final Map<Character, String> VIN_TYPE_FORD = Collections.unmodifiableMap(new HashMap<Character, String>() {{
        put('A', "SUV");
        put('0', "Sedan");
        put('1', "Sedan");
        put('2', "Sedan");
        put('3', "Sedan");
        put('4', "Sedan");
        put('5', "Sedan");
        put('6', "Sedan");
        put('7', "Sedan");
        put('8', "Sedan");
        put('9', "Sedan");
        put('V', "Sports");
        put('M', "Minivan");
        put('T', "Truck");
    }});
	
	private static final Map<Character, String> VIN_TYPE_TESLA = Collections.unmodifiableMap(new HashMap<Character, String>() {{
        put('A', "SUV");
        put('J', "Sedan");
        put('Z', "Sports");
        put('2', "Truck");
    }});
		
	private static final Map<Character, Integer> VIN_YEAR = Collections.unmodifiableMap(new HashMap<Character, Integer>() {{
        put('S', 1995);
        put('T', 1996);
        put('V', 1997);
        put('W', 1998);
        put('X', 1999);
        put('Y', 2000);
        put('1', 2001);
        put('2', 2002);
        put('3', 2003);
        put('4', 2004);
        put('5', 2005);
        put('6', 2006);
        put('7', 2007);
        put('8', 2008);
        put('9', 2009);
        put('A', 2010);
        put('B', 2011);
        put('C', 2012);
        put('D', 2013);
        put('E', 2014);
        put('F', 2015);
        put('G', 2016);
        put('H', 2017);
        put('J', 2018);
        put('K', 2019);
        put('L', 2020);
        put('M', 2021);
        put('N', 2022);
        put('P', 2023);
        put('R', 2024);
    }});
	
	public Car() {
		vin = "";
		locationBuilt = "";
		make = "";
		model = "";
		color = "";
		type = "";
		year = -1;
	}
	
	public Car(String vin) {
		this.vin = vin;
		setVinValues();
	}
	
	class Engine {
		private String layout;
		private int cylinders;
		
		Engine(String layout, int cylinders){
			this.layout = layout;
			if (layout.compareToIgnoreCase("electric") == 0) {
				this.cylinders = 0;
			}
			else {
				this.cylinders = cylinders;
			}
		}
		
		public String toString() {
			if (layout.compareToIgnoreCase("electric") == 0) {
				return "Electric";
			}
			else if (layout.compareToIgnoreCase("straight") == 0 || layout.compareToIgnoreCase("inline") == 0) {
				return layout + " " + Integer.toString(cylinders);
			}
			return layout + Integer.toString(cylinders);
		}
	}
	
	class Transmission {
		private String transmissionType;
		
		Transmission(String transmissionType){
			this.transmissionType = transmissionType;
		}
		
		public String toString() {
			return transmissionType;
		}
	}
	
	class Wheel{
		private Brakes brake;
		private Tire tire;
		
		Wheel(String tireBrand, double psi, String brakesBrand, Date lastReplaced){
			tire = new Tire(tireBrand, psi);
			brake = new Brakes(brakesBrand, lastReplaced);
		}
		
		class Tire{
			private String brand;
			private double recommendedPSI;
			
			Tire(String brand, double psi){
				this.brand = brand;
				recommendedPSI = psi;
			}
			
			public String toString() {
				return brand + "@" + Double.toString(recommendedPSI) + " psi";
			}
			
		}
		
		class Brakes{
			private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			private String brand;
			private Date lastReplaced;
			
			Brakes(String brand, Date dateOfLastReplacement){
				this.brand = brand;
				lastReplaced = dateOfLastReplacement;
			}
			
			public String toString() {
				return brand + ", Last replaced on " + formatter.format(lastReplaced);
			}
		}
		
		public String toString() {
			String brakes = brake.toString();
			String tires = tire.toString();
			return "Tires: " + tires + "\nBrakes: " + brakes;
		}
		
	}
	
	
	private void setLocationBuilt() {
		char locationBuiltVinChar = vin.charAt(0);
		locationBuilt = VIN_LOCATION_MANUFACTURER.get(locationBuiltVinChar);
	}
	
	private void setMake() {
		char makeVinChar = vin.charAt(1);
		make = VIN_MAKE.get(makeVinChar);
	}
	
	private void setBodyType() {
		char modelVinChar = vin.charAt(2);
		if (make.compareToIgnoreCase("honda") == 0) {
			type = VIN_TYPE_HONDA.get(modelVinChar);
		} 
		else if(make.compareToIgnoreCase("volkswagen") == 0) {
			type = VIN_TYPE_VW.get(modelVinChar);
		}
		else if (make.compareToIgnoreCase("general motors/chevrolet") == 0) {
			type = VIN_TYPE_GM.get(modelVinChar);
		}
		else if (make.compareToIgnoreCase("toyota") == 0) {
			type = VIN_TYPE_TOYOTA.get(modelVinChar);
		}
		else if (make.compareToIgnoreCase("ford") == 0) {
			type = VIN_TYPE_FORD.get(modelVinChar);
		}
		else if (make.compareToIgnoreCase("tesla") == 0) {
			type = VIN_TYPE_TESLA.get(modelVinChar);
		}
	}
	
	private void setEngineAndTransmission() {
		if (make.compareToIgnoreCase("tesla") == 0) {
			engine = new Engine("Electric", 0);
			transmission = new Transmission("Automatic");
		}
		else if (type.compareToIgnoreCase("sport") == 0 && year == 2005) {
			engine = new Engine("V", 6);
			transmission = new Transmission("Manual");
		}
		else if (type.compareToIgnoreCase("minivan") == 0) {
			engine = new Engine("V", 6);
			transmission = new Transmission("Automatic");
		}
		else if (type.compareToIgnoreCase("suv") == 0 && year == 1995) {
			engine = new Engine("V", 6);
			transmission = new Transmission("Automatic");
		}
		else if (type.compareToIgnoreCase("truck") == 0 && year == 2000) {
			engine = new Engine("V", 8);
			transmission = new Transmission("Manual");
		}
		else if (type.compareToIgnoreCase("truck") == 0 && year == 2010) {
			engine = new Engine("V", 8);
			transmission = new Transmission("Automatic");
		}
		else if (type.compareToIgnoreCase("sedan") == 0 && year == 2010) {
			engine = new Engine("V", 6);
			transmission = new Transmission("Automatic");
		}
		else {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter Engine type followed by number of cylinders (Separated by comma[,])");
			String[] eng = scan.nextLine().split(",");
			engine = new Engine(eng[0], Integer.parseInt(eng[1]));
			System.out.println("Enter \"Automatic\" or \"Manual\" for the transmission");
			String trans = scan.nextLine();
			transmission = new Transmission(trans);
			scan.close();
		}
	}
	
	private void setYear() {
		char yearVinChar = vin.charAt(9);
		year = VIN_YEAR.get(yearVinChar);
	}
	
	private void setVinValues() {
		setLocationBuilt();
		setMake();
		setBodyType();
		setYear();
		System.out.println(locationBuilt + " " + make + " " + type + " " + year);
	}
	
	private void setColor(String color) {
		this.color = color;
	}
	
	private void setModel(String model) {
		this.model = model;
	}
	
	public void setMissing(String model, String color, String tireBrand, double tirePSI, String brakesBrand, Date lastReplaced) {
		setEngineAndTransmission();
		setColor(color);
		setModel(model);
		wheel = new Wheel(tireBrand, tirePSI, brakesBrand, (Date)lastReplaced.clone());
	}
	
	public String toString() {
		String engineString = engine.toString();
		String transmissionString = transmission.toString();
		String wheelString = wheel.toString();
		
		return "VIN: " + vin + "\nBuild Location: " + locationBuilt + "\nYear: " + year + "\nType: " + type + "\nMake & Model: " + make + " " 
				+ model + "\nColor: " + color + "\nEngine: " + engineString + "\nTransmission: " + transmissionString + "\n" + wheelString + 
				"\n---------------------------------------";
		
	}
}
