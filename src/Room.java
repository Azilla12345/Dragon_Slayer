public class Room {
    int room;
    String floorName;
    public Room(int floor) {
        this.room = floor;
    }

    public void setFloorName(int level) {
        String[] names = new String[5];
        names[0] = "The opening";
        names[1] = "The mouth";
        names[2] = "The lair";
        names[3] = "The den";
        names[4] = "The nest";

        floorName = names[level];
    }

    public String getFloorName() {
        return  floorName;
    }

    public int getFloor () {
        return room;
    }

    public void setFloor (int set) {
        room = set;
    }

    public void addFloor() {
        room++;
        setFloorName(room);
    }

}
