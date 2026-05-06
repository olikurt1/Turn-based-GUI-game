import java.util.Scanner;
public abstract class Room{
    protected String roomType;

    public Room(String roomType){
        this.roomType = roomType;
    }
    public String getRoomType(){
        return roomType;
    }
    public void setRoomType(String roomType){
        this.roomType = roomType;
    }

    public abstract void playerEnter(Player player, Scanner input);
}