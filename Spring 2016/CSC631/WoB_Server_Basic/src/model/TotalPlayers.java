package model;

// Other Imports
import core.GameClient;

/**
 * The Player class holds important information about the player including, most
 * importantly, the account. Such information includes the username, password,
 * email, and the player ID.
 */
public class TotalPlayers {

    private int total;
    
    private GameClient client; // References GameClient instance
    
    private short level = 0;
    private int gold = 0;

    public TotalPlayers(int numPlayers) {
        this.total = numPlayers;
    }

    public int getTotal() {
        return total;
    }

    public int setTotal(int numPlayers) {
        return this.total = numPlayers;
    }

    public GameClient getClient() {
        return client;
    }

    public GameClient setClient(GameClient client) {
        return this.client = client;
    }

    public int getLevel() {
        return level;
    }

    public int getGold() {
        return gold;
    }

    public int setLevel(short level) {
        return this.level =level;
    }

    public int setGold(int gold) {
        return this.gold = gold;
    }
    
    
}
