using UnityEngine;
using System.Collections;

using System;
using System.IO;
using System.Net.Sockets;
using System.Security.Cryptography;
using System.Text;

// using UnityEngine.SceneManagement;

public class ConnectionManager : MonoBehaviour {

	private GameObject mainObject;
	private TcpClient mySocket;
	private NetworkStream theStream;
	private bool socketReady = false;

	void Awake() {
		mainObject = GameObject.Find ("LoginObject");
	}

	// Use this for initialization
	void Start() {
		setupSocket ();
	}

	public void setupSocket() {
		if (socketReady) {
			Debug.Log ("You are Connected");
			return;
		}

		try {
			mySocket = new TcpClient (Constants.REMOTE_HOST, Constants.REMOTE_PORT);
			theStream = mySocket.GetStream ();
			socketReady = true;

			Debug.Log ("Server socket is ready");
		} catch (Exception e) {
			Debug.Log ("Socket error: " + e);
//						print (mySocket);
		}
	}
	
	public void readSocket() {
			
		if (!socketReady) {
			Debug.Log("Socket not ready");
			return;
		}

//				print (theStream.DataAvailable);
		if (theStream.DataAvailable) {
//						print ("stuff");
			byte[] buffer = new byte[2];
			theStream.Read (buffer, 0, 2);
			short bufferSize = BitConverter.ToInt16 (buffer, 0);

			buffer = new byte[bufferSize];
			theStream.Read (buffer, 0, bufferSize);
			MemoryStream dataStream = new MemoryStream (buffer);

			short response_id = DataReader.ReadShort (dataStream);

			NetworkResponseTable.init();

			NetworkResponse response = NetworkResponseTable.get (response_id);

			if (response != null) {
				response.dataStream = dataStream;

				response.parse ();
				ExtendedEventArgs args = response.process ();

				if (args != null) {
					MessageQueue msgQueue = mainObject.GetComponent<MessageQueue> ();
					msgQueue.AddMessage (args.event_id, args);
				}
			}
		}

	}

	public void closeSocket() {
		if (!socketReady) {
			return;
		}
		mySocket.Close ();
		socketReady = false;
	}

	public void send(NetworkRequest request) {
		if (!socketReady) {
			return;
		}
		GamePacket packet = request.packet;

		byte[] bytes = packet.getBytes ();
		theStream.Write (bytes, 0, bytes.Length);

		if (request.request_id != Constants.CMSG_HEARTBEAT) {
			Debug.Log ("Sent Request No. " + request.request_id + " [" + request.ToString () + "]");
		}
	}

	// Update is called once per frame
	void Update() {
		readSocket ();
	}
}
