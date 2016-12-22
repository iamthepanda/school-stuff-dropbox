using UnityEngine;

using System;

public class RequestPlayer : NetworkRequest {

		public RequestPlayer() {
				request_id = Constants.CMSG_NUM_PLAYERS;
		}

		public void send() {
				packet = new GamePacket (request_id);
				packet.addString ("REQUESTPLAYER STRING REQUEST SEND");
		}
}