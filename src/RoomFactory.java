public class RoomFactory{
    public static Room createRoom(){
        int randomRoom = (int)(Math.random()*2);
        switch(randomRoom){
            case 0: return new FightRoom();
            case 1: return new HealRoom();
            default: throw new IllegalArgumentException("Invalid Room type.");
        }
    }
}