import java.util.Scanner;
public class HealRoom extends Room{
    public HealRoom(){
        super("Heal Room");
    }
    public void playerEnter(Player player, Scanner input){
        drink drink = new drink();
        if(player.getCoinAmount() < drink.getDrinkCost()){
            System.out.println("You don't have enough funds for any healing unfortunately\nContinuing to next room.");
        }
        else{
            boolean healChoiceFunds = false;
            System.out.print("Choose your healable!!\n1. Food for \n2. Drink\n>");
            while(healChoiceFunds == false){
                try{
                    int playerHealChoice = input.nextInt();
                    input.nextLine();
                    switch(playerHealChoice){
                        case 1 ->{
                            food f = new food();
                            if(player.getCoinAmount() < f.getFoodCost()){
                                System.out.println("Insufficient Funds for food!!");
                            }
                            else{
                                System.out.println("You have chosen food healable.");
                                f.heal(player);
                                healChoiceFunds = true;
                            }
                        }
                        case 2 ->{
                            System.out.println("You have chosen drink healable.");
                            drink.heal(player);
                            healChoiceFunds = true;
                        }
                    }    
                }
                catch(Exception e){
                    ErrorHandler.handleInputError(e);
                }
            }
        }
    }
}