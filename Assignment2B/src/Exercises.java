
public class Exercises {
	private String name;
	private String type;
	private String muscleGroup;
	private boolean usesMachine;
	
	public Exercises(String name, String type, String muscleGroup, boolean usesMachine) {
		this.name = name;
		this.type = type;
		this.muscleGroup = muscleGroup;
		this.usesMachine = usesMachine;
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public String getMuscleGroup() {
		return muscleGroup;
	}
	
	public boolean getUsesMachine() {
		return usesMachine;
	}
	
	private String evenOutLines(int length, String s) {
		String temp = s;
		for (int i = 0; i < length-s.length(); i++) {
			temp += " ";
		}
		return temp + "|";
	}
	
	private String evenOutLines(int length, boolean b) {
		String temp = Boolean.toString(b);
		for (int i = 0; i < length-Boolean.toString(b).length(); i++) {
			temp += " ";
		}
		return temp + "|";
	}
	
	public String toString() {
		String toReturn = "|";
		
		toReturn += evenOutLines(30, name);
		
		toReturn += evenOutLines(8, type);
		
		toReturn += evenOutLines(10, muscleGroup);
		
		toReturn += evenOutLines(5, usesMachine);
		
		return toReturn;
	}
	
}
