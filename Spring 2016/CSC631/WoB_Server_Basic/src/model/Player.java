package model;

// Other Imports
import core.GameClient;
import metadata.PlayerData;

/**
 * The Player class holds important information about the player including, most
 * importantly, the account. Such information includes the username, password,
 * email, and the player ID.
 */
public class Player {

    private int player_id;
    private String username;
    private String password;
    private GameClient client; // References GameClient instance
    
    private short level;
    private int gold;

    public Player(int player_id) {
        this.player_id = player_id;
    }

    public int getID() {
        return player_id;
    }

    public int setID(int player_id) {
        return this.player_id = player_id;
    }

    public String getPassword() {
        return password;
    }

    public String setPassword(String password) {
        return this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String setUsername(String username) {
        return this.username = username;
    }

    public GameClient getClient() {
        return client;
    }

    public GameClient setClient(GameClient client) {
        return this.client = client;
    }

    public short getLevel() {
        return level;
    }

    public int getGold() {
        return gold;
    }

    public short setLevel(short level) {
        return this.level = PlayerData.level;
    }

    public int setGold(int gold) {
        return this.gold = PlayerData.gold;
    }
    
    
}
