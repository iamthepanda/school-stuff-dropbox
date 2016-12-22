using UnityEngine;

using System;
using System.Collections;
using System.IO;
using System.Net.Sockets;

using UnityEngine.SceneManagement;

public class Login : MonoBehaviour {
	
		private GameObject mainObject;
		// Window Properties
		private float width = 280;
		private float height = 100;
		// Other
		public Texture background;
		private string user_id = "";
		private string password = "";
		private Rect windowRect;
		private bool isHidden;

		bool submitonce = false;

		void Awake() {
				mainObject = GameObject.Find ("LoginObject");

				mainObject.AddComponent<ConnectionManager> ();
				
				mainObject.AddComponent<MessageQueue> ();
				mainObject.GetComponent<MessageQueue> ().AddCallback (Constants.SMSG_AUTH, ResponseLogin);
				mainObject.GetComponent<MessageQueue> ().AddCallback (Constants.SMSG_NUM_PLAYERS, ResponsePlayer);
		}
	
		// Use this for initialization
		void Start() {
//				Debug.Log ("Login.cs Started");
		}

		void OnGUI() {
				// Background
				GUI.DrawTexture (new Rect (0, 0, Screen.width, Screen.height), background);
		
				// Client Version Label
				GUI.Label (new Rect (Screen.width - 75, Screen.height - 30, 65, 20), "v" + Constants.CLIENT_VERSION + " Test");
		
				// Login Interface
				if (!isHidden) {
						windowRect = new Rect ((Screen.width - width) / 2, Screen.height / 2 - height, width, height);
						windowRect = GUILayout.Window ((int)Constants.GUI_ID.Login, windowRect, MakeWindow, "Login");
		
//						if (Event.current.type == EventType.KeyUp && Event.current.keyCode == KeyCode.Return) {
						if (submitonce == false){
								submitonce = true;
								Submit ();
						}
//						}
				}

				if (GUI.Button (new Rect (Screen.width / 2 - 50, Screen.height - 50, 100, 30), "Test Scene")) {
						SceneManager.LoadScene ("TestScene");
				}
		}

		public void ToTestScene() {
		}

		void MakeWindow(int id) {
				GUILayout.Label ("User ID");
				GUI.SetNextControlName ("username_field");
				user_id = GUI.TextField (new Rect (10, 45, windowRect.width - 20, 25), user_id, 25);

				GUILayout.Space (30);
		
				GUILayout.Label ("Password");
				GUI.SetNextControlName ("password_field");
				password = GUI.PasswordField (new Rect (10, 100, windowRect.width - 20, 25), password, "*" [0], 25);
		
				GUILayout.Space (75);

				if (GUI.Button (new Rect (windowRect.width / 2 - 50, 135, 100, 30), "Log In")) {
						Submit ();
				}
		}

		public void Submit() {
				// user_id = "bobby";
				// password = "123456";
		
				if (user_id.Length == 0) {
						Debug.Log ("User ID Required");
						GUI.FocusControl ("username_field");
				} else if (password.Length == 0) {
						Debug.Log ("Password Required");
						GUI.FocusControl ("password_field");
				} else {
						ConnectionManager cManager = mainObject.GetComponent<ConnectionManager> ();
			
						if (cManager) {
								cManager.send (requestLogin (user_id, password));
								
								cManager.send(requestPlayer());
						}
				}
				
				
		}

		public RequestPlayer requestPlayer() {
				RequestPlayer request = new RequestPlayer ();
				request.send ();

				return request;
		}

		public void RequestPlayer() {
		}

		public RequestLogin requestLogin(string username, string password) {
				RequestLogin request = new RequestLogin ();
				request.send (username, password);

//				print (request);

				return request;
		}

		public void ResponseLogin(ExtendedEventArgs eventArgs) {
				ResponseLoginEventArgs args = eventArgs as ResponseLoginEventArgs;
		
				if (args.status == 0) {
						Constants.USER_ID = args.user_id;
				} else {
						Debug.Log ("Login Failed");
				}
		}

		public void ResponsePlayer(ExtendedEventArgs eventArgs) {
				ResponsePlayerEventArgs args = eventArgs as ResponsePlayerEventArgs;
		}

		public void Show() {
				isHidden = false;
		}

		public void Hide() {
				isHidden = true;
		}
	
		// Update is called once per frame
		void Update() {
		}
}
