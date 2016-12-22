package networking.response;

// Other Imports
import metadata.Constants;
import utility.GamePacket;
import utility.Log;

/**
 * The ResponseLogin class contains information about the authentication
 * process.
 */
public class ResponseTest extends GameResponse {

    private short newTestVar;
    
    public ResponseTest() {
        responseCode = Constants.SMSG_TEST;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
        packet.addShort16(newTestVar);
        
        Log.printf("numPlayers = %d", newTestVar);

        return packet.getBytes();
    }

    public void setNumPlayers(short newTestVar) {
        this.newTestVar = newTestVar;
    }
}