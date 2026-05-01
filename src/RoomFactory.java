public class RoomFactory{
    public static Room createRoom(){
        int randomRoom = (int)(Math.random()*3);
        switch(randomRoom){
            case 0: return new NeutralRoom();
            case 1: return new FightRoom();
            case 2: return new HealRoom();
            default: throw new IllegalArgumentException("Invalid Room type.");
        }
    }
}