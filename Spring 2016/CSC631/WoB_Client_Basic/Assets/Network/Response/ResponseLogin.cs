using UnityEngine;

using System;

public class ResponseLoginEventArgs : ExtendedEventArgs {
	public short status { get; set; }
	public int user_id { get; set; }
	public string username { get; set; }
	public string last_logout { get; set; }
	public short level { get; set; }
	public int gold { get; set; }
	public int totalConnected { get; set; }
	
	public ResponseLoginEventArgs() {
		// Debug.Log("ResponseLoginEventArgs");
		event_id = Constants.SMSG_AUTH;
	}
}

public class ResponseLogin : NetworkResponse {
	
	private short status;
	private int user_id;
	private string username;
	private string last_logout;
	
	private short level;
	private int gold;
	private int totalConnected;
	private string testString = "stuff";

	public ResponseLogin() {
	}
	
	public override void parse() {
		status = DataReader.ReadShort(dataStream);
		
		if (status == 0) {
			user_id = DataReader.ReadInt(dataStream);
			username = DataReader.ReadString(dataStream);
			last_logout = DataReader.ReadString(dataStream);
			level = DataReader.ReadShort(dataStream);
			gold = DataReader.ReadInt(dataStream);
			totalConnected = DataReader.ReadInt(dataStream);
			testString = DataReader.ReadString(dataStream);
			
			Debug.Log("Server Response:"
				+"\nusername " + username
				+"\nlast_logout " + last_logout
				+"\nlevel " + level
				+"\ngold " + gold
				+"\ntotal connected players " + totalConnected
				+"\ntestString " + testString
				+"\nEnd server response");
		}
	}
	
	public override ExtendedEventArgs process() {
		ResponseLoginEventArgs args = null;

		if (status == 0) {
			args = new ResponseLoginEventArgs();
			args.status = status;
			args.user_id = user_id;
			args.username = username;
			args.last_logout = last_logout;
			args.level = level;
			args.gold = gold;
			args.totalConnected = totalConnected;
		}

		return args;
	}
}