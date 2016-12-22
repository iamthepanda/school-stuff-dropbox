using UnityEngine;
using System.Collections;

using UnityEngine.SceneManagement;

/*upon execution
	Store the existing terrain position, then 
 	remove the terrain from the scene.
	
	Instantiate a new, but same terrain at the 
	stored position.
*/

public class TestSceneScript : MonoBehaviour {

	private GameObject currentGameObject;
	private Vector3 terrainPosition;
	private TerrainData _TerrainData;
	private TerrainCollider terrainCollider;
	private Terrain terrain;

	private GameObject newGameObject;
	private TerrainData newTerrainData;
	private TerrainCollider newTerrainCollider;
	private Terrain newTerrain;


	// string stored = "";

	//Store the existing terrain position
	void StoreGameObjectData() {
		// newGameObject = new GameObject();
		// newTerrainData = new TerrainData();
		// newTerrainCollider = new TerrainCollider();
		// newTerrain = new Terrain();

		currentGameObject = GameObject.Find ("MaasaiMara");

		terrainPosition = currentGameObject.transform.position;

		// Terrain.activeTerrain.terrainData = new TerrainData();


		_TerrainData = Terrain.activeTerrain.terrainData;

		// newTerrainData = Terrain.activeTerrain.terrainData;

		terrainCollider = Terrain.activeTerrain.gameObject.GetComponent<TerrainCollider>();

		// terrain = currentGameObject.GetComponent<Terrain>();
		terrain = Terrain.activeTerrain;
		terrainCollider.terrainData = _TerrainData;
		terrain.terrainData = _TerrainData;


		// stored = Terrain.activeTerrain.terrainData.name;
		_TerrainData = (TerrainData) Object.Instantiate(Terrain.activeTerrain.terrainData);

	}

	//remove the terrain from the scene
	void RemoveTerrain() {
		// DestroyImmediate (currentGameObject);
		// Destroy (currentGameObject);
		// DontDestroyOnLoad (currentGameObject);
		// Destroy (Terrain.activeTerrain);
		DontDestroyOnLoad (Terrain.activeTerrain);
	}

	void InstantiateNewGameObject() {
		newGameObject = GameObject.Find ("MaasaiMara");
		newGameObject.name = "2";

		Instantiate(terrain,terrainPosition,Quaternion.identity);

		newTerrainData = (TerrainData) Object.Instantiate(_TerrainData);
		Terrain.activeTerrain.terrainData = newTerrainData;
		newTerrainCollider = terrainCollider;
		newTerrainCollider.terrainData = newTerrainData;

		Destroy(newGameObject);
	}

	// Use this for initialization
	void Start () {
		StoreGameObjectData();

		RemoveTerrain();

		InstantiateNewGameObject();

		// RemoveTerrain();
	}
	
	// Update is called once per frame
	void Update () {
	}

	void OnGUI() {
		
		if(GUI.Button(new Rect(Screen.width / 2 - 50, Screen.height-50, 100, 30), "Test Scene")) {
			SceneManager.LoadScene("Login");
		}
	}
}
