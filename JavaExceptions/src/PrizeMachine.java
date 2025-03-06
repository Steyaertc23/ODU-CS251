import exceptions.RequestedItemException;

public class PrizeMachine{

    private PrizeStore prizes;

    public PrizeMachine(PrizeStore prizes){
        this.prizes = prizes;
    }

    public PrizeStore getPrizes(){
        return prizes;
    }
    
    public void printPrizeStore() {
    	
    	for (var k : prizes.keys()) {
    		Prize p = prizes.get(k);
    		
    		System.out.printf("%d) %s \n\tValue: %d tickets \n\tStock: %d left\n", 
    				k, p.getName(), p.getValue(), p.getNumRemaining());
    	}
    }
    
    public boolean vendItem(int item) throws RequestedItemException {
    	if (prizes.get(item).getNumRemaining() < 1) {
    		throw new RequestedItemException(prizes.get(item).getName());
    	}
    	
    	else {
    		return true;
    	}
    }
}
