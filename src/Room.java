public class Room {
    int floor;
    String floorName;
    public Room(int floor) {
        this.floor = floor;
    }

    public Room(int floor , String floorName) {
        this.floor = floor;
        this.floorName = floorName;
    }

    public int getFloor () {
        return floor;
    }

    public void setFloor (int set) {
        floor = set;
    }

    public void addFloor() {
        floor++;
    }

}
