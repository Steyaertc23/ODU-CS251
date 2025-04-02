import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.math.BigDecimal;

public class Converter {
	private ArrayList<String> maxSpentFile = new ArrayList<>();
	private ArrayList<Double> maxSpentTotal = new ArrayList<>();
	
	
	public Converter() {
		maxSpentTotal.add(0.0);
		maxSpentFile.add(null);
	}
	
	// Checks if the given amount is greater than the current max 
	private void maxSpent(Double usd, File f) {
		double max;
		max = maxSpentTotal.get(0);
		if (usd.compareTo(max) == 1) {
			maxSpentFile.clear();
			maxSpentFile.add(f.getName());
			maxSpentTotal.clear();
			maxSpentTotal.add(usd);
		}
		
	}
	
	
	// Conversion Methods
	
	private String rounded(double conversion) {
		DecimalFormat df_obj = new DecimalFormat("#.##");
		return df_obj.format(conversion);
	}
	
	private double convertToEuro(double maxSpent) {
		double euroConversionFactor = 1.03;
		double conversion = maxSpent / euroConversionFactor;
		double convertedAndRounded = Double.parseDouble(rounded(conversion));
		return convertedAndRounded;
	}
	
	private double convertToYen(double usd) {
		double yenConversionFactor = 0.0071;
		double conversion = usd / yenConversionFactor;
		double convertedAndRounded = Double.parseDouble(rounded(conversion));
		return convertedAndRounded;
	}
	
	private double convertToRupee(double usd) {
		double rupeeConversionFactor = 0.012;
		double conversion = usd / rupeeConversionFactor;
		double convertedAndRounded = Double.parseDouble(rounded(conversion));
		return convertedAndRounded;
	}
	
	private double convertToCAD(double usd) {
		double cadConversionFactor = 0.75;
		double conversion = usd / cadConversionFactor;
		double convertedAndRounded = Double.parseDouble(rounded(conversion));
		return convertedAndRounded;
	}
	
	private double convertToWon(double usd) {
		double wonConversionFactor = 0.051;
		double conversion = usd / wonConversionFactor;
		double convertedAndRounded = Double.parseDouble(rounded(conversion));
		return convertedAndRounded;
	}
	
	private BigDecimal convertToPeso(double usd) {
		double pesoConversionFactor = 0.00075;
		double conversion = usd / pesoConversionFactor;
		BigDecimal convertedAndRounded = new BigDecimal(rounded(conversion));
		return convertedAndRounded;
	}
	
	
	// Reads given file and converts USD to the 6 other currencies 
	private void readFileAndConvert(File f, File convertTo) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(f));
			double nextSpent;
			double totalSpent = 0;
			
			String line;
			while((line = reader.readLine()) != null) {
				nextSpent = Double.parseDouble(rounded(Double.parseDouble(line)));
				totalSpent += nextSpent;
				
				
				
				
				double euro = convertToEuro(nextSpent);
				double yen = convertToYen(nextSpent);
				double rupee = convertToRupee(nextSpent);
				double cad = convertToCAD(nextSpent);
				double won = convertToWon(nextSpent);
				BigDecimal peso = convertToPeso(nextSpent);
				
				
				
				
				try (FileWriter fw = new FileWriter(convertTo, true)){
					fw.write("USD: " + Double.toString(nextSpent) + "\tEuro: " + Double.toString(euro) + "\tJapanese Yen: " + 
							Double.toString(yen) + "\tIndian Rupee: " + Double.toString(rupee) + "\tCanadian Dollar: " + Double.toString(cad) 
							+ "\tMexican Peso: " + peso.toPlainString() + "\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				double roundedSpent = new BigDecimal(rounded(totalSpent)).doubleValue(); 
				maxSpent(roundedSpent, f);
			}
			
			
			reader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	private String maxSpentOutput(){
		char newLine = '\n';
		String output;
		
		BigDecimal maxSpent = new BigDecimal(rounded(maxSpentTotal.get(0)));
		
		String file = maxSpentFile.get(0);
		
		
		double euro = convertToEuro(maxSpent.doubleValue());
		double yen = convertToYen(maxSpent.doubleValue());
		double rupee = convertToRupee(maxSpent.doubleValue());
		double cad = convertToCAD(maxSpent.doubleValue());
		double won = convertToWon(maxSpent.doubleValue());
		BigDecimal peso = convertToPeso(maxSpent.doubleValue());
		
		
		output = "File with most: " + file + newLine + "USD: " + maxSpent + newLine + "Euro: " + euro + newLine + "Yen: " + yen + newLine 
				 + "Rupee: " + rupee + newLine + "CAD: " + cad + newLine + "Won: " + won + newLine + "Peso: " + peso + newLine;
		
		
		return output;
	}
	
	
	
	// Runs all conversions and outputs file with max spent
	public void run() {
		//Check if converted file exists, if it does, delete it
		File convertTo = new File("." + File.separator + "data" + File.separator + "Converted.txt");
		
		if (convertTo.exists()) {
			convertTo.delete();
		}
		
		//Convert and output
		for (int i = 1; i < 6; i++) {
			File file = new File("." + File.separator + "data" + File.separator + "Currency" + i + ".txt");
			readFileAndConvert(file, convertTo);
		}
		
		System.out.println(maxSpentOutput());
		
	}
}
