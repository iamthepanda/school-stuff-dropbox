package networking.request;

// Java Imports
import java.io.IOException;
import java.io.DataInputStream;

// Other Imports
import core.GameClient;
import core.GameServer;
import metadata.Constants;
import model.Player;
import networking.response.ResponseTest;
import utility.DataReader;
import utility.Log;

/**
 * The RequestLogin class authenticates the user information to log in. Other
 * tasks as part of the login process lies here as well.
 */
public class RequestTest extends GameRequest {

    // Data
    private int newTestVar = GameClient.newTestVar;

    // Responses
    private ResponseTest responseTest;

    public RequestTest() {
        responses.add(responseTest = new ResponseTest());
    }

    @Override
    public void doBusiness() throws Exception {
        Log.printf("Number of connected players: %s", newTestVar);
        
        // Set response information
        responseTest.setNumPlayers((short) newTestVar);
    }

    @Override
    public void parse(DataInputStream dataInput) throws IOException {
    }
}