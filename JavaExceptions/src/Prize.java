public class Prize{

    private String name;
    private int value;
    private int numRemaining;

    public Prize(String name, int value, int numRemaining){
        this.name = name;
        this.value = value;
        this.numRemaining = numRemaining;
    }

    public String getName(){
        return name;
    }

    public int getValue(){
        return value;
    }
    
    public int getNumRemaining() {
    	return numRemaining;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setValue(int value){
        this.value = value;
    }
    
    public void setNumRemaining(int numRemaining) {
    	this.numRemaining = numRemaining;
    }
}
