import java.util.ArrayList;

public class Chest {
    private ArrayList<Treasure> loot = new ArrayList<>();

    public Chest() {
    }
    public void setChestLoot(ArrayList<Treasure> loot) {
        this.loot = loot;
    }

    public ArrayList<Treasure> getLoot() {
        return loot;
    }
}

