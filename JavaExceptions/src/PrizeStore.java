
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Set;
import java.util.Scanner;

/*
 * Only one PrizeStore may exist
 */
public class PrizeStore{

    private HashMap<Integer, Prize> prizes;
    private static Integer lastID = 0;

    private PrizeStore(){
        prizes = new HashMap<>();
    }

    private static class PrizeStoreInstance {
        private static final PrizeStore INSTANCE = new PrizeStore();
    }

    public static PrizeStore getInstance(){
        return PrizeStoreInstance.INSTANCE;
    }

    public void addPrizes(Path storeFile) throws IOException{
            Scanner scan = new Scanner(storeFile);

            while(scan.hasNext()){
                put(new Prize(scan.next(), scan.nextInt(), scan.nextInt()));
            }
            
            scan.close();
    }

    public Prize get(int k){
        return prizes.get(k);
    }

    public void put(Prize p){
        prizes.put(lastID++, p);
    }

    public Set<Integer> keys(){
        return prizes.keySet();
    }
    
    
}
