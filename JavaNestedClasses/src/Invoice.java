
public class Invoice {
	public int ID;
	public String phoneNo;
	
	interface PhoneNumber {
		public void formatNumber();
		public String getNumber();
	}
	
	public Invoice(int ID) {
		this.ID = ID;
		this.phoneNo = null;
	}
	
	public void addPhoneNo(String phoneNo) throws Exception {
		try {
			validatePhoneNo(phoneNo);
		}
		catch (Exception e) {
			throw e;
		}
		
		this.phoneNo = phoneNo;
	}
	
	private void validatePhoneNo(String phoneNo) throws Exception {
		
		String regularExpression = "[^0-9]";
		int numberLength = 7;
		
		/*
		 class PhoneNumber {
			String formattedPhoneNumber = null;
			
			PhoneNumber(String phoneNumber){
				String currentNumber = phoneNumber.replaceAll(regularExpression,  "");
				if (currentNumber.length() == numberLength) {
					formattedPhoneNumber = currentNumber;
				}
				else {
					formattedPhoneNumber = null;
				}
			}
			
			public String getNumber() {
				return formattedPhoneNumber;
			}
		}
		*/
		
		PhoneNumber number = new PhoneNumber() {
			String formattedPhoneNumber = null;
			public void formatNumber() {
				String currentNumber = phoneNo.replaceAll(regularExpression,  "");
				if (currentNumber.length() == numberLength) {
					formattedPhoneNumber = currentNumber;
				}
				else {
					formattedPhoneNumber = null;
				}
			}
			
			public String getNumber() {
				return formattedPhoneNumber;
			}
		};
		
		number.formatNumber();
		
		if (number.getNumber() == null) {
			throw new NumberFormatException();
		}
		
		this.phoneNo = number.getNumber();
	}
}
