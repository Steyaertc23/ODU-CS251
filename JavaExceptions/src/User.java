
public class User{

    private String uID;
    private int tickets;

    public User(String uID, int tickets){
        this.uID = uID;
        this.tickets = tickets;
    }

    public String getUID(){
        return uID;
    }

    public int getTickets(){
        return tickets;
    }

    public void setTickets(int tickets){
        this.tickets = tickets;
    }

}
