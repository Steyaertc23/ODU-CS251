package assignment.conversion;

public class Decimal {
    private String binaryString;
    private int decimalValue;
    
    public Decimal(){
        this.binaryString = "0000";
        decimalValue = 0;
    }

    public Decimal(String binary){
        this.binaryString = binary;
        decimalValue = 0;
    }

    public int getDecimalValue(){
        return decimalValue;
    }

    public String getBinaryString(){
        return binaryString;
    }

    public void setBinaryString(String binary){
        binaryString = binary;
    }

    public void convert(){
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1'){
                decimalValue += Math.pow(2, binaryString.length() - 1 - i);
            }
        }
    }


}
