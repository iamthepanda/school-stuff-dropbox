using UnityEngine;

using System;

public class RequestPlayer : NetworkRequest {

		public RequestPlayer() {
				request_id = Constants.CMSG_TEST;
		}

		public void send() {
				packet = new GamePacket (request_id);
				packet.addString ("REQUESTTEST STRING REQUEST SEND");
		}
}