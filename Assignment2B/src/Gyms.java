
public class Gyms {
	
	private String name;
	private String addr;
	
	public Gyms (String name, String addr) {
		this.name = name;
		this.addr = addr;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddr() {
		return addr;
	}
	
	private String evenOutLines(int length, String s) {
		String temp = s;
		for (int i = 0; i < length-s.length(); i++) {
			temp += " ";
		}
		return temp + "|";
	}
	
	public String toString() {
		String toReturn = "|";
		
		toReturn += evenOutLines(20, name);
		toReturn += " ";
		
		toReturn += evenOutLines(24, addr);
		
		return toReturn;
	}

}
