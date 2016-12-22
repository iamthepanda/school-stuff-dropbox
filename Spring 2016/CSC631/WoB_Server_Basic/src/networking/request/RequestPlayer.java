package networking.request;

// Java Imports
import java.io.IOException;
import java.io.DataInputStream;

// Other Imports
import core.GameClient;
import core.GameServer;
import metadata.Constants;
import model.Player;
import networking.response.ResponsePlayer;
import utility.DataReader;
import utility.Log;

/**
 * The RequestLogin class authenticates the user information to log in. Other
 * tasks as part of the login process lies here as well.
 */
public class RequestPlayer extends GameRequest {

    // Data
    private int numPlayers = GameServer.getInstance().getActivePlayers().size();

    // Responses
    private ResponsePlayer responsePlayer;

    public RequestPlayer() {
        responses.add(responsePlayer = new ResponsePlayer());
    }

    @Override
    public void doBusiness() throws Exception {
        Log.printf("Number of connected players: %s", numPlayers);
        
        // Set response information
        responsePlayer.setNumPlayers((short) numPlayers);
    }

    @Override
    public void parse(DataInputStream dataInput) throws IOException {
    }
}