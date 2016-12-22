package networking.request;

// Java Imports
import java.io.IOException;
import java.io.DataInputStream;

// Other Imports
import core.GameClient;
import core.GameServer;
import java.sql.Types;
import metadata.Constants;
import model.Player;
import networking.response.ResponseLogin;
import utility.DataReader;
import utility.Log;
import metadata.VerifiedUsers;

/**
 * The RequestLogin class authenticates the user information to log in. Other
 * tasks as part of the login process lies here as well.
 */
public class RequestLogin extends GameRequest {

    // Data
    private String version;
    private String user_id;
    private String password;
    // Responses
    private ResponseLogin responseLogin;

    public RequestLogin() {
        responses.add(responseLogin = new ResponseLogin());
    }

    @Override
    public void parse(DataInputStream dataInput) throws IOException {
        version = DataReader.readString(dataInput).trim();
        user_id = DataReader.readString(dataInput).trim();
        password = DataReader.readString(dataInput).trim();
        
        if (version.isEmpty() || user_id.isEmpty() || password.isEmpty()) {
            throw new IOException();
        }
    }

    @Override
    public void doBusiness() throws Exception {
        Log.printf("User '%s' is connecting...", user_id);

        Player player = null;
        
        // Checks if the connecting client meets the minimum version required
        if (version.compareTo(Constants.CLIENT_VERSION) >= 0) 
        {
            Log.printf("you are on client version %s", Constants.CLIENT_VERSION);
            if (!user_id.isEmpty()) {
                // Verification Needed
                Log.printf("verifying %s",user_id);
                
                if((user_id.equals(VerifiedUsers.user1)&&password.equals(VerifiedUsers.password1)) || (user_id.equals(VerifiedUsers.user2)&&password.equals(VerifiedUsers.password2)))
                    player = new Player(user_id.hashCode());
            }
            
            if (player == null) {
                responseLogin.setStatus((short) 1); // User info is incorrect
                Log.printf("User '%s' has failed to log in. player is null", user_id);
            } 
            else {
                if (client.getPlayer() != null){
                    
                    client.getPlayer().setID(player.getID()+1);
                    
                }
                    
                if (client.getPlayer() == null || player.getID() != client.getPlayer().getID()) {
                    GameClient thread;
                    if(client.getPlayer()==null)
                        thread = GameServer.getInstance().getThreadByPlayerID(player.getID());
                    else
                        thread = GameServer.getInstance().getThreadByPlayerID(client.getPlayer().getID());
                    
//                    thread = client;
                    
                    // If account is already in use, remove and disconnect the client
                    if (thread != null) {
                        responseLogin.setStatus((short) 2); // Account is in use
                        thread.removePlayerData();
                        thread.newSession();
                        Log.printf("User '%s' account is already in use.", user_id);
                    }
                    else {
                        // Continue with the login process
                        GameServer.getInstance().setActivePlayer(player);
                        player.setClient(client);
                        
                        // Pass Player reference into thread
                        client.setPlayer(player);
                        
                        // Set response information
                        responseLogin.setStatus((short) 0); // Login is a success
                        responseLogin.setPlayer(player);

                player.setUsername(user_id);
                        Log.printf("User '%s' has successfully logged in.", player.getUsername());
                        
                    }
                }
                
            }
        }
        
        else {
            responseLogin.setStatus((short) 3); // Client version not compatible
            Log.printf("User '%s' has failed to log in. (v%s)", player.getUsername(), version);
            Log.println("Client version not compatible");
        }

//        client.add(responseLogin);
    }
}
