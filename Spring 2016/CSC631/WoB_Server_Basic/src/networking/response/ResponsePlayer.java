package networking.response;

// Other Imports
import metadata.Constants;
import utility.GamePacket;
import utility.Log;

/**
 * The ResponseLogin class contains information about the authentication
 * process.
 */
public class ResponsePlayer extends GameResponse {

    private short numPlayers;
    
    public ResponsePlayer() {
        responseCode = Constants.SMSG_NUM_PLAYERS;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
        packet.addShort16(numPlayers);
        
        Log.printf("numPlayers = %d", numPlayers);

        return packet.getBytes();
    }

    public void setNumPlayers(short numPlayers) {
        this.numPlayers = numPlayers;
    }
}