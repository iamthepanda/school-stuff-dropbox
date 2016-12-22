using UnityEngine;

using System;

public class ResponsePlayerEventArgs : ExtendedEventArgs {
	public short numPlayers { get; set; }
	
	public ResponsePlayerEventArgs() {
		event_id = Constants.SMSG_NUM_PLAYERS;
	}
}

public class ResponsePlayer : NetworkResponse {
	
	private short numPlayers;

	public ResponsePlayer() {
	}
	
	public override void parse() {
		numPlayers = DataReader.ReadShort(dataStream);
	
			Debug.Log("Server Response:"
				+"\nnumPlayers " + numPlayers
				+"\nEnd server response");
	}
	
	public override ExtendedEventArgs process() {
		ResponsePlayerEventArgs args = null;

		args = new ResponsePlayerEventArgs();
		args.numPlayers = numPlayers;

		return args;
	}
}