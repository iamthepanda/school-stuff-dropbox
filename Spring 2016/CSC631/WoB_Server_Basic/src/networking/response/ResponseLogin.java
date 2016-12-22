package networking.response;

// Other Imports
import core.GameServer;
import metadata.Constants;
import model.Player;
import utility.GamePacket;
import utility.Log;

/**
 * The ResponseLogin class contains information about the authentication
 * process.
 */
public class ResponseLogin extends GameResponse {

    private short status;
    private Player player;
    
    private short level;
    private int gold;

    public ResponseLogin() {
        responseCode = Constants.SMSG_AUTH;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
        packet.addShort16(status);
        
        Log.printf("player status = %d", status);

        if (status == 0) {
            packet.addInt32(player.getID());
            packet.addString(player.getUsername());
            packet.addString("this was the last time you logged out");
            packet.addShort16(player.getLevel());
            packet.addInt32(player.getGold());
            packet.addInt32(GameServer.getInstance().getActivePlayers().size());
        } else
            Log.printf("%s",status);

        return packet.getBytes();
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setLevel(short level) {
        this.level = level;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}