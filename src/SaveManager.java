import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class SaveManager {
    //shared across save manager instances
    private static final String SAVE_FILE = "resources/SaveData.json";

    public static void save() {
        //storing current game instance and player stats on that instance
        Game game = Game.getInstance();
        Player player = game.player;
        //writing into json file in correct json format
        String json = """
            {
                "userName": "%s",
                "userHealth": "%d",
                "maxHealth": "%d",
                "coins": "%d",
                "score": "%d",
                "foodCount": "%d",
                "drinkCount": "%d",
                "weaponType": "%s", 
                "difficulty": "%s"
            }
                """.formatted(player.getUserName(), player.getUserHealth(), player.getMaxHealth(), player.getCoinAmount(), player.getPlayerScore(), player.getFoodCount(), player.getDrinkCount(), player.getPlayerWeapon().getWeaponType(), game.getDifficulty());

        try (Writer writer = new FileWriter(SAVE_FILE)) {
            writer.write(json);
        } catch (IOException e) {
            System.out.println("Failed to save game.");
        }
    }
    //loads the data in the save file 
    public static boolean load() {
        File file = new File(SAVE_FILE);
        if (!file.exists()){
            return false;
        } 
        //individual JSON field set as hashmap 
        Map<String, String> fields = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            //reads file while there is a line to read/not null
            while ((line = reader.readLine()) != null) {
                line = line.trim().replace(",", "");
                //ensures line is a field first 
                if (line.startsWith("\"") && line.contains(": ")) {
                    //splits each line into array elements splitting at the :
                    String[] parts = line.split(": ", 2);
                    //replace escape key with nothing so hashmap has fields that an directly be put into setters
                    String key = parts[0].replace("\"", "");
                    String value = parts[1].replace("\"", "");
                    fields.put(key, value);
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to load save.");
            return false;
        }
        //sets player to weapon to either the weapon type field in the JSON file or sets player value to smart knife as default
        Weapon weapon = switch (fields.getOrDefault("weaponType", "Smart Knife")) {
            case "Pistol" -> new Pistol();
            case "Rifle" -> new Rifle();
            default -> new Melee();
        };
        //sets game values using the values paired with the keys and passing keys into setters
        Game game = Game.getInstance();
        game.setDifficulty(Integer.parseInt(fields.get("difficulty")));
        //setting player values also using key values within JSON and passing values through setters using key value pair from initialised hashMap
        Player player = new Player(
            fields.get("userName"),
            Integer.parseInt(fields.get("userHealth")),
            Integer.parseInt(fields.get("coins")),
            weapon,
            Integer.parseInt(fields.get("score"))
        );
        player.setMaxHealth(Integer.parseInt(fields.get("maxHealth")));
        player.setFoodCount(Integer.parseInt(fields.get("foodCount")));
        player.setDrinkCount(Integer.parseInt(fields.get("drinkCount")));
        game.player = player;
        return true;
    }

    public static boolean saveExists() {
        return new File(SAVE_FILE).exists();
    }

    public static boolean saveIsEmpty(){
        return new File(SAVE_FILE).length() == 0;
    }
}