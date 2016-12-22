
using UnityEngine;

using System;
using System.Collections;
using System.IO;
using System.Net.Sockets;

using UnityEngine.SceneManagement;

public class SceneSwitch : MonoBehaviour {
	
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
	
	void Awake() {
		// mainObject = GameObject.Find("MainObject");
		mainObject = GameObject.Find("LoginObject");

		// mainObject.GetComponent<MessageQueue>().AddCallback(Constants.SMSG_AUTH, ResponseLogin);
	}
	
	// Use this for initialization
	void Start() {

	}
	
	void OnGUI() {
		
		if(GUI.Button(new Rect(Screen.width / 2 - 50, Screen.height-50, 100, 30), "Test Scene")) {
			SceneManager.LoadScene("TestScene");
		}
	}
	
	public void ToLoginScene() {
	}
	
	void MakeWindow(int id) {
		GUILayout.Label("User ID");
		GUI.SetNextControlName("username_field");
		user_id = GUI.TextField(new Rect(10, 45, windowRect.width - 20, 25), user_id, 25);

		GUILayout.Space(30);
		
		GUILayout.Label("Password");
		GUI.SetNextControlName("password_field");
		password = GUI.PasswordField(new Rect(10, 100, windowRect.width - 20, 25), password, "*"[0], 25);
		
		GUILayout.Space(75);

		if (GUI.Button(new Rect(windowRect.width / 2 - 50, 135, 100, 30), "Log In")) {
			Submit();
		}
	}
	
	public void Submit() {
		user_id = user_id.Trim();
		password = password.Trim();
		
		if (user_id.Length == 0) {
			Debug.Log("User ID Required");
			GUI.FocusControl("username_field");
		} else if (password.Length == 0) {
			Debug.Log("Password Required");
			GUI.FocusControl("password_field");
		} else {
			ConnectionManager cManager = mainObject.GetComponent<ConnectionManager>();
			
			if (cManager) {
				cManager.send(requestLogin(user_id, password));
			}
		}
	}
	
	public RequestLogin requestLogin(string username, string password) {
		RequestLogin request = new RequestLogin();
		request.send(username, password);
		
		return request;
	}
	
	public void ResponseLogin(ExtendedEventArgs eventArgs) {
		ResponseLoginEventArgs args = eventArgs as ResponseLoginEventArgs;
		
		if (args.status == 0) {
			Constants.USER_ID = args.user_id;
		} else {
			Debug.Log("Login Failed");
		}
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
