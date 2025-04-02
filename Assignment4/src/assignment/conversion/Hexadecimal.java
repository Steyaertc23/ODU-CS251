package assignment.conversion;

public class Hexadecimal {
    private String binaryString;
    private String hexValue;

    public Hexadecimal(){
        binaryString = "0000";
        hexValue = "0";
    }

    public Hexadecimal(String binary){
        this.binaryString = binary;
        hexValue = "";
    }

    public String getHexValue(){
        if (hexValue.charAt(0) == '0' && hexValue.length() > 1){
            return hexValue.substring(1);
        }
        return hexValue;
    }

    public String getBinaryString(){
        return binaryString;
    }

    public void setBinaryString(String binary){
        binaryString = binary;
    }

    private void correctLength(){
        while (binaryString.length() % 4 != 0){
            binaryString = "0" + binaryString;
        }
    }

    private String convertToHex(String byte_){
        return switch (byte_) {
            case "0000" -> "0";
            case "0001" -> "1";
            case "0010" -> "2";
            case "0011" -> "3";
            case "0100" -> "4";
            case "0101" -> "5";
            case "0110" -> "6";
            case "0111" -> "7";
            case "1000" -> "8";
            case "1001" -> "9";
            case "1010" -> "A";
            case "1011" -> "B";
            case "1100" -> "C";
            case "1101" -> "D";
            case "1110" -> "E";
            case "1111" -> "F";
            default -> "DNE";
        };
    }

    public void convert(){
        correctLength();
        for (int i = 0; i < binaryString.length(); i += 4){
            hexValue += convertToHex(binaryString.substring(i, i+4));
        }
    }

}
