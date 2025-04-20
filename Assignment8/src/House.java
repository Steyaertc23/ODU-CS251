import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class House {
    private List<Room> rooms;

    public House() {
        this.rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }
    
    public void addHouse(Scanner scanner) {
        System.out.println("Insert information");
        System.out.print("How many rooms are in the house: ");
        int numRooms = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < numRooms; i++) {
            System.out.print("Enter the angles of the room separated by a space: ");
            String[] angleStrs = scanner.nextLine().split(" ");
            System.out.print("Enter the sides of the room separated by a space: ");
            String[] sideStrs = scanner.nextLine().split(" ");
            
            // logic to add room based on sides and angles
            // maybe: this.rooms.add(new RectangleRoom(...)) or CircleRoom(...)
            float[] sides = new float[sideStrs.length];
            for (int j = 0; j < sides.length; j++) {
                sides[j] = Float.parseFloat(sideStrs[j]);
            }
            
            float[] angles = new float[angleStrs.length];
            for (int j = 0; j < sides.length; j++) {
                angles[j] = Float.parseFloat(angleStrs[j]);
            }
        
            List<Furniture> furniture = new ArrayList<>();
	        System.out.print("Do you want to add a piece of furniture? ");
	        String addFurniture = scanner.nextLine();
	
	        while (addFurniture.equalsIgnoreCase("yes")) {
	            // gather furniture details
	            System.out.print("Enter Name: ");
	            String name = scanner.nextLine();
	            System.out.print("Enter cost: ");
	            float cost = scanner.nextFloat();
	            System.out.print("Enter description: ");
	            scanner.nextLine(); // consume newline
	            String desc = scanner.nextLine();
	            System.out.print("Enter height: ");
	            float height = scanner.nextFloat();
	            System.out.print("Enter width: ");
	            float width = scanner.nextFloat();
	            System.out.print("Enter weight: ");
	            float weight = scanner.nextFloat();
	            scanner.nextLine(); // consume newline
	
	            // add furniture
	            Furniture f = new Furniture(name, desc, cost, height, width, weight);
	            // maybe: add to last room, or ask which room to add to
	            furniture.add(f);
	            System.out.print("Do you want to add another piece of furniture? ");
	            addFurniture = scanner.nextLine();
	        }
	        
	        Room room;
	        if (sides.length == 1 && angles[0] == 360 && angles.length == 1) {
	            room = new CircleRoom(sides[0], furniture);
	        } else if (sides.length == 3 && angles.length == 3) {
	            room = new TriangleRoom(sides, furniture);
	        } else {
	            room = new RectangleRoom(sides[0], sides[1], furniture);
	        }
	        this.addRoom(room);
        }
    }
    
    


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        float totalSquareFootage = 0;

        // Map room types to lists of rooms
        Map<String, List<Room>> roomTypeMap = new HashMap<>();

        for (Room room : rooms) {
            String type = room.getRoomType();
            roomTypeMap.putIfAbsent(type, new ArrayList<>());
            roomTypeMap.get(type).add(room);

            totalSquareFootage += room.calculateSquareFootage();
        }

        sb.append("Total Square Footage of House: ")
          .append(totalSquareFootage)
          .append("\n\n");

        for (Map.Entry<String, List<Room>> entry : roomTypeMap.entrySet()) {
            String roomType = entry.getKey();
            List<Room> roomList = entry.getValue();

            sb.append(roomType).append(":\n");
            for (int i = 0; i < roomList.size(); i++) {
                sb.append("\tRoom ").append(i + 1).append(":\n")
                  .append(roomList.get(i).toString()).append("\n");
            }
        }

        return sb.toString();
    }
}
